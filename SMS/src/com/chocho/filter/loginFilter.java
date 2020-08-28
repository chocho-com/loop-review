package com.chocho.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //判断是否是http请求
        if (!(servletRequest instanceof HttpServletRequest)
                || !(servletResponse instanceof HttpServletResponse)) {
            throw new ServletException(
                    "OncePerRequestFilter just supports HTTP requests");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        HttpSession session = httpRequest.getSession();
        //路径包含login,static字符串可以放行
        String str1 = "login";
        String str2 = "static";
        StringBuffer url = httpRequest.getRequestURL();
        //过滤根目录
        String path = httpRequest.getContextPath();
        String protAndPath = httpRequest.getServerPort() == 80 ? "" : ":"
                + httpRequest.getServerPort();
        String basePath = httpRequest.getScheme() + "://"
                + httpRequest.getServerName() + protAndPath + path + "/";
        if (basePath.equalsIgnoreCase(url.toString())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 特殊用途的路径可以直接访问
        if (str1 != null && str1.length() > 0 && str2 != null && str2.length() > 0) {
                if (url.indexOf(str1) >= 0) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
                if (url.indexOf(str2) >= 0) {
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
        }
        // 从session中获取用户信息
        String loginInfo = (String) session.getAttribute("account2");
        if (null != loginInfo && !"".equals(loginInfo)) {
            // 用户存在,可以访问此地址
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // 用户不存在,踢回登录页面
            String returnUrl = httpRequest.getContextPath() + "/login.jsp";
            httpRequest.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("text/html; charset=UTF-8"); // 转码
            httpResponse
                    .getWriter()
                    .println(
                            "<script language=\"javascript\">alert(\"您还没有登录，请先登录!\");if(window.opener==null){window.top.location.href=\""
                                    + returnUrl
                                    + "\";}else{window.opener.top.location.href=\""
                                    + returnUrl
                                    + "\";window.close();}</script>");
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
