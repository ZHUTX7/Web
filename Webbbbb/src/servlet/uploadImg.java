package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.User;


@WebServlet("/uploadImg")
@MultipartConfig
public class uploadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public uploadImg() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();  
		 String id1 = (String)session.getAttribute("rid");  		
		 String id2 = (String)session.getAttribute("gid");
		 String id3 = (String)session.getAttribute("ad");
		// System.out.println(user.getUser_id());
		if(id1!=null) {
		Part part1 = request.getPart("file");
		part1.write("D:/Keshe/58Web13/WebContent/roomImg/"+id1+".jpg");
		session.removeAttribute("rid");
		request.getRequestDispatcher("UserRoom.jsp?addResult=添加成功").forward(request, response);
		}
		else if(id2!=null) {
				Part part1 = request.getPart("file");
				part1.write("D:/Keshe/58Web13/WebContent/goodsImg/"+id2+".jpg");
				 session.removeAttribute("rid");
				request.getRequestDispatcher("UserGoods.jsp?addResult=添加成功").forward(request, response);
				}
		else if(id3!=null) {
			Part part1 = request.getPart("file");
			part1.write("D:/Keshe/58Web13/WebContent/adImg/"+id3+".jpg");
			 session.removeAttribute("rid");
			request.getRequestDispatcher("index.jsp?addResult=添加成功").forward(request, response);
			}
		 else
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
