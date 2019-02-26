package demo.project.system.user.domain;

import demo.framework.web.domain.BaseDomain;

public class User extends BaseDomain {
    private static final long serialVersionUID=1L;
    private long userId;
    public long getUserId(){
        return userId;
    }
    public void setUserId(long userId){
        this.userId=userId;
    }
    private String loginName;
    public String getLoginName(){
        return loginName;
    }
    public void setLoginName(String loginName){
        this.loginName=loginName;
    }
    private String userName;
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    private String phoneNumber;
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    private String createTime;
    public String getCreateTime(){return this.createTime;}
    public void setCreateTime(String createTime){this.createTime=createTime;}
    private String email;
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    private String password;
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    private String salt;
    public String getSalt(){
        return salt;
    }
    public void setSalt(String salt){
        this.salt=salt;
    }
    private String status;
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
    private String refuseDes;
    public String getRefuseDes(){
        return refuseDes;
    }
    public void setRefuseDes(String refuseDes){
        this.refuseDes=refuseDes;
    }
    private String headPortrait;
    public String getHeadPortrait(){
        return headPortrait;
    }
    public void setHeadPortrait(String headPortrait){
        this.headPortrait=headPortrait;
    }
}
