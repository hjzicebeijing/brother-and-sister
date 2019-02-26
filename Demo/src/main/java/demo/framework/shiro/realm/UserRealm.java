package demo.framework.shiro.realm;


import demo.common.exception.user.CaptchaException;
import demo.common.exception.user.UserNotExistException;
import demo.common.exception.user.UserPasswordNotMatchException;
import demo.common.exception.user.UserPasswordRetryLimitExceedException;
import demo.common.utils.security.ShiroUtils;
import demo.framework.shiro.service.LoginService;
import demo.project.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 处理登录认证和权限管理
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    /**
     *
     * 用户权限管理
     *
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 角色加入AuthorizationInfo认证对象

        // 权限加入AuthorizationInfo认证对象

        return info;
    }

    /**
     * 用户登录管理
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken=(UsernamePasswordToken) token;
        String userName=upToken.getUsername();
        String password="";
        User user;
        if(upToken.getPassword()!=null){
            password=new String(upToken.getPassword());
        }
        try{
            user=loginService.login(userName,password);
        }catch(CaptchaException e){
            throw new AuthenticationException(e.getMessage(),e);
        }catch(UserNotExistException e){
            throw new UnknownAccountException(e.getMessage(),e);
        }catch(UserPasswordNotMatchException e){
            throw new IncorrectCredentialsException(e.getMessage(),e);
        }catch(UserPasswordRetryLimitExceedException e){
            throw new ExcessiveAttemptsException(e.getMessage(),e);
        }catch(Exception e){
            throw new AuthenticationException(e.getMessage(),e);
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,password,getName());
        return info;
    }
    public void clearCachedAuthorizationInfo(){
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
