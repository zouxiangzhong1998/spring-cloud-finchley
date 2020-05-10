package com.carlos.apigeteway.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置Cookie工具类
 *
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 19:09
 */
public class CookieUtil {

    /**
     * 设置 cookie
     *
     * @param response 响应信息
     * @param name     cookie名称
     * @param value    cookie值
     * @param maxAge   cookie 存活时间(单位:s)
     */
    public static void set(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取 cookie
     *
     * @param request 请求
     * @param name    cookie 名称
     */
    public static Cookie get(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

}
