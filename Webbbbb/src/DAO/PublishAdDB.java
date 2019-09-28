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

public class PublishAdDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	public static PublishAdvertisement getAdById(int id){
		PublishAdvertisement ad=null;
		try {
			try {
				 Class.forName(driver);    //��������
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//��������
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from PublishAdvertisement where id ="+id);
			if(rset.next()) {
				ad= new PublishAdvertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ad;
	}
	public static void addPublishAdvertisement(int user_id,String img,String ahref,int click,int price) {
		int id=0;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from PublishAdvertisement");
			if(rset.next())
			  id=rset.getInt(1)+1;
			String sql="insert into PublishAdvertisement values(?,?,?,?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2,user_id);
			pr.setString(3, "images/sub-banner"+id+".png");
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
	
	public static List<PublishAdvertisement> allAd(){    //
		List<PublishAdvertisement> list = new ArrayList<PublishAdvertisement>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from PublishAdvertisement ");
		      while (rset.next()){           
		    	  PublishAdvertisement ua= new PublishAdvertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));    
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
	public static void delAd(int id){// ͨ��ID ��
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from PublishAdvertisement where id ="+id);//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static void modifyAd(int id,String img_url,String ahref_url ) {
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			 Statement stmt=conn.createStatement();
		      String sql1="update PublishAdvertisement set img_url='"+img_url+"' ,ahref_url='"
				      +ahref_url+"' where id ="+id;
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
			 ResultSet rset=stmt.executeQuery("select * from PublishAdvertisement where id ="+id);
				if(rset.next()) {
					sum= rset.getInt(5)+1;
				}
			
		      String sql1="update PublishAdvertisement set CLICKSUM="+sum+"where id ="+id;
		      stmt.executeUpdate(sql1);
			  stmt.close();
			 conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static List<PublishAdvertisement> getAdByUser(int id){    //ͨ���û�ID����ѯ�������
		List<PublishAdvertisement> list = new ArrayList<PublishAdvertisement>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from PublishAdvertisement where user_id="+id);
		      while (rset.next()){           
		    	  PublishAdvertisement ua= new PublishAdvertisement(rset.getInt(1),rset.getInt(2), rset.getString(3),  rset.getString(4), rset.getInt(5), rset.getInt(6));    
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
	public static int  sumRow(){  //��ȡ����������������־���������ڷ�ҳ��ѯ
		int num=0;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM PublishAdvertisement");//
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
	public static int getSumMoney(){
		int sum=0;
		try {
			try {
				 Class.forName(driver);    //��������
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//��������
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery(" select  sum(AD_PRICE) from PUBLISHADVERTISEMENT");
			if(rset.next()) {
				sum= rset.getInt(1);
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
}

