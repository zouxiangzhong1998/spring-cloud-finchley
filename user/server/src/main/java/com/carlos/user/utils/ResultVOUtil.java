package com.carlos.user.utils;

import com.carlos.user.enums.ResultEnum;
import com.carlos.user.vo.ResultVO;

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

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMessage());
        return resultVO;
    }

}
