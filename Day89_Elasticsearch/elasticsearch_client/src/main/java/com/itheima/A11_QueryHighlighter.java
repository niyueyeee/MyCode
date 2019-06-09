package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:26
 */
public class A11_QueryHighlighter {
    public static void main(String[] args) throws UnknownHostException {
        //* 1、获取客户端
        TransportClient client = TransportClients.getClient();
        //* 2、请求对象：查询的请求对象，
        SearchRequestBuilder requestBuilder = client.prepareSearch("a");
        requestBuilder.setQuery(QueryBuilders.termQuery("title", "搜索"));
        //设置高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("title");
        requestBuilder.highlighter(highlightBuilder);
        //* 3、发送请求，获取响应对象;
        SearchResponse response = requestBuilder.get();
        //获取高亮结果
        for (SearchHit hit : response.getHits()) {
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("title");
            System.out.println(title);
        }
        System.out.println("命中总条数：" + requestBuilder.get().getHits().getTotalHits());
        System.out.println("显示条数 : " + requestBuilder.get().getHits().getHits().length);
        //* 4、释放资源，关闭客户端
        client.close();
    }
}
