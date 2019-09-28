package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdvertisementDB;
import DAO.PublishAdDB;
import model.Adervertisement;

/**
 * Servlet implementation class agreeAd
 */
@WebServlet("/agreeAd")
public class agreeAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agreeAd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int ad_id=Integer.parseInt(request.getParameter("ad_id"));
		Adervertisement a=AdvertisementDB.getAdById(ad_id);
		PublishAdDB.addPublishAdvertisement(a.getUser_id(),a.getImg_url(), a.getAhref_url(), a.getClickSum(), a.getAd_price());
		AdvertisementDB.delAd(ad_id);
		request.getRequestDispatcher("allAdApplyManage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
