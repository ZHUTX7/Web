package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GoodsDB;
import DAO.RoomDB;

/**
 * Servlet implementation class modifyGoods
 */
@WebServlet("/modifyGoods")
public class modifyGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("goods_id"));
		Double goods_price=Double.parseDouble(request.getParameter("goods_price"));
		String goods_note=request.getParameter("goods_note");
		String goods_img=request.getParameter("goods_img");
		String goods_type=request.getParameter("goods_type");
		String goods_name=request.getParameter("goods_name");
		GoodsDB.modifyGoods(id, goods_name, goods_price, goods_type, goods_note, goods_img);
		request.getRequestDispatcher("UserGoods.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
