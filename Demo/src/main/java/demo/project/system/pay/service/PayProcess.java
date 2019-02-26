package demo.project.system.pay.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayProcess {
    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayTradePrecreateRequest precreateRequest;

    @Autowired
    private AlipayTradeQueryRequest queryRequest;

    public AlipayTradePrecreateResponse getResponse(String content){
        precreateRequest.setBizContent(content);
        AlipayTradePrecreateResponse response=null;
        try{
            response=alipayClient.execute(precreateRequest);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public AlipayTradeQueryResponse getPayProcessResult(String content){
        queryRequest.setBizContent(content);
        AlipayTradeQueryResponse response=null;
        try{
            response=alipayClient.execute(queryRequest);
        }catch(Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
