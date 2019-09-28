package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdvertisementDB;
import DAO.GoodsDB;
import DAO.UserGoodsDB;

/**
 * Servlet implementation class addAdervertisement
 */
@WebServlet("/addAdervertisement")
public class addAdervertisement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addAdervertisement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		int price=Integer.parseInt(request.getParameter("ad_price"));
		String ahref=request.getParameter("ahref_url");
		String img=request.getParameter("img_url");
		AdvertisementDB.addAd(user_id, img, ahref, 0, price);
		request.getRequestDispatcher("AdvertiseManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
