package utils

import collection.JavaConverters._
import scala.util.matching.Regex.{Match, MatchIterator}
import collection.immutable.ListMap

object JsonUtil {
	def getDocJson (key : String, value : String) = "\"" + key + "\":" + "\"" + value + "\""
	def getIndexJson (no : Int) = """{"index":{"_id":"""" + no + """"}}"""
	def getDefIndexJson = """{"index":{}}"""
}

object Utils {
	def isNone (str : String): Boolean = if (str == "None") true else false
    def getItem (target: String, regexStr: String): String = optCheck(regexStr.r.findFirstMatchIn(target))
    def getElaItems (target: String, regexStr: String): Map[String, String] = createElaMap(regexStr.r.findFirstMatchIn(target))
    def optCheck(o: Option[Match]) = {
		o match {
			case Some(s) => o.get.group(1)
			case None => "None"
		}
    }
    def createElaMap(o: Option[Match]): Map[String, String] = {
		Map[String, String](
			"title" 		-> o.get.group(1),
			"detail_url"	-> o.get.group(2),
			"img" 			-> o.get.group(3),
			"minPrice"  	-> o.get.group(4),
			"maxPrice"  	-> o.get.group(5),
			"address"   	-> o.get.group(6),
			"station" 		-> o.get.group(7),
			"minSpace" 		-> o.get.group(8),
			"maxSpace" 		-> o.get.group(9),
			"roomLayout"	-> o.get.group(10)
		)
	}
}