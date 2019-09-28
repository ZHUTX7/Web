package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.WishDB;
import model.User;

/**
 * Servlet implementation class delWish
 */
@WebServlet("/delWish")
public class delWish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delWish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//发布出租信息，不仅要在房屋数据库里增加信息，还要在User—Room数据库中加入房屋和房东的id
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		
		Object us=request.getSession().getAttribute("user") ;
				User user = (User)us;
		if(user==null)
		request.getRequestDispatcher("account.jsp").forward(request, response);
		else {
			WishDB.delWishByUserandGoodsID(user.getUser_id(), goods_id);
			request.getRequestDispatcher("personalWish.jsp").forward(request, response);
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
