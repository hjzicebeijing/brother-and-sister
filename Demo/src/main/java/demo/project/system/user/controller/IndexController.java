package demo.project.system.user.controller;


import demo.project.system.seller.domain.Seller;
import demo.project.system.seller.domain.SellerType;
import demo.project.system.seller.service.ISellerService;
import demo.project.system.user.domain.User;
import demo.project.system.seller.service.ISellerTypeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    private ISellerTypeService sellerTypeService;

    @Autowired
    private ISellerService sellerService;

    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        map.put("userName",user.getUserName());
        map.put("headPortrait",user.getHeadPortrait());
        List<Seller> sellers=sellerService.getWholeSeller();
        List<SellerType> sellerTypes=sellerTypeService.getListSellerTypeOrderByScore(10);
        map.put("Sellers",sellers);
        map.put("SellerTypes",sellerTypes);
        return "index";
    }
}
