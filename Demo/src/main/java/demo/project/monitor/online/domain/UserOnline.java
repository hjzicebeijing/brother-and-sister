package demo.project.monitor.online.domain;

import demo.project.monitor.online.domain.OnlineSession.OnlineStatus;
import java.util.Date;

public class UserOnline {
    private static final long serialVersionUID=1L;
    private String sessionId;
    private String loginName;
    private String ipAddr;
    private String browser;
    private String os;
    private OnlineStatus status= OnlineStatus.on_line;
    private Date startTimestamp;
    private Date lastAccessTime;
    private Long expireTime;

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setStatus(OnlineStatus status) {
        this.status = status;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOs() {
        return os;
    }

    public OnlineStatus getStatus() {
        return status;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public Long getExpireTime() {
        return expireTime;
    }
}
