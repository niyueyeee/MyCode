package com.itheima;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.pojo.Article;
import com.itheima.utils.TransportClients;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-09 11:49
 */
public class A04_CreateDocument {
    public static void main(String[] args) throws UnknownHostException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();
        //2、请求对象：创建文档，设置请求体
        IndexRequestBuilder request = client.prepareIndex("a", "article");
        //第一种方式：XContentBuilder构建请求体：
        //        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
//        jsonBuilder.startObject()
//                .field("id","1")
//                .field("title","Elasticsearch是一个基于Lucene的搜索服务器")
//                .field("content","它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。")
//                .endObject();
//        request.setSource(jsonBuilder);

        //第二种方式：对象转换为JSON，作为请求体
//        Article article = new Article();
//        article.setId(1);
//        article.setTitle("Elasticsearch是一个基于Lucene的搜索服务器");
//        article.setContent("它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，")
//        String s = new ObjectMapper().writeValueAsString(article);
//        request.setSource(s.getBytes(), XContentType.JSON);

        //第三种方式：map
//        Map map = new HashMap();
//        map.put("id","3");
//        map.put("title","Elasticsearch是一个基于Lucene的搜索服务器");
//        map.put("content","它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的");
//        request.setSource(map);
        //第四种方式：String JSON数据
        request.setSource("{\"id\":4,\"title\":\"Elasticsearch是一个基于Lucene的搜索服务器\",\"content\":\"它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。\"}",XContentType.JSON);
        //3、发送请求，获取响应对象。
        System.out.println(request.get());
        //4、关闭客户端，释放资源
        client.close();
    }
}
