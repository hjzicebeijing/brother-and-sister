
import com.alibaba.fastjson.JSONObject;
import demo.common.utils.security.PayIdGen;
import demo.project.system.pay.domain.AlipayRequestContent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
public class test {
    public static void main(String[] args){
        AtomicInteger temp=new AtomicInteger(65535);
        int result=(int) temp.incrementAndGet() & 65535;
        System.out.println(result);

    }
}
