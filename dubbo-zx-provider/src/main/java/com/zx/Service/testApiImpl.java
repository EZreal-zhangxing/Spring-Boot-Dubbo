package com.zx.Service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Auother zhangxing
 * @Date 2019-04-22 11:19
 * @note
 */
@Service
public class testApiImpl implements TestApi {
    @Override
    public String getString() {
        return "service";
    }
}
