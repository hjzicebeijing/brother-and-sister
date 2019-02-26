package demo.project.system.user.controller;


import demo.common.utils.StringUtils;
import demo.framework.web.controller.BaseController;
import demo.framework.web.domain.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController extends BaseController {
    @Value("${shiro.user.captchaEnabled}")
    private String captchaEnabled;
    @Value("${shiro.user.captchaType}")
    private String captchaType;

    @GetMapping("/login")
    public String login(Map<String,Object> map){
        map.put("captchaEnabled",captchaEnabled);
        map.put("captchaType",captchaType);
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult AjaxLogin(String username,String password,String validateCode,Boolean rememberMe,HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("validateCode",validateCode);
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password,rememberMe);
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
            return success();
        }catch(AuthenticationException e){
            String msg="用户名或密码错误";
            if(!StringUtils.isEmpty(e.getMessage())){
                msg=e.getMessage();
            }
            return error(msg);
        }
    }
    @GetMapping("/unauth")
    public String unauth(){
        return "/unauth";
    }
}
