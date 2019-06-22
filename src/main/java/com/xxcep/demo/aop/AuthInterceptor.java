package com.xxcep.demo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class AuthInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//获取请求的地址（根域名以外的部分）
        String uri = request.getRequestURI();
        if (uri.indexOf("/login") >= 0){
            return true;
        }
		HttpSession session = request.getSession();
		if( session.getAttribute("user")==null) {
			response.sendRedirect("/");
			return false;
		}else
			return true;
	}

}

