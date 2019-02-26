package demo.project.system.seller.controller;

import demo.common.utils.FileUploadUtils;
import demo.framework.web.domain.AjaxResult;
import demo.project.system.seller.domain.Seller;
import demo.project.system.seller.domain.SellerType;
import demo.project.system.seller.service.ISellerService;
import demo.project.system.seller.service.ISellerTypeService;
import demo.project.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static demo.framework.web.domain.AjaxResult.error;
import static demo.framework.web.domain.AjaxResult.success;

@Controller
@RequestMapping("/seller")
public class SellerAddController {
    @Autowired
    private ISellerService sellerService;

    @Autowired
    private ISellerTypeService sellerTypeService;

    @Value("${file.uploadPathOfSeller}")
    private String uploadPathOfSeller;

    @Value("${file.accessPathOfSeller}")
    private String accessPathOfSeller;


    @GetMapping("/add")
    public String getSellerAdd(){
        return "selleradd";
    }

    @PostMapping("/registe")
    @ResponseBody
    public AjaxResult uploadSellerInfo(Seller seller, @RequestParam("file") MultipartFile file){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        seller.setSellerScore(0);
        String filePath=file.getOriginalFilename();
        seller.setLoginName(user.getLoginName());
        String uploadPath=uploadPathOfSeller+filePath;
        String accessPath=accessPathOfSeller+filePath;
        seller.setSellerFlag(accessPath);
        try{
            if(sellerTypeService.checkSellerTypeName(seller.getSellerTypeName())==0){
                SellerType sellerType=new SellerType();
                sellerType.setSellerTypeName(seller.getSellerTypeName());
                sellerType.setSellerTypeScore(0);
                System.out.println(sellerType.getSellerTypeName()+sellerType.getSellerTypeScore());
                sellerTypeService.insertSellerType(sellerType);
            }
            sellerService.insertSeller(seller);
            FileUploadUtils.uploadFile(uploadPath,file);
        }catch(Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success();
    }
}
