package tn.esprit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;





    @EnableConfigurationProperties
    @EnableFeignClients
    @SpringBootApplication

public class MsProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProduitApplication.class, args);
    }

}
