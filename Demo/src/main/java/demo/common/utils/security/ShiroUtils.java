package demo.common.utils.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }
    public static Session getSession(){
        return getSubject().getSession();
    }
    public static String getIp(){
        return getSession().getHost();
    }
}
