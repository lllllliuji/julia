package com.liuji.julia.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BeanCopyUtil {
    public static <T> T copyBean(Object source, Class<T> target) {
        // 创建目标对象
        T result = null;
        try {
            result = target.getDeclaredConstructor().newInstance();
            if (source != null) {
                // 实现属性copy
                BeanUtils.copyProperties(source, result);
            }
        } catch (Exception e) {
            log.error("encountered an error when copy bean");
        }
        // 返回结果
        return result;
    }

    public static <S, T> List<T> copyBeanList(List<S> source, Class<T> target) {
        List<T> beanList = new ArrayList<>();
        if (null != source && !source.isEmpty()) {
            for (Object obj : source) {
                beanList.add(copyBean(obj, target));
            }
        }
        return beanList;
    }
}
