package demo.framework.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.framework.redis.RedisObjectSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    @Primary
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper=new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(mapper);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean(name="redisTemplateObj")
    public RedisTemplate<Object,Object> redisTemplateObj(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object,Object> redisTemplateObj=new RedisTemplate<>();
        redisTemplateObj.setConnectionFactory(redisConnectionFactory);
        redisTemplateObj.setKeySerializer(new StringRedisSerializer());
        redisTemplateObj.setValueSerializer(new RedisObjectSerializer());
        return redisTemplateObj;
    }
    @Bean
    public CacheManager initRedisCacheManager( @Autowired RedisTemplate redisTemplate){
        RedisCacheManager redisCacheManager=new RedisCacheManager(redisTemplate);
        redisCacheManager.setDefaultExpiration(1000);
        Map<String,Long> map=new HashMap();
        map.put("user",100L);
        redisCacheManager.setExpires(map);
        return redisCacheManager;
    }
}