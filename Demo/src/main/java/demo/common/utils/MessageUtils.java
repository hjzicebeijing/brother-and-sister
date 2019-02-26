package demo.common.utils;

import demo.common.utils.spring.SpringUtils;
import org.springframework.context.MessageSource;

public class MessageUtils {
    public static String getMessage(String code,Object[] args){
        MessageSource messageSource= SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code,args,null);
    }
}
