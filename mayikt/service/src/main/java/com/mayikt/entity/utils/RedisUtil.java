package com.mayikt.entity.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Component
public class RedisUtil implements ApplicationContextAware {
    private static StringRedisTemplate stringRedisTemplate;
    private static ApplicationContext applicationContext;

    /**
     * 存放string类型
     *
     * @param key     key
     * @param data    数据
     * @param timeout 超时间
     */
    public static void setString(String key, String data, Long timeout) {
        getStringRedisTemplate().opsForValue().set(key, data);
        if (timeout != null) {
            getStringRedisTemplate().expire(key, timeout, TimeUnit.SECONDS);
        }
    }

    /**
     * 存放string类型
     *
     * @param key  key
     * @param data 数据
     */
    public static void setString(String key, String data) {
        setString(key, data, null);
    }

    /**
     * 根据key查询string类型
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        String value = getStringRedisTemplate().opsForValue().get(key);
        return value;
    }

    /**
     * 根据对应的key删除key
     *
     * @param key
     */
    public static void delKey(String key) {
        getStringRedisTemplate().delete(key);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static StringRedisTemplate getStringRedisTemplate() {
        if (stringRedisTemplate == null) {
            stringRedisTemplate = applicationContext.getBean("stringRedisTemplate", StringRedisTemplate.class);
        }
        return stringRedisTemplate;
    }


}