package com.carlos.user.constants;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 19:22
 */
public interface RedisConstants {

    String TOKEN_TEMPLATE = "token_%s";

    /**
     * 过期时间(单位:s)
     */
    Integer EXPIRE = 7200;

}
