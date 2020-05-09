package com.carlos.user.service;

import com.carlos.user.pojo.UserInfo;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 18:17
 */
public interface UserService {

    /**
     * 根据 openid 得到用户信息
     * @param openid 微信ID
     * @return 用户信息
     */
    UserInfo findByOpenid(String openid);

}
