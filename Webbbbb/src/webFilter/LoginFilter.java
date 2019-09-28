package webFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	private String us;
    private String rediretUrl;
    private String uncheckedUrls;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext=filterConfig.getServletContext();
        us=servletContext.getInitParameter("user");
        rediretUrl=servletContext.getInitParameter("rediretUrl");//重定向页面
        uncheckedUrls=servletContext.getInitParameter("uncheckedUrls");//不需要判断登陆的页面
    }

    @Override
    public void destroy() {

    }
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;
        StringBuffer server =httpServletRequest.getRequestURL();
        if(server.toString().contains(".css")||server.toString().contains(".js")
        		||server.toString().contains(".png")||server.toString().contains(".jpg")) {
        	 filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
        
        //1、得到用户请求路径
        String servletPath=httpServletRequest.getServletPath();
        //2、放行不需要过滤的页面，如登录界面之类的
        List<String> urls=Arrays.asList(uncheckedUrls.split(","));
        if(urls.contains(servletPath)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        //3、从session中获取用户并判断用户是否登录过，如果没有登录过则重定向到登录界面
        Object user= httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/account.jsp");
            return;
        }
       
        //4、否则放行
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}


