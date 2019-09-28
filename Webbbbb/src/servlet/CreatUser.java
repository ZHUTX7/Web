package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDB;

/**
 * Servlet implementation class CreatUser
 */
@WebServlet("/CreatUser")
public class CreatUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_mobile=request.getParameter("user_mobile");
		String user_password=request.getParameter("password");
		String re_password=request.getParameter("repassword");
		String user_sex=request.getParameter("user_sex");
		String user_name=request.getParameter("user_name");
		String agree=request.getParameter("agree");
		if(agree==null){
			request.getRequestDispatcher("falseCreat.jsp?result=未勾选同意协议").forward(request, response);
		}
		else if(!re_password.equals(user_password)){
			request.getRequestDispatcher("falseCreat.jsp?result=两次输入的密码不一致！").forward(request, response);
		}
		else if(!UserDB.compareUserMobile(user_mobile)){
			request.getRequestDispatcher("falseCreat.jsp?result=该手机已经被注册！").forward(request, response);
		}
		
		else {
			UserDB.addUser(user_password, user_name, user_sex, "", user_mobile, "", "");
			request.getRequestDispatcher("suceessCreat.jsp").forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
