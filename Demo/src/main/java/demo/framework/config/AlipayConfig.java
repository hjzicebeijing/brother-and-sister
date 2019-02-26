package demo.framework.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlipayConfig {
    @Value("${pay.url}")
    private String URL;
    @Value("${pay.app_id}")
    private String APP_ID;
    @Value("${pay.app_private_key}")
    private String APP_PRIVATE_KEY;
    @Value("${pay.charset}")
    private String CHARSET;
    @Value("${pay.format}")
    private String FORMAT;
    @Value("${pay.alipay_public_key}")
    private String ALIPAY_PUBLIC_KEY;
    @Value("${pay.sign_type}")
    private String SIGN_TYPE;

    @Bean
    public AlipayClient getAlipayClient(){
        return new DefaultAlipayClient(URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
    }

    @Bean
    public AlipayTradePrecreateRequest getAlipayTradePrecreateRequest(){
        return new AlipayTradePrecreateRequest();
    }

    @Bean
    public AlipayTradeQueryRequest getAlipayTradeQueryRequest(){
        return new AlipayTradeQueryRequest();
    }
}
