package io.github.liuziyuan.retrofit.samples.singleinstance;

import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.singleinstance.api")
@SpringBootApplication
public class SingleInstanceApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(SingleInstanceApplication.class, args);
        final ConfigurableEnvironment environment = run.getEnvironment();
        log.info("swagger-ui URL: http://localhost:{}/swagger-ui/index.html", environment.getProperty("server.port"));
    }
}
