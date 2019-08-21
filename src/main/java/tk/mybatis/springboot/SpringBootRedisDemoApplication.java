package tk.mybatis.springboot;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("tk.mybatis.springboot.mapper")
@EnableCaching
@EnableAdminServer
public class SpringBootRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisDemoApplication.class, args);
    }

}
