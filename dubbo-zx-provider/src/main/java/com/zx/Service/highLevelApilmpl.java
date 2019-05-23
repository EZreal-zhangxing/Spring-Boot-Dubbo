package com.zx.Service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Auother zhangxing
 * @Date 2019-04-11 11:09
 * @note
 */
@Service(version = "2.0.0")
@Component
public class highLevelApilmpl implements highLevelDemoApi {

    public String otherLevelNote() {
        return "this is dubbo service version is 2.0.0";
    }
}
