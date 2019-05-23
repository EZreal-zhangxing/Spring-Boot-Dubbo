package com.zx.demo;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.zx.Service.TestApi;
import com.zx.Service.highLevelDemoApi;
import org.springframework.stereotype.Component;

/**
 * @Auother zhangxing
 * @Date 2019-04-11 11:11
 * @note
 */
@Component
public class demoHighService {

    @Reference(version = "2.0.0")
    private highLevelDemoApi otherLevelNote;

    public String getHighMethod(){

        return otherLevelNote.otherLevelNote();
    }

    //直连服务

    /**
     * 在服务提供端开启了token校验后，直连会报错。RPCException:Invalid token
     * token 必须通过 zookeeper（注册中心校验后才能调用）
     * @return
     */
    public String ClientToService(){
        ReferenceConfig<TestApi> referenceConfig = new ReferenceConfig<TestApi>();
        referenceConfig.setInterface(TestApi.class);
        //此处填写的是接口所在路径，dubbo都是以接口进行服务管理
        referenceConfig.setUrl("dubbo://127.0.0.1:20881/com.zx.Service.TestApi");
        TestApi testApi = referenceConfig.get();
        return testApi.getString();
    }
}
