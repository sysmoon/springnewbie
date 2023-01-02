package studio.moonid.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;

//@SpringBootApplication(scanBasePackages = {"studio.moonid.demo"})
//@ComponentScan(basePackages = {"studio.moonid.demo"})
//@EntityScan(basePackages={"studio.moonid.demo.entity"})
//@EnableJpaRepositories(basePackages={"studio.moonid.demo.repository"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
