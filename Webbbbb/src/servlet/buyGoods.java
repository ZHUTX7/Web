package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;

/**
 * Servlet implementation class buyGoods
 */
@WebServlet("/buyGoods")
public class buyGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buyGoods() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//发布出租信息，不仅要在房屋数据库里增加信息，还要在User—Room数据库中加入房屋和房东的id
		int customer_id=Integer.parseInt(request.getParameter("customer_id"));
		int seller_id=Integer.parseInt(request.getParameter("seller_id"));
		int goods_id=Integer.parseInt(request.getParameter("goods_id"));
		double goods_price=Double.parseDouble(request.getParameter("goods_price"));
		String goods_name=request.getParameter("goods_name");
		String customer_mobile=request.getParameter("customer_mobile");
		String customer_adress=request.getParameter("customer_adress");
		OrderDB.addOrder(customer_id, seller_id, goods_name, goods_price, customer_mobile, customer_adress);
		GoodsDB.delGoods(goods_id);//删除goods表中数据
		UserGoodsDB.delUserGoods(goods_id);//删除用户发布物品表中数据
		request.getRequestDispatcher("successBuy.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
