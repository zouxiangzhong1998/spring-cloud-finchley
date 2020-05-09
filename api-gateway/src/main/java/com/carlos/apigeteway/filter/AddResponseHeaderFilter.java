package com.carlos.apigeteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/9 17:25
 */
@Component
public class AddResponseHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        // 参数校验 请求之后
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        // 越小越前 拦截； org.springframework.cloud.netflix.zuul.filters.post.SendResponseFilter#filterOrder() 之前执行
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        // a "true" return from this method means that the run() method should be invoked
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 给返回的结果 进行加工
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("X-Foo", UUID.randomUUID().toString());
        return null;
    }
}
