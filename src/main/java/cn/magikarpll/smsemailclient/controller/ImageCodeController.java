package cn.magikarpll.smsemailclient.controller;

import cn.magikarpll.smsemailclient.entity.ImageCode;
import cn.magikarpll.smsemailclient.serivce.ImageCodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/imagecode")
public class ImageCodeController {

    @Resource
    private ImageCodeService imageCodeService;

    @PostMapping("/post")
    @ResponseBody
    public String getImageCode(@RequestBody ImageCode imageCode){


        return "";
    }



}
