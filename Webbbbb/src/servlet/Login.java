package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.UserDB;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_mobile=request.getParameter("user_mobile");
		String user_password=request.getParameter("user_password");
		
		if(UserDB.userLogin(user_mobile,user_password)!=null) {
			User us=UserDB.userLogin(user_mobile,user_password);
		   HttpSession s=request.getSession();
		   s.setAttribute("user", us);//传入对象
		   request.getRequestDispatcher("personalInfo.jsp").forward(request, response);
		}
		else
			request.getRequestDispatcher("account.jsp?result=用户名或密码错误 ").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
