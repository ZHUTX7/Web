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
 * Servlet implementation class modifyServlet
 */
@WebServlet("/modifyUser")
public class modifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int  id=Integer.parseInt(request.getParameter("user_id"));
		String user_email=request.getParameter("user_email");
		String user_mobile=request.getParameter("user_mobile");
		//String user_password=request.getParameter("user_password");
		String user_adress=request.getParameter("user_adress");
		String user_sex=request.getParameter("user_sex");
		String user_name=request.getParameter("user_name");
		//String user_personalID=request.getParameter("user_personalID");
		UserDB.modifyUser(id, user_name, user_sex, user_email, user_mobile, user_adress);
		
		User us=UserDB.getUserById(id);
		 HttpSession s=request.getSession();
		   s.setAttribute("user", us);//传入对象
		   request.getRequestDispatcher("personalInfo.jsp").forward(request, response);
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
