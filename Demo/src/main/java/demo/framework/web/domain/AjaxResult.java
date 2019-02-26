package demo.framework.web.domain;

import java.util.HashMap;

public class AjaxResult extends HashMap<String,Object>{
    public AjaxResult(){

    }
    @Override
    public AjaxResult put(String key,Object value){
        super.put(key,value);
        return this;
    }
    public static AjaxResult error(int code,String msg){
        AjaxResult result=new AjaxResult();
        result.put("code",code);
        result.put("msg",msg);
        return result;
    }
    public static AjaxResult error(String msg){
        return error(500,msg);
    }
    public static AjaxResult error(){
        return error(1,"操作错误");
    }
    public static AjaxResult success(String msg){
        AjaxResult result=new AjaxResult();
        result.put("code",0);
        result.put("msg",msg);
        return result;
    }
    public static AjaxResult success(){
        return success("操作成功");
    }
}
