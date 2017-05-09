import org.jsoup._
import collection.JavaConverters._
import scala.util.matching.Regex.Match

object JsoupUtil {	
	def start (url: String, tag: String) = Jsoup.connect(url).get.select(tag).asScala
}

object JsonUtil {
	def getDocJson (key : String, value : String) = "\"" + key + "\":" + "\"" + value + "\""
	def getIndexJson (no : Int) = """{"index":{"_id":"""" + no + """"}}"""
	def getDefIndexJson = """{"index":{}}"""
}

object Utils {
	def isNone (str : String): Boolean = if (str == "None") true else false
    def getItem (target: String, regexStr: String): String = optCheck(regexStr.r.findFirstMatchIn(target))

    def optCheck(o: Option[Match]) = {
		o match {
			case Some(s) => o.get.group(1)
			case None => "None"
		}
    }


}