package com.carlos.user.service.impl;

import com.carlos.user.pojo.UserInfo;
import com.carlos.user.repository.UserInfoRepository;
import com.carlos.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 18:18
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
