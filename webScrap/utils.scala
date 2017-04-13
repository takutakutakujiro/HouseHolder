import org.jsoup._
import collection.JavaConverters._

object JsoupUtil {
	
	private var jsoup_con : Connection = null 
	def start (url : String) { jsoup_con = Jsoup.connect(url) }
	def getElement (tag : String) = jsoup_con.get.select(tag).asScala
}

object JasonUtil {
	def getDocJson (key : String, value : String) = "\"" + key + "\":" + "\"" + value + "\""
	def getIndexJson (no : Int) = """{"index":{"_id":"""" + no + """"}}"""
}