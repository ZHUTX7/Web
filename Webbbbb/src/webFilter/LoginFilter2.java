//package webFilter;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import model.User;
//
///**
// * Servlet Filter implementation class LoginFilter
// */
//@WebFilter("*.do")
//public class LoginFilter2 implements Filter {
//	
//    
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain filterChain) throws IOException, ServletException {
//    	
//       HttpSession session=((HttpServletRequest)request).getSession();
//       if(session.getAttribute("user")==null) {
//    	   ((HttpServletResponse)response).sendRedirect("account.jsp");
//       }else {
//    	   filterChain.doFilter(request,response);
//       }
//    }
//}
//
//
