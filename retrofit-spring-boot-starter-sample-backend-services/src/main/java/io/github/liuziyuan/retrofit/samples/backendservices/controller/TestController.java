package io.github.liuziyuan.retrofit.samples.backendservices.controller;

import io.github.liuziyuan.retrofit.samples.backendservices.domain.HelloBean;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author liuziyuan
 */
@Slf4j
@Api(tags = "Test Api")
@RestController
@RequestMapping("/v1/test")
public class TestController {

    @GetMapping("/{message}")
    public ResponseEntity<HelloBean> hello(@PathVariable String message) {
        HelloBean helloBean = new HelloBean();
        helloBean.setMessage(message + new Random().nextInt());
        return ResponseEntity.ok(helloBean);
    }
}
