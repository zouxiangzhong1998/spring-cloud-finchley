package com.carlos.product.exception;

import com.carlos.product.enums.ResultEnum;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/7 11:21
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
