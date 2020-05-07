package com.carlos.product.vo;

import lombok.Data;

/**
 * http 请求返回的最外层对象
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:37
 */
@Data
public class ResultVO {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private Object data;

}
