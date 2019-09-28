package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Company;

public class CompanyDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	
	public static Company getCompanyById(int id){//ͨ��user_id �鹫˾
		Company a=null;
		try {
			try {
				 Class.forName(driver);    //��������
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection  conn=DriverManager.getConnection(url, user, key);//��������
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from Company where user_id ="+id);
			if(rset.next()) {
				a= new Company(rset.getInt(1),rset.getInt(2),rset.getString(3),rset.getString(4));
			}
			rset.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public static void addCompany(int user_id,String company_mobile,String company_name) {
		int id=1;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			  Statement stmt = conn.createStatement();
		      ResultSet rset = stmt.executeQuery("select max(id) from company ");
		      if (rset.next())           
		    	id = rset.getInt(1)+1;
		      rset.close();  
		      stmt.close(); 
			
			String sql="insert into Company values(?,?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setInt(2, user_id);
			pr.setString(3, company_mobile);
			pr.setString(4, company_name);
			pr.execute();
			pr.close();
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Company> allCompany(){    
		List<Company> list = new ArrayList<Company>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from Company ");
		      while (rset.next()){           
		    	  Company ua=new Company(rset.getInt(1),rset.getInt(2),rset.getString(3),rset.getString(4));    
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
	public static void delCompany(int id){// ����ID��ɾ��
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from Company where id ="+id);//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
}
