package io.github.liuziyuan.retrofit.samples.awesome.controller;

import io.github.liuziyuan.retrofit.samples.awesome.api.DynamicInheritApi;
import io.github.liuziyuan.retrofit.samples.awesome.api.HelloApi;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author liuziyuan
 */
@Slf4j
@Api(tags = "Hello Api")
@RestController
public class HelloController {

    @Autowired
    private HelloApi helloApi;
    @Autowired
    private DynamicInheritApi dynamicInheritApi;

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
        final ResponseBody body1 = helloApi.httpHello(message).execute().body();
        return ResponseEntity.ok(body.string() + "-" + body1.string());
    }

    @GetMapping("/v1/hello/8081/{message}")
    public ResponseEntity<String> hello8081(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
        final ResponseBody body1 = dynamicInheritApi.hello(message).execute().body();
        final ResponseBody body2 = helloApi.httpHello2(message).execute().body();
        return ResponseEntity.ok(body.string() + "-" + body1.string() + "-" + body2.string());
    }

    @GetMapping("/hello/{message}")
    public ResponseEntity<String> hello2(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello2(message).execute().body();
        final ResponseBody body1 = helloApi.httpHello2(message).execute().body();
        return ResponseEntity.ok(body.string() + "-" + body1.string());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello3() throws IOException {
        final ResponseBody body = helloApi.robots().execute().body();
        final ResponseBody body1 = helloApi.httpRobots().execute().body();
        return ResponseEntity.ok(body.string() + "-" + body1.string());
    }


}
