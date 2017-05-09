package controllers

import play.api.mvc._

import java.net.InetAddress

import controllers.SearchHitIterator

import collection.mutable.ListBuffer

import collection.immutable.ListMap

import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient
import org.elasticsearch.action.search.{SearchResponse, SearchType}
import org.elasticsearch.search.SearchHit
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.common.xcontent._

import utils.Utils._


object Application extends Controller {

	 def index = Action {
	 	// on startup
        val client = new PreBuiltTransportClient(Settings.EMPTY)
                  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300))

		val requestBuilder = client.prepareSearch("site")
                                        .setTypes("test")
                                        .setQuery(QueryBuilders.matchAllQuery()) 

		val hitIterator = new SearchHitIterator()
		hitIterator.init(requestBuilder)
		//println(hitIterator.length)

		var elaListBuf = ListBuffer[Map[String, String]]()

		while (hitIterator.hasNext) {
		    val hit = hitIterator.next
		    val source = hit.getSourceAsString
		    val test = getElaItems(source, 
		     	""""title":"(.*)","detail_url":"(.*)","img":"(.*)","minPrice":"(.*)","maxPrice":"(.*)","address":"(.*)","station":"(.*)","minSpace":"(.*)","maxSpace":"(.*)","roomLayout":"(.*)"""")
		    elaListBuf += test
	    }

	 	// on shutdown
        client.close();
	 	
        println(elaListBuf.length)
	 	// val elaMap = List[Map[String, String]](
	 	// 				Map[String, String](
	 	// 					"title" -> "テストタイトル",
	 	// 					"place" -> "6800万"
	 	// 				),
	 	// 				Map[String, String](
	 	// 					"title" -> "テストタイトル2",
	 	// 					"place" -> "5800万"
	 	// 				)
	 	// 			)

	 	Ok(views.html.index.render(elaListBuf.toList))

	 }

}