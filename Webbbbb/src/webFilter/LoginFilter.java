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
        rediretUrl=servletContext.getInitParameter("rediretUrl");//�ض���ҳ��
        uncheckedUrls=servletContext.getInitParameter("uncheckedUrls");//����Ҫ�жϵ�½��ҳ��
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
        
        //1���õ��û�����·��
        String servletPath=httpServletRequest.getServletPath();
        //2�����в���Ҫ���˵�ҳ�棬���¼����֮���
        List<String> urls=Arrays.asList(uncheckedUrls.split(","));
        if(urls.contains(servletPath)){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        //3����session�л�ȡ�û����ж��û��Ƿ��¼�������û�е�¼�����ض��򵽵�¼����
        Object user= httpServletRequest.getSession().getAttribute("user");
        if(user==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/account.jsp");
            return;
        }
       
        //4���������
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}


