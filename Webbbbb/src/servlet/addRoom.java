package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.*;


/**
 * Servlet implementation class addRoom
 */
@WebServlet("/addRoom")
public class addRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addRoom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//发布出租信息，不仅要在房屋数据库里增加信息，还要在User—Room数据库中加入房屋和房东的id
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		int room_area=Integer.parseInt(request.getParameter("room_area"));
		int room_floor=Integer.parseInt(request.getParameter("room_floor"));
		int room_way=Integer.parseInt(request.getParameter("room_way"));
		int room_price=Integer.parseInt(request.getParameter("room_price"));
		int room_type=Integer.parseInt(request.getParameter("room_type"));
		String room_adress=request.getParameter("room_adress");
		String room_toward=request.getParameter("room_toward");
		String room_note=request.getParameter("room_note");
		String room_decorate=request.getParameter("room_decorate");
		int room_id=RoomDB.addRoom(room_adress, room_area, room_floor, room_price, room_type, room_toward, room_decorate, room_way, room_note, "");
		UserRoomDB.addUserRoom(user_id, room_id);
		request.getRequestDispatcher("UserRoom.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
