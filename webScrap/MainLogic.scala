import org.jsoup._
import org.jsoup.nodes.Element
import collection.JavaConverters._

import java.io.{File, PrintWriter}

import scala.util.matching.Regex.Match
import scala.collection.mutable.Buffer

import Utils._
import JsoupUtil._
import JsonUtil._

object MainLogic extends App{

	val urlstr = "http://suumo.jp/ikkodate/tokyo/sc_setagaya/"
	val NONE = "None"

	val urlList = createUrlList(getMaxPageNo(urlstr))
	
	createJsonFile(urlList)

	def getMaxPageNo(urlstr : String): Int = {
		val main_jsoup_con = Jsoup.connect(urlstr)
	    val element = main_jsoup_con.get.select(".pagination").asScala.head
		var pageCntStr = ""
		val dateP1 = "[0-9]* ".r		

		dateP1.findAllIn(element.text).matchData.foreach { m =>	
			pageCntStr = m.toString.trim
		}

		println("[SUMO][世田谷区][最大ページ数]：" + pageCntStr)
		pageCntStr.toInt
		//return 1
	}

	def createUrlList(maxPageNo : Int): List[String] = {
		import collection.mutable.ListBuffer
		var b = new ListBuffer[String]
		for(iPage <- 1 to maxPageNo){
			var createdUrl = createUrl(iPage.toString)
			println("[SUMO][世田谷区][URL][" + iPage + "]：" + createdUrl)
			b += createdUrl
		}
		b.toList
	}

	def createJsonFile (list : List[String]) {
		val jsonStr = createJsonString(list)
	    val file = new PrintWriter(new File("./json/output_sumo.json"))
	    file.print(jsonStr)
		file.close
	}

	def createUrl (pageNo : String) = urlstr + "pnz1" + pageNo + ".html"

	def createJsonString (list : List[String]): String = {	
		import collection.immutable.ListMap
		var b = new StringBuilder()
		list.par.map { url =>
			val jsoup = start(url, ".property_unit-content")			 
			jsoup.par.map { m =>
				//タイトル、詳細画面url、画像、販売価格、所在地、駅、土地面積、間取り
				val docJson = ListMap[String, String](
					"title"      -> getTitle(m),
					"detail_url" -> getDetailUrl(m),
					"img" 		 -> getImg(m),
					"minPrice"   -> getMinPrice(m),
					"maxPrice"   -> getMaxPrice(m),
					"address"    -> getAddress(m),
					"station" 	 -> getStation(m),
					"minSpace" 	 -> getMinSpace(m),	
					"maxSpace" 	 -> getMaxSpace(m),	
					"roomLayout" -> getRoomLayout(m)
				)

				println("\n======")

				b ++= getDefIndexJson
				b ++= "\n{"
				docJson.foreach { case(key, value) =>
					b ++= getDocJson(key, value)
					if (key != "roomLayout") b ++= ","
					println(key + "：" + value)	
				}
				b ++= "}\n"
			}
		}
		b.toString
	}

	def optCheck(o: Option[Match]) = {
		o match {
			case Some(s) => o.get.group(1)
			case None => NONE
		}
    }


    def getItem (target: String, regexStr: String): String = {
    	val doc = regexStr.r.findFirstMatchIn(target)
    	optCheck(doc)
    }

    def getTitle      (e : Element): String = getItem(e.toString, """<h2 class="property_unit-title">.*<a.*>(.*)</a></h2>""")
    def getDetailUrl  (e : Element): String = getItem(e.toString, """<h2 class="property_unit-title">.*<a href="(.*)" target""")
    def getImg        (e : Element): String = getItem(e.toString, """rel="(.*)" alt""").replaceAll("amp;","")
    def getAddress    (e : Element): String = getItem(e.toString, """所在地\n.*\n.*\n\s+?(\S.*)""")
    def getStation    (e : Element): String = getItem(e.toString, """沿線・駅\n.*\n.*\n\s+?(\S.*)""")	
    def getMinSpace   (e : Element): String = getItem(e.toString, """土地面積\n.*\n.*\n\s+?(\S.*)m""")
	def getRoomLayout (e : Element): String = getItem(e.toString, """間取り\n.*\n.*\n\s+?(\S.*)""")
    def getMaxSpace   (e : Element): String = {
    	val result = getItem(e.toString, """土地面積\n.*\n.*\n.*\n.*</sup>[～|・](.*)m""")
    	if (isNone(result)) return getMinSpace(e) else result
    }

    def getMinPrice (e : Element): String = {
    	val regex1 = """dottable-value">(.*[万|億]).*～.*</span>"""
		val result1 = getItem(e.toString, regex1)
		if (result1 != NONE) return trimPrice(result1)

    	val regex2 = """dottable-value">(.*[万|億]).*・.*</span>"""
		val result2 = getItem(e.toString, regex2)		
		if (result2 != NONE) return trimPrice(result2)

		else return getPrice(e)
    }

    def getMaxPrice (e : Element): String = {
    	val regex1 = """dottable-value">.*～(.*[万|億]).*</span>"""
		val result1 = getItem(e.toString, regex1)
		if (result1 != NONE) return trimPrice(result1)

    	val regex2 = """dottable-value">.*・(.*[万|億]).*</span>"""
		val result2 = getItem(e.toString, regex2)
		if (result2 != NONE) return trimPrice(result2)

		else return getPrice(e)
    }

    def getPrice (e: Element): String = {
    	val regex1 = """dottable-value">(.*[万|億]).*</span>"""
		val result1 = getItem(e.toString, regex1)
		if (result1 != NONE) return trimPrice(result1)

    	val regex3 = """dottable-value">(未定)</span>"""
		val result3 = getItem(e.toString, regex3)
		if (result3 != NONE) return trimPrice(result3)

		return NONE
    }

    def trimPrice (str: String): String = {
    	var result1, result2 = 0
    	var b = new StringBuilder()
    	str.foreach { s =>
			if (s == '億') {
				b ++= "0000"
				result1 = b.toInt
				b.setLength(0)
			}
			else if (s == '万') {
				result2 = b.toInt
				b.setLength(0)
			}
			else b ++= s.toString 		
    	}

    	if (result1 == 0 && result2 == 0) b.toString
		else (result1 + result2).toString
    }
}