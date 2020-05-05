package com.carlos.order.utils;

import com.carlos.order.VO.ResultVO;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 17:06
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

}
