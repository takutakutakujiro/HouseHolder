import java.util.List

import org.elasticsearch.action.bulk.BulkRequestBuilder
import org.elasticsearch.action.bulk.BulkResponse
import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.transport.InetSocketTransportAddress

object ElasticsearchRecordWriter {
	
	var client = null;
	
	def write(): Unit = {
//	        if(items.size() == 0) return
/*	        
	    	var bulkRequest = client.prepareBulk
	        for(item <- items){
	        	var m = (MapItemRecord)item
	        	var mapper = new ObjectMapper()
	        	var json = null
	        	try {
					json = mapper.writeValueAsString(m);
				} catch {
		        	throw new CommonException(null,"json変換時にエラーが発生しました。",e)
			}
*/	        	
	        	//TODO need to get field name for id.
	        	//var id = (String)m.getValue("id");
//	        	var id = m.getValue("id").toString

	        	//TODO set index name & type name
	//			IndexResponse response = client
	//					.prepareIndex("posts", "article", id).setSource(json)
	//					.execute().actionGet();
	        	//using bulk request.
/*	        	bulkRequest.add(client.prepareIndex("posts", "article", id).setSource(json))
	        }
	        
	        var bulkResponse = bulkRequest.execute().actionGet();
	        if (bulkResponse.hasFailures()) {
	            throw new CommonException(null,bulkResponse.buildFailureMessage())
	        }
	  */
	}
}