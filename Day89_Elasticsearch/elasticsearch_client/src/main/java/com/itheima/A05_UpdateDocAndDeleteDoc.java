package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NiYueYeee
 * @create 2019-06-09 12:01
 */
public class A05_UpdateDocAndDeleteDoc {
    public static void main(String[] args) throws UnknownHostException {
        //1、客户端对象
        TransportClient client = TransportClients.getClient();
        //2、请求对象：更新操作，删除操作。设置请求体
//        UpdateRequestBuilder requestBuilder = client.prepareUpdate("a", "article", "1");
//        Map map = new HashMap();
//        map.put("id","3");
//        map.put("title","【更新】Elasticsearch是一个基于Lucene的搜索服务器");
//        map.put("content","【更新】它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的");
//        requestBuilder.setDoc(map);
        DeleteRequestBuilder requestBuilder = client.prepareDelete("a", "article", "1");
        //3、发送请求，获取响应对象
        System.out.println(requestBuilder.get());
        //4、释放资源，关闭客户端
        client.close();
    }
}
