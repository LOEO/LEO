package com.leo.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by LT on 2015/12/13 0013 21:41
 */
public class EntityUtil {
    public static <T> T buildEntity(Class<T> cls,Map<String,Object> formData) {
        String jsonStr = JSON.toJSONString(formData);
        return JSON.parseObject(jsonStr, cls);
    }
}
