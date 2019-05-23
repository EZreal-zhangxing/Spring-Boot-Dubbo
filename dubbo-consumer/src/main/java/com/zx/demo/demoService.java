package com.zx.demo;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zx.Service.demoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.User;

import java.util.List;

/**
 * @Auother zhangxing
 * @Date 2019-04-10 17:04
 * @note
 */
@Component
public class demoService {

    @Reference(version = "1.0.0")
    private demoApi demoApi;

    public String getdemoApiMethod(){
        return demoApi.getNote();
    }

    public List<User> getUserinfo(){
        RpcContext.getContext().setAttachment("author","zx");
        return demoApi.getUserInfo();
    }
}
