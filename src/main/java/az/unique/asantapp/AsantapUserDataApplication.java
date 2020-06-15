package az.unique.asantapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("az.unique.asantapp")
public class AsantapUserDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsantapUserDataApplication.class, args);
    }

}
