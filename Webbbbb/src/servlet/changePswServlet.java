package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDB;

/**
 * Servlet implementation class changePswServlet
 */
@WebServlet("/changePswServlet")
public class changePswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePswServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("user_id"));
		String password=request.getParameter("password");
		String user_password=request.getParameter("password1");
		String new_password1=request.getParameter("new_password1");
		String new_password2=request.getParameter("new_password2");
		if(!password.equals(user_password)) {  //输入旧密码与原密码相同
			request.getRequestDispatcher("modifyPassword.jsp?result=密码输入错误").forward(request, response);
		}
		if(!new_password1.equals(new_password2)) {
			request.getRequestDispatcher("modifyPassword.jsp?result=两次输入的新密码不一致").forward(request, response);
		}
		else {
			UserDB.modifyPassword(id, new_password2);
			request.getRequestDispatcher("modifyPassword.jsp?result=密码修改成功！").forward(request, response);
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
