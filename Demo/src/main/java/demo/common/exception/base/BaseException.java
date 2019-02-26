package demo.common.exception.base;


import demo.common.utils.MessageUtils;
import demo.common.utils.StringUtils;

/**
 * 基础异常
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID=1L;

    private String modeul;

    private String code;

    private Object[] args;

    private String defaultMessage;

    public BaseException(String modeul,String code,Object[] args,String defaultMessage){
        this.modeul=modeul;
        this.code=code;
        this.args=args;
        this.defaultMessage=defaultMessage;
    }
    public BaseException(String modeul,String code,Object[] args){
        this(modeul,code,args,null);
    }
    public String getMessage(){
        String message=null;
        if(!StringUtils.isEmpty(code)){
            message= code;//MessageUtils.getMessage(code,args);
        }
        if(message==null){
            message=defaultMessage;
        }
        return message;
    }
}
