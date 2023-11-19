package com.nwd.component;

import com.auth0.jwt.interfaces.Claim;
import com.nwd.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebFilter(filterName = "JwtFilter", urlPatterns = "/v1/*")
public class JwtFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        // Except OPTIONS, other request should be checked by JWT
        Map<String, Claim> userData = JwtUtil.verifyToken(token);
        if (userData == null) {
            response.getWriter().write("token不合法！");
            return;
        }

        Long id = userData.get("id").asLong();
        String username = userData.get("username").asString();
        String password= userData.get("password").asString();
        Integer memorySize = userData.get("memorySize").asInt();

        //拦截器 拿到用户信息，放到request中
        request.setAttribute("id", id);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("memorySize", memorySize);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
