package io.github.liuziyuan.retrofit.samples.retrofitbuilder;

import io.github.liuziyuan.retrofit.annotation.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.samples.retrofitbuilder.api")
@SpringBootApplication
public class RetrofitBuilderApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(RetrofitBuilderApplication.class, args);
        final ConfigurableEnvironment environment = run.getEnvironment();
        log.info("swagger-ui URL: http://localhost:{}/swagger-ui/index.html", environment.getProperty("server.port"));
    }
}
