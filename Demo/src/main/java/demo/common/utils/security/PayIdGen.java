package demo.common.utils.security;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class PayIdGen {
    private static AtomicInteger temp=new AtomicInteger(0);
    public static String getPayId(){
        String payId=null;
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
        int result=(int) temp.incrementAndGet() & 65535;
        payId=format.format(date)+String.format("%05d",result);
        return payId;
    }
}
