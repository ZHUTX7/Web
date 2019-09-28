package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Rent;

public class RentDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
     public static void addRent(int customer_id,int seller_id,
    		int  room_price,String room_adress,String begin_date,String end_date) {
		     int id=1;
		     
 		try{    
 		      try{     
 		          Class.forName(driver);     
 		      }catch(Exception e){     
 		           e.printStackTrace();     
 		      }  
 		      
 		      Connection conn=DriverManager.getConnection(url,user,key);
 		      Statement stmt = conn.createStatement();
 		      ResultSet rset = stmt.executeQuery("select max(id) from Rent ");
 		      if (rset.next())           
 		    	id = rset.getInt(1)+1;
 		      rset.close();  
 		      stmt.close(); 		      
 		      PreparedStatement pstmt=conn.prepareStatement("insert into Rent values(?,?,?,?,?,?,?)");  	      
 		      pstmt.setInt(1, id);
 		      pstmt.setInt(2, customer_id);
 		      pstmt.setInt(3,seller_id);	
 		      pstmt.setInt(4,room_price);
 		      pstmt.setString(5,room_adress);
 		     pstmt.setString(6,begin_date);
 		    pstmt.setString(7,end_date);
 		     
 		      pstmt.execute();
 		      pstmt.close();
 		      conn.close();  
 		     }catch(SQLException sqle){  
 		          System.err.println(sqle);  
 		  } 
 		return ;
	}
     public static List<Rent> getOrderByCustomer( int id){    //通过买家id,查看所有交易信息
 		List<Rent> list = new ArrayList<Rent>();
 		try{    
 		      try{     
 		          Class.forName(driver);     
 		          }catch(Exception e){     
 		           e.printStackTrace();     
 		       }    
 		      Connection conn=DriverManager.getConnection(url,user,key);
 		      Statement stmt=conn.createStatement();
 		      ResultSet rset=stmt.executeQuery("select * from Rent where customer_id="+id);
 		      while (rset.next()){    
 		    	 Rent o=new Rent(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getString(6), rset.getString(7));
 		          list.add(o);
 		      }  
 		      rset.close();  
 		      stmt.close();  
 		      conn.close();  
 		    }catch(SQLException sqle){  
 		          System.err.println(sqle);  
 		  } 
 		return list;
 	}
     public static List<Rent> getOrderBySeller( int id){    //通过卖家id,查看所有交易信息
  		List<Rent> list = new ArrayList<Rent>();
  		try{    
  		      try{     
  		          Class.forName(driver);     
  		          }catch(Exception e){     
  		           e.printStackTrace();     
  		       }    
  		      Connection conn=DriverManager.getConnection(url,user,key);
  		      Statement stmt=conn.createStatement();
  		      ResultSet rset=stmt.executeQuery("select * from Rent where seller_id="+id);
  		      while (rset.next()){    
  		    	 Rent o=new Rent(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getString(6), rset.getString(7));
  		          list.add(o);
  		      }  
  		      rset.close();  
  		      stmt.close();  
  		      conn.close();  
  		    }catch(SQLException sqle){  
  		          System.err.println(sqle);  
  		  } 
  		return list;
  	}
     public static Rent getOrderByRentId(int id){    //通过rent_id,查看所有交易信息
    	 Rent o=null;
   		try{    
   		      try{     
   		          Class.forName(driver);     
   		          }catch(Exception e){     
   		           e.printStackTrace();     
   		       }    
   		      Connection conn=DriverManager.getConnection(url,user,key);
   		      Statement stmt=conn.createStatement();
   		      ResultSet rset=stmt.executeQuery("select * from Rent where id="+id);
   		      if(rset.next()){    
   		    	 o=new Rent(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getString(6), rset.getString(7));
   		         
   		      }  
   		      rset.close();  
   		      stmt.close();  
   		      conn.close();  
   		    }catch(SQLException sqle){  
   		          System.err.println(sqle);  
   		  } 
   		return o;
   	}
     
}
