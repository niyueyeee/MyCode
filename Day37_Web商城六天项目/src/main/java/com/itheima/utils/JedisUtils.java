package com.itheima.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * @author niyueyeee
 * @create 2019-03-10 19:40
 */
public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        ResourceBundle jedis = ResourceBundle.getBundle("jedis");
        String host = jedis.getString("jedis.host");
        int port = Integer.parseInt(jedis.getString("jedis.port"));
        int maxTotal = Integer.parseInt(jedis.getString("jedis.maxTotal"));
        int maxIdle = Integer.parseInt(jedis.getString("jedis.maxIdle"));

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxIdle(maxTotal);

        jedisPool = new JedisPool(jedisPoolConfig, host, port);
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
