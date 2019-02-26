package demo.framework.config;

import demo.framework.redis.RedisCacheManager;
import demo.framework.shiro.realm.UserRealm;
import demo.framework.shiro.session.OnlineSessionDao;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    public static final String PREMISSION_STRING = "perms[\"{0}\"]";

    @Value("${shiro.session.expireTime}")
    private int expireTime;
    // 相隔多久检查一次session的有效性，单位毫秒，默认就是10分钟
    @Value("${shiro.session.validationInterval}")
    private int validationInterval;

    // 验证码开关
    @Value("${shiro.user.captchaEnabled}")
    private boolean captchaEnabled;

    // 验证码类型
    @Value("${shiro.user.captchaType}")
    private String captchaType;

    // 设置Cookie的域名
    @Value("${shiro.cookie.domain}")
    private String domain;

    // 设置cookie的有效访问路径
    @Value("${shiro.cookie.path}")
    private String path;

    // 设置HttpOnly属性
    @Value("${shiro.cookie.httpOnly}")
    private boolean httpOnly;

    // 设置Cookie的过期时间，秒为单位
    @Value("${shiro.cookie.maxAge}")
    private int maxAge;

    // 登录地址
    @Value("${shiro.user.loginUrl}")
    private String loginUrl;

    // 权限认证失败地址
    @Value("${shiro.user.unauthorizedUrl}")
    private String unauthorizedUrl;

    @Bean
    public EhCacheManager ehCacheManager(){
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.getCacheManager("demo");
        EhCacheManager em = new EhCacheManager();
        em.setCacheManager(cacheManager);
        return em;
    }
    @Bean
    public RedisCacheManager redisCacheManager(){
        return new RedisCacheManager();
    }
    @Bean
    public UserRealm userRealm(EhCacheManager ehCacheManager){
        UserRealm userRealm=new UserRealm();
        userRealm.setCacheManager(ehCacheManager);
        return userRealm;
    }
    @Bean
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie=new SimpleCookie("RememberMe");
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setHttpOnly(httpOnly);
        cookie.setMaxAge(maxAge*24*60*60);
        return cookie;
    }
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey(Base64.decode("fCq+/xW488hMTCD+cmJ3aQ=="));
        return cookieRememberMeManager;
    }
    @Bean
    public OnlineSessionDao onlineSessionDao(){
        return new OnlineSessionDao();
    }
    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager=new DefaultWebSessionManager();
        sessionManager.setCacheManager(ehCacheManager());
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionDAO(onlineSessionDao());
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdCookie(rememberMeCookie());
        sessionManager.setGlobalSessionTimeout(expireTime*6*1000);
        return sessionManager;
    }
    @Bean
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setCacheManager(ehCacheManager());
        //securityManager.setRememberMeManager(cookieRememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/dog.ico**", "anon");
        filterChainDefinitionMap.put("/dog.png**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/ajax/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/demo/**", "anon");
        filterChainDefinitionMap.put("/captcha/captchaImage**", "anon");
        filterChainDefinitionMap.put("/registe/**","anon");
        filterChainDefinitionMap.put("/pay/**","anon");
        filterChainDefinitionMap.put("/**","user");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
