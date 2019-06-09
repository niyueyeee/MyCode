package com.itheima;


import javafx.scene.AmbientLight;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-08 20:59
 */
public class A01_CreateIndex {
    public static void main(String[] args) throws UnknownHostException {
        //1、客户端对象
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.builder().build());
        //2、请求地址对象，端口：9300
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        //3、请求对象：创建索引的请求对象
        AdminClient adminClient = client.admin();//管理权限客户端
        IndicesAdminClient indicesAdminClient = adminClient.indices();//创建索引管理权限客户端
        CreateIndexRequestBuilder a = indicesAdminClient.prepareCreate("a");
        //4、请求对象执行请求的发送，获取响应对象
        CreateIndexResponse response = a.get();
        System.out.println(response.index());
        //5、释放资源，关闭客户端
        client.close();

    }
}
