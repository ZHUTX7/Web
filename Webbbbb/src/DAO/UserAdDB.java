package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.UserAd;

public class UserAdDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static UserAd getUserAdById(int id){
		UserAd Ua=null;
		try {
			try {
				 Class.forName(driver);    //加载驱动
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//建立连接
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from UserAd where id ="+id);
			if(rset.next()) {
				Ua= new UserAd(rset.getInt(1),rset.getInt(2),rset.getInt(3));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return Ua;
	}
	public static void addUserAd(int user_id,int ad_id) {
		int id=0;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from UserAd");
			if(rset.next())
			  id=rset.getInt(1)+1;
			String sql="insert into UserAd values(?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2, user_id);
			pr.setInt(3, ad_id);
			pr.close();
			rset.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<UserAd> allUserAd(){    
		List<UserAd> list = new ArrayList<UserAd>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from UserAd ");
		      while (rset.next()){           
		    	  UserAd ua=new UserAd(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
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
	public static void delUserAd(int id){// 通过ID ，删除已发布广告
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from UserAd where id ="+id);//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static int  sumRow(){  //获取表中总行数，即日志总数，用于分页查询
		int num=0;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM UserAd");//
		      if(rset.next())  
		      {           
		    	  num= rset.getInt(1);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return num;
	}
}
