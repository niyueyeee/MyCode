package com.itheima.utils;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * @author NiYueYeee
 * @create 2019-06-09 11:43
 */
public class TransportClients {
    public static TransportClient getClient() throws UnknownHostException {
        //1、客户端对象
        Settings settings = Settings.builder().build();
        PreBuiltTransportClient client = new PreBuiltTransportClient(settings);
        //2、请求地址URL对象
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        return client;
    }
    public static void toConsuleResultHits(SearchResponse response) {
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> map = hit.getSourceAsMap();
            System.out.println("id = "+map.get("id"));
            System.out.println("title = "+map.get("title"));
            System.out.println("content = "+map.get("content"));
        }
        System.out.println("命中总条数：" + hits.getTotalHits());
        System.out.println("显示条数 : " + hits.getHits().length);
    }
}
