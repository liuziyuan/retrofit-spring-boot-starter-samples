package io.github.liuziyuan.retrofit.spring.boot3.reactor.samples;

import io.github.liuziyuan.retrofit.core.RetrofitBuilderExtension;
import io.github.liuziyuan.retrofit.spring.boot.EnableRetrofit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author liuziyuan
 */
@Slf4j
@EnableRetrofit(basePackages = "io.github.liuziyuan.retrofit.spring.boot3.reactor.samples.api")
@SpringBootApplication
public class RetrofitSpringBootWebApplication {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(RetrofitSpringBootWebApplication.class, args);
        String[] beanNamesForType = run.getBeanNamesForType(RetrofitBuilderExtension.class);
        log.info("beanNamesForType: " + Arrays.stream(beanNamesForType).collect(Collectors.joining(",")));
//        ConfigurationBuilder configuration;
//        configuration = new ConfigurationBuilder().forPackages("");
//        Reflections reflections = new Reflections(configuration);

//        final ConfigurableEnvironment environment = run.getEnvironment();
//        log.info("swagger-ui URL: http://localhost:{}/swagger-ui/index.html", environment.getProperty("server.port"));
    }
}
