package demo.common.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletUtils {
    public static ServletRequestAttributes getRequestAttributes(){
        RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) requestAttributes;
    }
    public static HttpServletRequest getRequest(){
        return getRequestAttributes().getRequest();
    }
    public static HttpServletResponse getResponse(){
        return getRequestAttributes().getResponse();
    }
    public static HttpSession getSession() {
        return getRequest().getSession();
    }
    public static String getParameter(String name){
        return getRequest().getParameter(name);
    }
}
