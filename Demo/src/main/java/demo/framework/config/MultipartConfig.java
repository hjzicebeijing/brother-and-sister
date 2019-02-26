package demo.framework.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory=new MultipartConfigFactory();
        multipartConfigFactory.setMaxFileSize("30MB");
        multipartConfigFactory.setMaxRequestSize("30MB");
        return multipartConfigFactory.createMultipartConfig();
    }
}
