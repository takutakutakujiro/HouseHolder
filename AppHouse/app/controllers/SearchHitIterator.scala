package controllers

import org.elasticsearch.action.search.{SearchRequestBuilder, SearchResponse}
import org.elasticsearch.search.SearchHit

class SearchHitIterator extends Iterator[SearchHit]{

    var initialRequest: SearchRequestBuilder = null

    var searchHitCounter: Int = _
    var currentPageResults: Array[SearchHit] = null
    var currentResultIndex: Int = _

    def init(initialRequest: SearchRequestBuilder) = {
        this.initialRequest = initialRequest;
        this.searchHitCounter = 0;
        this.currentResultIndex = -1;
    }

    override def hasNext: Boolean = {
        if (currentPageResults == null || currentResultIndex + 1 >= currentPageResults.length) {
            val paginatedRequestBuilder = initialRequest.setFrom(searchHitCounter);
            val response = paginatedRequestBuilder.execute().actionGet();
            currentPageResults = response.getHits().getHits();

            if (currentPageResults.length < 1) return false;

            currentResultIndex = -1;
        }

        return true
    }

    override def next: SearchHit = {
        if (!hasNext) return null

        currentResultIndex += 1
        searchHitCounter += 1
        return currentPageResults(currentResultIndex)
    }

}