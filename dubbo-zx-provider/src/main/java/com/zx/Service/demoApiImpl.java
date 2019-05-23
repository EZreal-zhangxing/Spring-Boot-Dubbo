package com.zx.Service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zx.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.User;

import javax.annotation.PostConstruct;
import java.util.List;


/**
 * @Auother zhangxing
 * @Date 2019-04-10 16:51
 * @note
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
@Component
public class demoApiImpl implements demoApi {
    @Autowired
    private UserMapper userMapper;

    public String getNote() {
        return "this is dubbo service version 1.0.0";
    }

    public List<User> getUserInfo(){
        String index = RpcContext.getContext().getAttachment("author");
        System.out.println("hidden parm :"+index);
        return userMapper.selectAll();
    }

    @PostConstruct
    public void initMethod(){
        System.out.println(this.getClass()+" is init!");
        System.out.println(userMapper+" is init!");
    }
}
