package cn.magikarpll.smsemailclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/get")
    public String test(){
        log.debug("this is test log, test parameter is {}","test value");
        return "test get success";
    }

}
