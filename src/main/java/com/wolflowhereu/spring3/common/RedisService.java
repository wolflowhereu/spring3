package com.wolflowhereu.spring3.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 * Created by jxdyf09 on 15-5-16.
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;

    /**
     * 根据key值删除缓存
     * @param keys
     */
    public long del(final String... keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Long result = 0l;
                for (int i = 0; i < keys.length; i++) {
                    result = connection.del(keys[i].getBytes());
                }
                return result;
            }
        });
    }

    /**
     * 根据key值删除缓存
     * @param keys
     */
    public long del(final Set<byte[]> keys) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                Long result = 0l;
                Iterator<byte[]> it = keys.iterator();
                while (it.hasNext()) {
                    result = connection.del(it.next());
                }
                return result;
            }
        });
    }


    /**
     * 缓存实体
     *
     * @param key
     * @param entity
     * @param liveTime
     */
    public void set(String key, Object entity, long liveTime) {
        if (entity != null) {
            redisTemplate.opsForValue().set(key, entity);
            if (liveTime > 0) {
                redisTemplate.expire(key, liveTime, TimeUnit.MILLISECONDS);
            }
        }

    }

    /**
     * 缓存实体
     *
     * @param key
     * @param entity
     */
    public void set(String key, Object entity) {
        set(key, entity, 0);
    }


    /**
     * 获取实体
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }


    /**
     * 获取key值的过期时间
     *
     * @param key
     * @return
     */
    public long getLiveTime(final String key) {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.pTtl(key.getBytes());
            }
        });
    }


    /**
     * 获取条件匹配的key值
     * @param pattern
     * @return
     */
    public Set<byte[]> keys(final String pattern) {
        return redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
            public Set<byte[]> doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.keys(pattern.getBytes());
            }
        });
    }

    /**
     * 判断key值对应的缓存是否存在
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    /**
     * 清空缓存
     * @return
     */
    public String flushDB() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 缓存大小
     * @return
     */
    public long dbSize() {
        return redisTemplate.execute(new RedisCallback<Long>() {
            public Long doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    /**
     * @return
     */
    public String ping() {
        return redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                return connection.ping();
            }
        });
    }


}
