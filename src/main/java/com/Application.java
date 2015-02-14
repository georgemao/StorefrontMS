package com;

import com.beans.CarService;
import com.beans.CarServiceActive;
import com.beans.CarServiceLocal;
import com.configuration.ActiveCondition;
import com.configuration.LocalCondition;
import com.utils.CarInterface;
import com.utils.CarUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Spring Boot Application entry point
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

    // We can define beans through Annotation or through app-context.xml -- then @Autowired it for access
    /*@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("cars");
    }*/

    @Bean(name="carService")
    @Conditional(ActiveCondition.class)
    public CarService carService(){
        return new CarServiceActive();
    }

    @Bean(name="carService")
    @Conditional(LocalCondition.class)
     public CarService carServiceLocal(){
        return new CarServiceLocal();
    }

    @Bean
    public CarInterface carinterface() {
        return new CarUtil();
    }
}
