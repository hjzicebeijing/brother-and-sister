package demo.project.system.food.controller;

import demo.common.utils.FileUploadUtils;
import demo.framework.web.domain.AjaxResult;
import demo.project.system.food.domain.Food;
import demo.project.system.food.service.IFoodService;
import demo.project.system.seller.domain.Seller;
import demo.project.system.seller.service.ISellerService;
import demo.project.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Map;

import static demo.framework.web.domain.AjaxResult.error;
import static demo.framework.web.domain.AjaxResult.success;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private IFoodService foodService;

    @Autowired
    private ISellerService sellerService;

    @Value("${file.uploadPathOfFood}")
    private String uploadPathOfFood;

    @Value("${file.accessPathOfFood}")
    private String accessPathOfFood;

    @GetMapping("/main/{sellerName}")
    public String getFood(@PathVariable("sellerName") String sellerName, Map<String,Object> map){
        List<Food> foods=foodService.getFoodsBySellerName(sellerName);
        map.put("Foods", foods);
        map.put("sellerName",sellerName);
        return "food";
    }

    @GetMapping("/add")
    public String addFoodByLoginName(Map<String,Object> map){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        System.out.println(user.getLoginName());
        List<Seller> sellers=sellerService.getSellersByLoginName(user.getLoginName());
        map.put("sellers",sellers);
        return "foodadd";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addFood(Food food, MultipartFile file){
        String filePath=file.getOriginalFilename();
        String uploadPath=uploadPathOfFood+filePath;
        String accessPath=accessPathOfFood+filePath;
        food.setFoodStatus(0);
        food.setFoodImg(accessPath);
        try{
            FileUploadUtils.uploadFile(uploadPath,file);
            foodService.insertFood(food);
        }catch(Exception e){
            e.printStackTrace();
            return error(e.getMessage());
        }
        return success();
    }
}
