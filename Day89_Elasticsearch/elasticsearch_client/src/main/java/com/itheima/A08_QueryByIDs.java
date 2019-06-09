package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;

import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:18
 */
public class A08_QueryByIDs {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();

        //2、请求对象：查询请求。设置查询方式，设置类型
        SearchRequestBuilder request = client.prepareSearch("a");
        request.setQuery(QueryBuilders.idsQuery().addIds("112"));
        request.setTypes("article");

        //3、发送请求，获取响应底线
        TransportClients.toConsuleResultHits(request.get());

        //4、关闭客户端，释放资源
        client.close();
    }
}
