package demo.framework.redis;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;


public class RedisObjectSerializer implements RedisSerializer {
    private Converter<Object,byte[]> serializer=new SerializingConverter();
    private Converter<byte[],Object> deserializer=new DeserializingConverter();
    private byte[] empty=new byte[0];

    @Override
    public byte[] serialize(Object object) throws SerializationException {
        if(object==null)return empty;
        else{
            try{
                return serializer.convert(object);
            }catch(Exception e){
                return empty;
            }
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(bytes==null)return null;
        else{
            try{
                return deserializer.convert(bytes);
            }catch(Exception e){
                throw new SerializationException("serializer faild",e);
            }
        }
    }
}
