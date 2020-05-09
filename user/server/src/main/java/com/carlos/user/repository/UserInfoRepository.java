package com.carlos.user.repository;

import com.carlos.user.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 18:14
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    /**
     * 根据 openid 得到用户信息
     * @param openid 微信ID
     * @return 用户信息
     */
    UserInfo findByOpenid(String openid);

}
