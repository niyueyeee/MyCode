package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:06
 */
public class A06_QueryByTerm {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();
        //2、请求对象：查询请求。设置查询方式，设置类型
        SearchRequestBuilder request = client.prepareSearch("a");
        request.setQuery(QueryBuilders.termQuery("title","搜索"));
        request.setTypes("article");
        //3、发送请求，获取响应底线
        SearchResponse response = request.get();
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> map = hit.getSourceAsMap();
            System.out.println("id = "+map.get("id"));
            System.out.println("title = "+map.get("title"));
            System.out.println("content = "+map.get("content"));
        }
        System.out.println("命中总条数：" + hits.getTotalHits());
        System.out.println("显示条数 : " + hits.getHits().length);
        //4、关闭客户端，释放资源
        client.close();
    }


}
