package tk.mybatis.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("tk.mybatis.springboot.mapper")
@EnableCaching
public class SpringBootRedisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisDemoApplication.class, args);
    }

}
