package com.carlos.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


/**
 * 权限拦截 （区别买家和卖家）
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 17:14
 */
@Component
public class AuthFilter extends ZuulFilter {

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

        /**
         * /order/create 只能买家访问
         * /order/finish 只能卖家访问
         * /product/list 都可以访问
         */

        return null;
    }
}
