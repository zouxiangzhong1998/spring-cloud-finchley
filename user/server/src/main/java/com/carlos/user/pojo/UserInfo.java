package com.carlos.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 18:09
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信openId
     */
    private String openid;

    /**
     * 角色
     */
    private Integer role;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

}
