package demo.project.system.user.controller;

import demo.common.utils.FileUploadUtils;
import demo.framework.manager.UserRegiste;
import demo.framework.web.domain.AjaxResult;
import demo.project.system.user.domain.User;
import demo.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static demo.framework.web.domain.AjaxResult.error;
import static demo.framework.web.domain.AjaxResult.success;

@Controller
@RequestMapping("/registe")
public class RegisteController {
    @Autowired
    private IUserService userService;

    @Value("${file.uploadPathOfUser}")
    private String uploadPathOfUser;

    @Value("${file.accessPathOfUser}")
    private String accessPathOfUser;

    @GetMapping("/main")
    public String getRegiste(){
        return "registe";
    }
    @PostMapping("/check")
    @ResponseBody
    public AjaxResult ajaxRegiste(String name,String value){
        if(name.equals("loginNameCheck")){
            if(userService.checkLoginNameUnique(value)!=0)
                return error("登录名重复");
        }
        if(name.equals("phoneNumberCheck")){
            if(userService.checkPhoneNumberUnique(value)!=0)
                return error("电话号码重复");
        }
        if(name.equals("emailCheck")){
            if(userService.checkEmailUnique(value)!=0)
                return error("邮箱重复");
        }
        if(name.equals("userNameCheck")){
            if(userService.checkUserNameUnique(value)!=0)
                return error("昵称重复");
        }
        return success();
    }

    @PostMapping("/result")
    @ResponseBody
    public AjaxResult ajaxResult(User user,@RequestParam("file") MultipartFile file){
        user=UserRegiste.initUser(user);
        String filePath=file.getOriginalFilename();
        String uploadPath=uploadPathOfUser+filePath;
        String accessPath=accessPathOfUser+filePath;
        user.setHeadPortrait(accessPath);
        try{
            userService.insertUser(user);
            FileUploadUtils.uploadFile(uploadPath,file);
        }catch(Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success();
    }
}
