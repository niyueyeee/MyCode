package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:21
 */
public class A09_SaveAll {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();

        //2-3 循环100次
        for (int i = 0; i < 100; i++) {
            //2、请求对象：创建文档
            IndexRequestBuilder request = client.prepareIndex("a", "arricle");
            Map map = new HashMap();
            map.put("id", "" + i);
            map.put("title", "[" + i + "]Elasticsearch是一个基于Lucene的搜索服务器");
            map.put("content", "[" + i + "]它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的");
            request.setSource(map);
            request.setType("article");
            //3、发送请求，获取响应对象
            IndexResponse response = request.get();
            System.out.println(response.toString());
        }
        //4、关闭客户端，释放资源
        client.close();
    }
}
