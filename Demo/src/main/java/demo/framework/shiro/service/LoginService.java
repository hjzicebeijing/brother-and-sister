package demo.framework.shiro.service;

import com.google.code.kaptcha.Constants;
import demo.common.constant.SystemConstants;
import demo.common.constant.UserConstants;
import demo.common.exception.user.CaptchaException;
import demo.common.exception.user.UserNotExistException;
import demo.common.exception.user.UserPasswordNotMatchException;
import demo.common.utils.ServletUtils;
import demo.framework.manager.AsyncFactory;
import demo.framework.manager.AsyncManager;
import demo.project.system.user.domain.User;
import demo.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
    @Autowired
    private IUserService userService;

    public User login(String username, String password){
        String validateCode=(String) ServletUtils.getSession().getAttribute("validateCode");
        if(!validateCode.equalsIgnoreCase((String) ServletUtils.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))){
            AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username, SystemConstants.LOGIN_FAIL,
                    new CaptchaException().getMessage()));
            throw new CaptchaException();
        }
        if(username.length() > UserConstants.USERNAME_MAX_LENGTH | username.length()<UserConstants.USERNAME_MIN_LENGTH){
            AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username,SystemConstants.LOGIN_FAIL,
                    new UserNotExistException().getMessage()));
            throw new UserNotExistException();
        }
        if(password.length()>UserConstants.PASSWORD_MAX_LENGTH | password.length()<UserConstants.PASSWORD_MIN_LENGTH){
            AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username,SystemConstants.LOGIN_FAIL,
                    new UserNotExistException().getMessage()));
            throw new UserNotExistException();
        }
        User user=userService.selectUserByLoginName(username);
        if(user==null&&maybeEmail(username)){
            user=userService.selectUserByEmail(username);
        }
        if(user==null&&maybePhoneNumber(username)){
            user=userService.selectUserByPhoneNumber(username);
        }
        if(user==null){
            AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username,SystemConstants.LOGIN_FAIL,
                    new UserNotExistException().getMessage()));
            throw new UserNotExistException();
        }
        if(!password.equals(user.getPassword())){
            AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username,SystemConstants.LOGIN_FAIL,
                    new UserPasswordNotMatchException().getMessage()));
            throw new UserPasswordNotMatchException();
        }
        AsyncManager.getAsyncManager().execute(AsyncFactory.recordLogininforToDb(username,SystemConstants.LOGIN_SUCCESS,
                ""));
        return user;
    }
    private Boolean maybePhoneNumber(String input){
        if(input.matches(UserConstants.PHONR_NUMBER_PATTERN)){
            return true;
        }
        return false;
    }
    private Boolean maybeEmail(String input){
        if(input.matches(UserConstants.EMAIL_PATTERN)){
            return true;
        }
        return false;
    }
}
