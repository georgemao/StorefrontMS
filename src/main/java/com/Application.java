package com;

import com.utils.CarInterface;
import com.utils.CarUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

/**
 * Created by George.Mao on 11/14/2014.
 */
@Configuration
@EnableCaching
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:app-context.xml")
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        /*
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        */
    }

    // Annotation definition or through app-context.xml, either way @Autowired it for access
    /*@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cars");
    }*/

    @Bean
    public CarInterface carinterface() {
        return new CarUtil();
    }
}
