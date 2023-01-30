package courseland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "courseland.clients"
)
public class AppUserManagement {
    public static void main(String[] args) {
        SpringApplication.run(AppUserManagement.class, args);
    }
}