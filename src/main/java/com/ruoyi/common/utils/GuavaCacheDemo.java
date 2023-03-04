package com.ruoyi.common.utils;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 描述:
 * 本地缓存Ddmo
 *
 * @author XueGuCheng
 * @create 2022-11-01 23:03
 */
@Slf4j
public class GuavaCacheDemo {

    // 模拟DB
    private static final HashMap<Integer, String> map = new HashMap<>();

    public static LoadingCache<Integer, String> createGuavaCache() {

        return CacheBuilder.newBuilder()
                // 设置并发级别为5，并发级别是指可以同时写缓存的线程数
                .concurrencyLevel(5)
                // 设置写缓存后10秒钟后过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                // 设置缓存容器的初始容量为8
                .initialCapacity(8)
                // 设置缓存最大容量为10，超过10之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(10)
                // 设置统计缓存的各种统计信息（生产坏境关闭）
                .recordStats()
                // 设置缓存的移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
                    }
                })
                // 指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<Integer, String>() {
                    @Override
                    public String load(Integer key) throws Exception {
                        // 往DB中查询数据
                        log.info("查询数据 key={}", key);
                        if (map.containsKey(key)) {
                            String s = map.get(key);
                            log.info("查询数据 key={} s={}", key, s);
                            if (System.currentTimeMillis() > Long.parseLong(s) + 15000) {
                                map.remove(key);
                                return "";
                            } else {
                                return map.get(key);
                            }
                        }
                        return "";
                    }
                });
    }

    public static void setCacheKey(Integer key, Long value) {
        try {
            LoadingCache<Integer, String> loadingCache = createGuavaCache();

            String s = loadingCache.get(key);
            if (StringUtils.isEmpty(s)) {
                map.put(key, String.valueOf(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean isExist(Integer key) {
        try {
            LoadingCache<Integer, String> loadingCache = createGuavaCache();
            String s = loadingCache.get(key);
            return StringUtils.isNotEmpty(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        map.put(1, "java");
        map.put(2, "天下");
        map.put(3, "第一");

        LoadingCache<Integer, String> loadingCache = createGuavaCache();

        // 第一次缓存中没有数据，所以会往DB中查询数据
        System.out.println(loadingCache.get(2));
        // 第二次缓存中有数据，CacheLoader.load方法不会加载
        System.out.println(loadingCache.get(2));

        Thread.sleep(11000L);
        System.out.println(loadingCache.get(2));
    }
}

