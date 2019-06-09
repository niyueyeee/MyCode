package com.itheima;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequestBuilder;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author NiYueYeee
 * @create 2019-06-09 11:38
 */
public class A02_DeleteIndex {
    public static void main(String[] args) throws UnknownHostException {
        //1、客户端对象
        PreBuiltTransportClient client = new PreBuiltTransportClient(Settings.builder().build());
        //2、请求地址url对象
        InetSocketTransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300);
        client.addTransportAddress(address);
        //3、请求对象：删除索引
        DeleteIndexRequestBuilder a = client.admin().indices().prepareDelete("a");
        //4、发送请求，获取响应对象
        System.out.println(a.get());
        //5、释放资源，关闭客户端
        client.close();
    }
}
