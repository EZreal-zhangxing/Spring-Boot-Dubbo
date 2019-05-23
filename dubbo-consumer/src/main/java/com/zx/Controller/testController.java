package com.zx.Controller;

import com.zx.demo.demoHighService;
import com.zx.demo.demoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import java.util.List;


/**
 * @Auother zhangxing
 * @Date 2019-04-10 17:34
 * @note
 */

@Api("測試Controller")
@RestController
public class testController {

    @Autowired
    private demoService demoService;

    @Autowired
    private demoHighService demoHighService;


    @RequestMapping("/testmethod")
    @ApiOperation(notes = "返回字符串",httpMethod = "GET", value = "返回字符串 提供服务版本 1.0.0")
    public String testMethod(){
        return demoService.getdemoApiMethod();
    }

    @RequestMapping("/testhighmethod")
    @ApiOperation(notes = "返回字符串",httpMethod = "GET", value = "返回字符串 提供服务版本 2.0.0")
    public String testhighMethod(){
        return demoHighService.getHighMethod();
    }

    @RequestMapping("/getuserInfo")
    @ApiOperation(notes = "返回list",httpMethod = "GET", value = "从数据库查询信息 提供服务版本 1.0.0")
    public List<User> getUserinfo(){
        return demoService.getUserinfo();
    }

    @RequestMapping("/ConnectToServiceDirtly")
    @ApiOperation(notes = "直连服务提供者",httpMethod = "GET", value = "直连服务者 服务者有开启token")
    public String ConnectToServiceDirtly(){
        return demoHighService.ClientToService();
    }
}
