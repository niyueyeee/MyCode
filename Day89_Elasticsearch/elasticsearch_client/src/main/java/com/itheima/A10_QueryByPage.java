package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:23
 */
public class A10_QueryByPage {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();
        //2、请求对象：查询请求。设置查询方式，设置类型
        SearchRequestBuilder request = client.prepareSearch("a");
        request.setQuery(QueryBuilders.matchAllQuery());
        request.setTypes("article");
        request.setFrom(0);//其实页
        request.setSize(20);//每页显示多少条
        //3、发送请求，获取响应底线
        TransportClients.toConsuleResultHits(request.get());
        //4、关闭客户端，释放资源
        client.close();
    }
}
