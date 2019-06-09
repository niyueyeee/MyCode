package com.itheima.utils;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

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
}
