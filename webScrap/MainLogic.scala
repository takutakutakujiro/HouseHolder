import org.jsoup._
import collection.JavaConverters._

object MainLogic {

	val urlstr = "http://suumo.jp/ikkodate/tokyo/sc_setagaya/"
	val addPageUrl = "pnz1"
	val addTypeUrl = ".html"
	val dateP1 = """[0-9] |1[0-9] |2[0-9] |3[0-9] |4[0-9] |5[0-9] |6[0-9] |7[0-9] |8[0-9] |9[0-9] """.r  

	def main(args: Array[String]) {
	    try {
	    	val createdUrlList = createUrlList(getMaxPageNo(urlstr))
	    	setHomeData(createdUrlList)
	    } catch {
	       case e : NoSuchElementException  => println("NO TAG")
	    }
	}

	def getMaxPageNo(urlstr : String): Int = {
		val doc = Jsoup.connect(urlstr).get
	    val element = doc.select(".pagination").asScala.head
		var pageCntStr = ""

		dateP1.findAllIn(element.text).matchData.foreach { m =>	
			val b = new StringBuilder
	    	m.group(0).foreach { pageNo =>
				// 半角スペースでなければ、文字列を足していく
				if (pageNo.toString != " "){
					b.append(pageNo.toString) 
				} else {
					pageCntStr = b.result
				}
	    	}
		}
		println("[SUMO][世田谷区][最大ページ数]：" + pageCntStr.toString)
		return pageCntStr.toInt
	}

	def createUrlList(maxPageNo : Int): List[String] = {
		var listUrl = List.empty[String]
		listUrl = urlstr :: listUrl
		for(iPage <- 1 to maxPageNo){
			var createdUrl = createUrl(iPage.toString)
			println("[SUMO][世田谷区][URL][" + iPage + "]：" + createdUrl)
			listUrl =  createdUrl :: listUrl 
		}
		return listUrl
	}

	def createUrl(pageNo : String): String = {
		//例：http://suumo.jp/ikkodate/tokyo/sc_setagaya/pnz12.html
		return urlstr + addPageUrl + pageNo + addTypeUrl
	}

	def setHomeData (list : List[String]): Unit = {
		var iUrl = 1
		for(url <- list){
			val doc = Jsoup.connect(url).get
	    	val elements = doc.select(".property_unit-title").asScala
	    	
	    	println("[scraping対象URL][" + iUrl + "]：" + url)
	    	for(e <- elements) println(e.text)
	    	println("============================")
	    	iUrl = iUrl + 1
		}
	}
}