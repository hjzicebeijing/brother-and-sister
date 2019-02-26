package demo.framework.shiro.session;

import demo.common.constant.ShiroConstants;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;


public class OnlineSessionDao extends EnterpriseCacheSessionDAO {
    private static final long SerialVersionUID=1L;

    private static final Logger logger= LoggerFactory.getLogger(OnlineSessionDao.class);
    @Value("${shiro.session.expireTime}")
    private int expireTime;

    @Resource(name ="redisTemplateObj")
    private RedisTemplate<Object,Object> redisTemplate;

    private String prefix= ShiroConstants.SESSION_PREFIX;
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId=super.doCreate(session);
        redisTemplate.opsForValue().set(prefix+sessionId.toString(),session);
        logger.debug("创建Session",sessionId);
        return sessionId;
    }
    @Override
    protected  Session doReadSession(Serializable sessionId){
        logger.debug("获取Session",sessionId);
        Session session=super.doReadSession(sessionId);
        if(session==null){
            session=(Session) redisTemplate.opsForValue().get(prefix+sessionId.toString());
        }
        return session;
    }
    @Override
    protected void doDelete(Session session){
        logger.debug("删除Session",session.getId());
        super.doDelete(session);
        redisTemplate.delete(prefix+session.getId().toString());
    }

    /**
     * 更新session的生命周期
     * @param session
     */
    @Override
    protected void doUpdate(Session session){
        logger.debug("更新Session",session.getId());
        super.doUpdate(session);
        String key=prefix+session.getId().toString();
        if(!redisTemplate.hasKey(key)){
            redisTemplate.opsForValue().set(key,session);
        }
        redisTemplate.expire(key,expireTime*6, TimeUnit.SECONDS);
    }
}
