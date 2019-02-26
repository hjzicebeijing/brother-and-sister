package demo.project.system.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import demo.common.utils.security.PayIdGen;
import demo.framework.web.domain.AjaxResult;
import demo.project.system.pay.domain.AlipayQueryContent;
import demo.project.system.pay.domain.AlipayRequestContent;
import demo.project.system.pay.service.PayProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static demo.framework.web.domain.AjaxResult.error;
import static demo.framework.web.domain.AjaxResult.success;

@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private PayProcess payProcess;

    @Autowired
    AlipayRequestContent alipayRequestContent;

    @Autowired
    AlipayQueryContent alipayQueryContent;

    @PostMapping("/main")
    @ResponseBody
    public Map<String,String> getPayMain(String subject,String total_amount){
        Map<String,String> map=new HashMap<>();
        String payId=PayIdGen.getPayId();
        alipayRequestContent.setOut_trade_no(payId);
        alipayRequestContent.setSubject(subject);
        alipayRequestContent.setTotal_amount(total_amount);
        alipayRequestContent.setTimeout_express("120m");
        String content= JSONObject.toJSONString(alipayRequestContent);
        AlipayTradePrecreateResponse response=payProcess.getResponse(content);
        map.put("qrCodeUrl",response.getQrCode());
        map.put("payId",payId);
        return map;
    }

    @PostMapping("/notify")
    @ResponseBody
    public AjaxResult getPayResult(String payId){
        alipayQueryContent.setOut_trade_no(payId);
        alipayQueryContent.setTrade_no(" ");
        String content=JSONObject.toJSONString(alipayQueryContent);
        String result=" ";
        while(result.equals(" ") || result.equals("WAIT_BUYER_PAY")){
            try{
                Thread.currentThread().sleep(5000);
            }catch(Exception e){
                e.printStackTrace();
            }
            AlipayTradeQueryResponse response=payProcess.getPayProcessResult(content);
            if(response.getCode().equals("10000")){
                result=response.getTradeStatus();
            }
        }
        if(result.equals("TRADE_SUCCESS")||result.equals("TRADE_FINISHED")){
            return success();
        }
        else{
            return error();
        }
    }
}
