package com.carlos.user.controller;

import com.carlos.user.constants.CookieConstants;
import com.carlos.user.constants.RedisConstants;
import com.carlos.user.enums.ResultEnum;
import com.carlos.user.enums.RoleEnum;
import com.carlos.user.pojo.UserInfo;
import com.carlos.user.service.UserService;
import com.carlos.user.utils.CookieUtil;
import com.carlos.user.utils.ResultVOUtil;
import com.carlos.user.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 18:53
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     *
     * @param openid   用户openID
     * @param response 响应
     * @return json信息
     */
    @GetMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid, HttpServletResponse response) {
        // 1. openid 和 数据库是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2. 判断角色
        if (!RoleEnum.BUYER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. 设置 cookie 里的 openid
        CookieUtil.set(response, CookieConstants.OPENID, openid, CookieConstants.EXPIRE);

        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = CookieUtil.get(request, CookieConstants.TOKEN);
        if(cookie != null
                && StringUtils.isNotBlank(
                        stringRedisTemplate.opsForValue().get(
                                String.format(RedisConstants.TOKEN_TEMPLATE, cookie.getValue())))){
            return ResultVOUtil.success();
        }

        // 1. openid 和 数据库是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if (userInfo == null) {
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }

        // 2. 判断角色
        if (!RoleEnum.SELLER.getCode().equals(userInfo.getRole())) {
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }

        // 3. redis 设置 key=UUID，value=xyz
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForValue().set(
                String.format(RedisConstants.TOKEN_TEMPLATE, token),
                openid, RedisConstants.EXPIRE, TimeUnit.SECONDS);

        // 4. 设置 cookie 里的 openid
        CookieUtil.set(response, CookieConstants.TOKEN, token, CookieConstants.EXPIRE);

        return ResultVOUtil.success();
    }

}
