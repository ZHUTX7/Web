package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class WishDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	public static void addWish(int user_id,int goods_id) {
		int id=1;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from Wish");
			if(rset.next())
				  id=rset.getInt(1)+1;
			
			String sql="insert into Wish values(?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2, user_id);
			pr.setInt(3, goods_id);
			pr.execute();
			pr.close();
			rset.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Wish> allWishByUserID(int id){    
		List<Wish> list = new ArrayList<Wish>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from Wish where user_id= "+id);
		      while (rset.next()){           
		    	  Wish ua=new Wish(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
		            list.add(ua);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	public static void delWishByUserandGoodsID(int id1,int id2){// 删除
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from Wish where user_id ="+id1+" and goods_id="+id2+" ;");//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	
}

