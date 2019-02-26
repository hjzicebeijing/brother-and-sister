package demo.common.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements BeanFactoryPostProcessor {
    private static ConfigurableListableBeanFactory factoryBean;
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        this.factoryBean=configurableListableBeanFactory;
    }
    public static <T> T getBean(String name) throws BeansException{
        return (T) factoryBean.getBean(name);
    }
    public static <T> T getBean(Class<T> clz) throws BeansException{
        T result= (T) factoryBean.getBean(clz);
        return result;
    }
}
