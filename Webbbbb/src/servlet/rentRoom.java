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
 * Servlet implementation class rentRoom
 */
@WebServlet("/rentRoom")
public class rentRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rentRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession s=request.getSession();
		if(s.getAttribute("user")==null) {
			request.getRequestDispatcher("account.jsp").forward(request, response);
		}
		
		//发布出租信息，不仅要在房屋数据库里增加信息，还要在User—Room数据库中加入房屋和房东的id
		int customer_id=Integer.parseInt(request.getParameter("customer_id"));
		int seller_id=Integer.parseInt(request.getParameter("seller_id"));
		int room_price=Integer.parseInt(request.getParameter("room_price"));
		int room_id=Integer.parseInt(request.getParameter("room_id"));
		String begin_date=request.getParameter("begin_date");
		String end_date=request.getParameter("end_date");
		String room_adress=request.getParameter("room_adress");
		RentDB.addRent(customer_id, seller_id, room_price, room_adress,begin_date,end_date);
		RoomDB.delRoom(room_id);
		UserRoomDB.delUserRoom(room_id);
		
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
