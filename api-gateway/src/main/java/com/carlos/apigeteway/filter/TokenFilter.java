package com.carlos.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 17:14
 */
@Component
public class TokenFilter extends ZuulFilter {

    @Override
    public String filterType() {
        // 参数校验 请求之前
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 越小越前 拦截；org.springframework.cloud.netflix.zuul.filters.pre.PreDecorationFilter 之前拦截
        return FilterConstants.PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        // a "true" return from this method means that the run() method should be invoked
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 这里是从url 参数里 获取，也可以从cookie，header 里获取
        String token = request.getParameter("token");
        // 判断是否为空
        if(StringUtils.isEmpty(token)){
            // 设置不通过
//            requestContext.setSendZuulResponse(false);
            // 设置状态码
//            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
