package demo.common.utils;

import java.util.Collection;
import java.util.Map;

public class StringUtils extends org.apache.commons.lang.StringUtils {
    private final static String nullStr="";
    public static boolean isEmpty(Collection<?> coll){
        return coll==null || coll.isEmpty();
    }
    public static boolean isEmpty(Object[] array){
        return array==null || (array.length==0);
    }
    public static boolean isEmpty(Map<?,?> map){
        return map==null || map.isEmpty();
    }
    public static boolean isEmpty(String str){
        return str==null || str.equals(nullStr);
    }
}
