package demo.framework.manager;

import demo.common.utils.ServletUtils;
import demo.common.utils.security.ShiroUtils;
import demo.common.utils.spring.SpringUtils;
import demo.project.monitor.logininfor.domain.Logininfor;
import demo.project.monitor.logininfor.service.LogininforServiceImpl;
import demo.project.monitor.online.domain.OnlineSession;
import demo.project.monitor.online.domain.UserOnline;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

public class AsyncFactory {

    public static TimerTask recordLogininforToDb(String username, String loginResult,String message){
        final UserAgent userAgent=UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User_agent"));
        String ip= ShiroUtils.getIp();
        return new TimerTask() {
            @Override
            public void run() {
                Logininfor logininfor=new Logininfor();
                String browser=userAgent.getBrowser().getName();
                String os=userAgent.getOperatingSystem().getName();
                logininfor.setLoginName(username);
                logininfor.setIpAddr(ip);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setLoginResult(loginResult);
                logininfor.setMessage(message);
                SpringUtils.getBean(LogininforServiceImpl.class).insertLogininforLogger(logininfor);
            }
        };
    }

}
