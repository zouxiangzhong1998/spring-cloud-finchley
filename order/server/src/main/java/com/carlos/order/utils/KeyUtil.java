package com.carlos.order.utils;

import java.util.Random;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 17:53
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
