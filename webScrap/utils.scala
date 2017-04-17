import org.jsoup._
import collection.JavaConverters._

object JsoupUtil {	
	def start (url: String, tag: String) = Jsoup.connect(url).get.select(tag).asScala
}

object JasonUtil {
	def getDocJson (key : String, value : String) = "\"" + key + "\":" + "\"" + value + "\""
	def getIndexJson (no : Int) = """{"index":{"_id":"""" + no + """"}}"""
}

object Utils {
	def isNone (str : String): Boolean = if (str == "None") true else false
}