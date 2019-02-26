package demo.project.monitor.online.domain;

import org.apache.shiro.session.mgt.SimpleSession;

public class OnlineSession extends SimpleSession {
    private long loginId;
    private String loginName;
    private String ipAddr;
    private String browser;
    private String os;
    private OnlineStatus status=OnlineStatus.on_line;
    private transient boolean attributeChanged=false;
    public static enum OnlineStatus{
        on_line("在线"),off_line("离线");
        private final String info;
        private OnlineStatus(String info){
            this.info=info;
        }
        public String getInfo(){
            return info;
        }
    }
    public long getLoginId(){
        return loginId;
    }
    public void setLoginId(long loginId){
        this.loginId=loginId;
    }
    public String getLoginName(){
        return loginName;
    }
    public void setLoginName(String loginName){
        this.loginName=loginName;
    }
    public String getIpAddr(){
        return ipAddr;
    }
    public void setIpAddr(String ipAddr){
        this.ipAddr=ipAddr;
    }
    public String getBrowser(){
        return browser;
    }
    public void setBrowser(String browser){
        this.browser=browser;
    }
    public String getOs(){
        return os;
    }
    public void setOs(String os){
        this.os=os;
    }
    public OnlineStatus getStatus(){
        return status;
    }
    public void setStatus(OnlineStatus status){
        this.status=status;
    }
    public void markAttributeChanged(){
        this.attributeChanged=true;
    }
    public void resetAttributeChanged(){
        this.attributeChanged=false;
    }
    public boolean isAttributeChanged(){
        return attributeChanged;
    }
    public void setAttribute(Object key,Object value){
        super.setAttribute(key,value);
    }
    public Object removeAttribute(Object key){
        return super.removeAttribute(key);
    }
}
