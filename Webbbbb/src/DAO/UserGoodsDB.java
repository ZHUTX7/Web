package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserGoods;

public class UserGoodsDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver"; 
	
	
	
	public static UserGoods getUserGoodsById(int id){
		UserGoods Ug=null;
		try {
			try {
				 Class.forName(driver);    //加载驱动
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//建立连接
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from UserGoods where id ="+id);
			if(rset.next()) {
				Ug= new UserGoods(rset.getInt(1),rset.getInt(2),rset.getInt(3));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Ug;
	}
	
	public static void addUserGoods(int user_id,int goods_id) {
		int id=0;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from UserGoods");
			if(rset.next())
			  id=rset.getInt(1)+1;
			String sql="insert into UserGoods values(?,?,?)";
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
	
	public static List<UserGoods> allUserGoods(){    
		List<UserGoods> list = new ArrayList<UserGoods>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from UserGoods ");
		      while (rset.next()){           
		    	  UserGoods ug=new UserGoods(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
		            list.add(ug);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	public static List<UserGoods> getUserGoodsByUser(int user_id){    
		List<UserGoods> list = new ArrayList<UserGoods>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from UserGoods where user_id="+user_id);
		      while (rset.next()){           
		    	  UserGoods ug=new UserGoods(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
		            list.add(ug);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	public static void delUserGoods(int id){// 通过goods_ID ，删除
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from UserGoods where goods_id ="+id);//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static int getUserId(int id){ //通过goods_id查询userID
		int user_id=0;
		try {
			try {
				 Class.forName(driver);    //加载驱动
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//建立连接
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from UserGoods where goods_id ="+id);
			if(rset.next()) {
				user_id=rset.getInt(2);
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user_id;
	}
}
