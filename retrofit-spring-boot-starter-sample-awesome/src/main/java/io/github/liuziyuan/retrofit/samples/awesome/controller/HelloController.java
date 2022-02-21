package io.github.liuziyuan.retrofit.samples.awesome.controller;

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

    @GetMapping("/v1/hello/{message}")
    public ResponseEntity<String> hello(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello(message).execute().body();
        return ResponseEntity.ok(body.string());
    }

    @GetMapping("/hello/{message}")
    public ResponseEntity<String> hello2(@PathVariable String message) throws IOException {
        final ResponseBody body = helloApi.hello2(message).execute().body();
        return ResponseEntity.ok(body.string());
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello3() throws IOException {
        final ResponseBody body = helloApi.robots().execute().body();
        return ResponseEntity.ok(body.string());
    }
}
