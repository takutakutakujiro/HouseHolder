import org.jsoup._
import org.jsoup.nodes.Element
import collection.JavaConverters._

import java.io.{File, PrintWriter}

import scala.util.matching.Regex.Match
import scala.collection.mutable.Buffer

object MainLogic extends App{

	val urlstr = "http://suumo.jp/ikkodate/tokyo/sc_setagaya/"
	val dateP1 = "[0-9]* ".r
	val NONE = "Nome"

	val main_jsoup_con = Jsoup.connect(urlstr)
	var jsoup_con : Connection = null

	val urlList = createUrlList(getMaxPageNo(urlstr))
	
	createJsonFile(urlList)

	def getMaxPageNo(urlstr : String): Int = {
		//val doc = Jsoup.connect(urlstr).get
	    val element = main_jsoup_con.get.select(".pagination").asScala.head
		var pageCntStr = ""

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
		
		for(url <- list){
			JsoupUtil.start(url)
			val blocks = JsoupUtil.getElement(".property_unit-content")

			for (block <- blocks){
				//タイトル、詳細画面url、画像、販売価格、所在地、駅、土地面積、間取り
				val title = getTitle(block)
				val detailUrl = getDetailUrl(block)
				val img = getImg(block)
				val minPrice = getMinPrice(block)
				val maxPrice = getMaxPrice(block)
				println(i_Id + "：" + minPrice)
				println(i_Id + "：" + maxPrice)
				//println(block.toString)
				i_Id = i_Id + 1	
			}
//			val img_ele   = JsoupUtil.getElement("a.ui-thumb.ui-thumb--1")

	    	val file = new PrintWriter(output)

//	    	createImgUrlList(img_ele)

//	    	for (i <- 0 until title_ele.length) {
				
				

//				val title = title_ele.apply(i).text
//				val detailUrl = getDetailUrl(title_ele.apply(i))


//				println(i_Id + detailUrl)

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

	// def getImgUrl (html : String): String = {
	// 	val regex = """.* rel="(.*h=144)"""".r
	// 	replaceUrl(regex.findFirstMatchIn(html))
	// }

   //  def createImgUrlList (b : Buffer[Element]): List[String] = { 
   //  	var i_Id2 = 1
   //  	var result = List[String]()
   // 		for (e <- b){		
   //  		val url = getImgUrl(e.toString)    		
   //  		if(url != NONE) {
			// 	println(i_Id2 + url)
			// 	result :+= url
			// 	i_Id2 = i_Id2 + 1
			// }
   //  	}
   //  	result
   //  }

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

    def getMinPrice (e : Element): String = {
    	val regex1 = """dottable-value">(.*)[万|億]円～.*</span>"""
		val result1 = getItem(e.toString, regex1)

		if (result1 != NONE) return result1    	
		else return getPrice(e)
    }

    def getMaxPrice (e : Element): String = {
    	val regex1 = """dottable-value">.*～(.*)[万|億]円</span>"""
		val result1 = getItem(e.toString, regex1)

		if (result1 != NONE) return result1    	
		else return getPrice(e)	
    }

    def getPrice (e: Element): String = {
    	val regex1 = """dottable-value">(.*万)円</span>"""
		val result1 = getItem(e.toString, regex1)
		if (result1 != NONE) return result1    	

		val regex2 = """dottable-value">(.*億)円</span>"""
		val result2 = getItem(e.toString, regex2)
		if (result2 != NONE) return result2    	

    	val regex3 = """dottable-value">(未定)</span>"""
		val result3 = getItem(e.toString, regex3)
		if (result3 != NONE) return result3    	

		return NONE
    }

}