package studio.moonid.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
//@EntityScan(basePackages = {"studio.moonid.demo.entity"})
//@EnableJpaRepositories(basePackages = "studio.moonid.demo.repository")
public class DemoApplication {
    private static ApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext=SpringApplication.run(DemoApplication.class, args);
//        displayAllBeans();
    }

    public static void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}
