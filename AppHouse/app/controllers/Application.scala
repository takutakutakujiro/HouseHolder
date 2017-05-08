package controllers

import play.api.mvc._

import java.net.InetAddress

import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import org.elasticsearch.transport.client.PreBuiltTransportClient


object Application extends Controller {

	 def index = Action {
	 	// on startup
        val client = new PreBuiltTransportClient(Settings.EMPTY)
                  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300))
		


	 	// on shutdown
        client.close();
	 	
	 	val elaMap = List[Map[String, String]](
	 					Map[String, String](
	 						"title" -> "テストタイトル",
	 						"place" -> "6800万"
	 					),
	 					Map[String, String](
	 						"title" -> "テストタイトル2",
	 						"place" -> "5800万"
	 					)
	 				)

	 	Ok(views.html.index.render(elaMap))

	 }

}