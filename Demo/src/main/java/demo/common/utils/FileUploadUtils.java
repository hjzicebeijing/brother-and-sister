package demo.common.utils;

import demo.framework.web.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileOutputStream;

import static demo.framework.web.domain.AjaxResult.error;
import static demo.framework.web.domain.AjaxResult.success;

public class FileUploadUtils {
    public static AjaxResult uploadFile(String path, MultipartFile file){
        FileOutputStream out=null;
        try{
            out=new FileOutputStream(path);
            out.write(file.getBytes());
            out.flush();
            out.close();
        }catch(Exception e){
            return error();
        }
        return success();
    }
}
