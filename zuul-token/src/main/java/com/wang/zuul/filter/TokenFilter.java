package com.wang.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

// 将Filter类配置为一个Bean
@Component
public class TokenFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(TokenFilter.class);

	// 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。true:总是生效，false:不生效
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	// 过滤器的具体业务逻辑
	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        Object token = request.getParameter("token");
        
        if (token == null) {
        	// token为空：打印日志，拦截
        	logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        	logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        	logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            logger.info("token为空，禁止访问!");
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            logger.info("<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        } else {
            // TODO 根据从request得到的token调用认证服务提供的接口进行校验，校验成功则获取用户信息（用户名等）并放行
        	// 校验不成功则响应401并打印日志
        }
        
        // run方法的返回值将被忽略
		return null;
	}

	// 过滤器类型：决定过滤器在哪个阶段执行，例如：pre，post等阶段
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	// 通过int值来定义过滤器的执行顺序，越小的值越优先处理
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
