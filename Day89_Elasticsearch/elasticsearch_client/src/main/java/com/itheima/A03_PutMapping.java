package com.itheima;

import com.itheima.utils.TransportClients;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;


import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-09 11:42
 */
public class A03_PutMapping {
    public static void main(String[] args) throws IOException {
        //1、获取客户端
        TransportClient client = TransportClients.getClient();
        //3、请求对象：配置映射
        PutMappingRequestBuilder a = client.admin().indices().preparePutMapping("a");
        //设置请求体
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
        jsonBuilder.startObject()
                .startObject("article")
                .startObject("properties")
                .startObject("id").field("type","long").field("store","yes").field("index","not_analyzed")
                .endObject()
                .startObject("title").field("type","string").field("store","yes").field("index","analyzed").field("analyzer","ik_smart")
                .endObject()
                .startObject("content").field("type","string").field("store","yes").field("index","analyzed").field("analyzer","ik_smart")
                .endObject()
                .endObject()
                .endObject()
                .endObject();
        a.setSource(jsonBuilder);
        //设置类型
        a.setType("article");
        //4、发送请求，获取响应对象
        System.out.println(a.get());
        //5、释放资源，关闭客户端
        client.close();
        client.close();
    }
}
