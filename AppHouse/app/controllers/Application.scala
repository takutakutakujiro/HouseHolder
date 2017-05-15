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

	var elaList = List[Map[String, String]]()
	var viewList = List[Map[String, String]]()

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

	    client.close();  

	    elaList = elaListBuf.toList

	    viewList = elaList.slice(0,30)
	 	
        println(elaListBuf.length)

	 	Ok(views.html.index.render(elaList, viewList, 1))

	}

	def nextContent(pageNo: Int) = Action {
		var sliceNo = 0
		if(pageNo == 1) sliceNo = 0
		else sliceNo = (pageNo - 1) * 30
		viewList = elaList.slice(sliceNo, sliceNo + 30)
	 	Ok(views.html.index.render(elaList, viewList, pageNo))
	}
}	 
