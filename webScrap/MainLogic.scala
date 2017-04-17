import org.jsoup._
import org.jsoup.nodes.Element
import collection.JavaConverters._

import java.io.{File, PrintWriter}

import scala.util.matching.Regex.Match
import scala.collection.mutable.Buffer

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
//		return pageCntStr.toInt
		return 1
	}

	def createUrlList(maxPageNo : Int): List[String] = {
		var listUrl = List.empty[String]
		for(iPage <- 1 to maxPageNo){
			var createdUrl = createUrl(iPage.toString)
			println("[SUMO][世田谷区][URL][" + iPage + "]：" + createdUrl)
			listUrl :+= createdUrl 
		}
		return listUrl
	}

	def createJsonFile (list : List[String]): Unit = {

		var i_Id = 1
	    val output = new File("./json/output_sumo.json")
		
		list.par.map { url =>
			val jsoup = JsoupUtil.start(url, ".property_unit-content")

			jsoup.par.map { m =>
				//タイトル、詳細画面url、画像、販売価格、所在地、駅、土地面積、間取り
				val title = getTitle(m)
				val detailUrl = getDetailUrl(m)
				val img = getImg(m)
				val minPrice = getMinPrice(m)
				val maxPrice = getMaxPrice(m)
				val address = getAddress(m)
				val station = getStation(m)
				val minSpace = getMinSpace(m)
				val maxSpace = getMaxSpace(m)
				println("[" + i_Id + "]" + "======")
				println("title" + "：" + title)
				println("detailUrl" + "：" + detailUrl)
				println("img" + "：" + img)
				println("minPrice" + "：" + minPrice)
				println("maxPrice" + "：" + maxPrice)
				println("address" + "：" + address)
				println("station" + "：" + station)
				println("minSpace" + "：" + minSpace)
				println("maxSpace" + "：" + maxSpace)
				//println(m.toString)
				i_Id = i_Id + 1	
			}

	    	val file = new PrintWriter(output)

				var b = new StringBuilder()
				b ++= "{"
//				b ++= JasonUtil.getDocJson("title", title)
				b ++= ","
//				b ++= JasonUtil.getDocJson("detail_url", detailUrl)
				b ++= "}"

  				file.println(JasonUtil.getIndexJson(i_Id))
  				file.println(b.result)  				
				
//			}
			file.close
		}
	}

	def createUrl (pageNo : String) = urlstr + "pnz1" + pageNo + ".html"

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

    def getTitle (e : Element) = {
    	val regex = """<h2 class="property_unit-title">.*<a.*>(.*)</a></h2>"""
    	getItem(e.toString, regex)
    }

    def getDetailUrl (e : Element) = {
    	val regex = """<h2 class="property_unit-title">.*<a href=(.*) target"""
    	getItem(e.toString, regex)	
    }

    def getImg (e : Element) = {
    	val regex = """rel="(.*)" alt"""
    	getItem(e.toString, regex).replaceAll("amp;","")	    	
    }

    def getAddress (e : Element) = {
    	val regex = """所在地\n.*\n.*\n\s+?(\S.*)"""
    	getItem(e.toString, regex)	
    }

    def getStation (e : Element) = {
    	val regex = """沿線・駅\n.*\n.*\n\s+?(\S.*)"""
    	getItem(e.toString, regex)	
    }

    def getMinSpace (e : Element) = {
    	val regex = """土地面積\n.*\n.*\n\s+?(\S.*)m"""
    	getItem(e.toString, regex)
    }

    def getMaxSpace (e : Element): String = {
    	val regex = """土地面積\n.*\n.*\n.*\n.*</sup>[～|・](.*)m"""
    	val result = getItem(e.toString, regex)
    	if (Utils.isNone(result)) return getMinSpace(e)
    	result
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