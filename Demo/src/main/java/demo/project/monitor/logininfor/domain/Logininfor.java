package demo.project.monitor.logininfor.domain;

public class Logininfor {
    private static final long SerialVersionUID=1L;
    private long loggerId;
    private String loginName;
    private String ipAddr;
    private String browser;
    private String os;
    private String loginResult;
    private String message;
    private String date;

    public long getLoggerId() {
        return loggerId;
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

    public String getLoginResult() {
        return loginResult;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public void setLoggerId(long loggerId) {
        this.loggerId = loggerId;
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

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
