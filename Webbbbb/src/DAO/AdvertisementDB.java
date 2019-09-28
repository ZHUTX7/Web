package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Adervertisement;

public class AdvertisementDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static Adervertisement getAdById(int id){
		Adervertisement ad=null;
		try {
			try {
				 Class.forName(driver);    //加载驱动
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//建立连接
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from ADVERTISEMENT where id ="+id);
			if(rset.next()) {
				ad= new Adervertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ad;
	}
	public static void addAd(int user_id,String img,String ahref,int click,int price) {
		int id=0;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from ADVERTISEMENT");
			if(rset.next())
			  id=rset.getInt(1)+1;
			String sql="insert into ADVERTISEMENT values(?,?,?,?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2,user_id);
			pr.setString(3, "adImg/"+id+".png");
			pr.setString(4, ahref);
			pr.setInt(5,click);
			pr.setInt(6,price);
			pr.execute();
			pr.close();
			rset.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Adervertisement> allAd(){    //查看所有
		List<Adervertisement> list = new ArrayList<Adervertisement>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from ADVERTISEMENT ");
		      while (rset.next()){           
		    	  Adervertisement ua= new Adervertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));    
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
	public static void delAd(int id){// 通过ID ，
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from ADVERTISEMENT where id ="+id);//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static void modifyAd(int id,String img_url,String ahref_url,int clickSum,int ad_price) {
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			 Statement stmt=conn.createStatement();
		      String sql1="update ADVERTISEMENT set img_url='"+img_url+"' ,ahref_url='"
				      +ahref_url+"', clickSum="+clickSum +", "
				      		+ "ad_price="+ad_price+"where id ="+id;
		      stmt.executeUpdate(sql1);
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void addClick(int id) {
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			int sum=0;
			Connection conn=DriverManager.getConnection(url, user, key);
			 Statement stmt=conn.createStatement();
			 ResultSet rset=stmt.executeQuery("select * from ADVERTISEMENT where id ="+id);
				if(rset.next()) {
					sum= rset.getInt(5)+1;
				}
			
		      String sql1="update ADVERTISEMENT set CLICKSUM="+sum+"where id ="+id;
		      stmt.executeUpdate(sql1);
			  stmt.close();
			 conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<Adervertisement> getAdByUser(int id){    //查看所有房屋信息
		List<Adervertisement> list = new ArrayList<Adervertisement>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from ADVERTISEMENT where user_id="+id);
		      while (rset.next()){           
		    	  Adervertisement ua= new Adervertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));    
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
}
