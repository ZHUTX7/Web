package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Apply;

public class ApplyDB {

	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	

	public static Apply getApplyById(int id){
		Apply a=null;
		try {
			try {
				 Class.forName(driver);    //��������
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//��������
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from Apply where user_id ="+id);
			if(rset.next()) {
				a= new Apply(rset.getInt(1),rset.getString(2),rset.getString(3));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public static void addApply(int user_id,String mobile,String company_name) {
		
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			String sql="insert into Apply values(?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,user_id);
			pr.setString(2, mobile);
			pr.setString(3, company_name);
			pr.execute();
			pr.close();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Apply> allApply(){    
		List<Apply> list = new ArrayList<Apply>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from Apply ");
		      while (rset.next()){           
		    	  Apply ua=new Apply(rset.getInt(1),rset.getString(2),rset.getString(3));    
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
	public static void delApply(int id){// ɾ��
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from Apply where user_id ="+id);//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
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
		      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM Apply");//
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
