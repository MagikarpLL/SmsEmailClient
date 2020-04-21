package cn.magikarpll.smsemailclient.controller;

import cn.magikarpll.smsemailclient.common.result.IgnoreReponseAdvice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@Api("test class")
public class TestController {

    /**
     * 常用注解：
     * - @Api()用于类；
     * 表示标识这个类是swagger的资源
     * - @ApiOperation()用于方法；
     * 表示一个http请求的操作
     * - @ApiParam()用于方法，参数，字段说明；
     * 表示对参数的添加元数据（说明或是否必填等）
     * - @ApiModel()用于类
     * 表示对类进行说明，用于参数用实体类接收
     * - @ApiModelProperty()用于方法，字段
     * 表示对model属性的说明或者数据操作更改
     * - @ApiIgnore()用于类，方法，方法参数
     * 表示这个方法或者类被忽略
     * - @ApiImplicitParam() 用于方法
     * 表示单独的请求参数
     * - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
     *
     * 具体使用举例说明：
     * @Api()
     * 用于类；表示标识这个类是swagger的资源
     * tags–表示说明
     * value–也是说明，可以使用tags替代
     */


    /**
     *
     * @return
     */
    @ApiOperation("test get method")
    @IgnoreReponseAdvice
    @GetMapping("/get")
    public String test(){
        log.debug("this is test log, test parameter is {}","test value");
        return "test get success";
    }

    /**
     *
     * @return
     */
    @ApiOperation("test get method")
    @GetMapping("/get2")
    public String test2(){
        log.debug("this is test log, test parameter is {}","test value");
        return "test get success";
    }

}
