package com.doudh.interceptor;


import com.doudh.exception.TokenException;
import com.doudh.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");// 从 http 请求头中取出 token
        if (token == null) {
            throw new TokenException("token为空!");
        }
        // 获取 token 中的 登陆信息
        try {
            request.setAttribute("token_id", jwtUtil.getDoctorId(token));
            request.setAttribute("token_subject", jwtUtil.getUserName(token));
        } catch (Exception j) {
            throw new TokenException("token验证不通过!");
        }
        return true;
    }
}
