package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.*;


public class OrderDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	
     public static void addOrder(int customer_id,int seller_id,
    		 String goods_name,double goods_price,String customer_mobile,
    		 String customer_adress) {
		     int id=1;
		     int year = (new Date().getYear())+1900;
			 int month = (new Date().getMonth())+1;
			 int day =new Date().getDay()+14;
 		try{    
 		      try{     
 		          Class.forName(driver);     
 		      }catch(Exception e){     
 		           e.printStackTrace();     
 		      }  
 		      
 		      Connection conn=DriverManager.getConnection(url,user,key);
 		      Statement stmt = conn.createStatement();
 		      ResultSet rset = stmt.executeQuery("select max(id) from BuyGoods ");
 		      if (rset.next())           
 		    	id = rset.getInt(1)+1;
 		      rset.close();  
 		      stmt.close(); 		      
 		      PreparedStatement pstmt=conn.prepareStatement("insert into BuyGoods values(?,?,?,?,?,?,?,?,?,?)");  	      
 		      pstmt.setInt(1, id);
 		      pstmt.setInt(2, customer_id);
 		      pstmt.setInt(3,seller_id);	
 		      pstmt.setInt(4,year);
 		      pstmt.setInt(5,month);
 		      pstmt.setInt(6,day);
 		      pstmt.setString(7,goods_name);
 		      pstmt.setDouble(8,goods_price);
 		      pstmt.setString(9,customer_mobile);
 		      pstmt.setString(10,customer_adress);
 		      pstmt.execute();
 		      pstmt.close();
 		      conn.close();  
 		     }catch(SQLException sqle){  
 		          System.err.println(sqle);  
 		  } 
 		return ;
	}
     public static List<Order> getOrderByCustomer( int id){    //通过买家id,查看所有交易信息
 		List<Order> list = new ArrayList<Order>();
 		try{    
 		      try{     
 		          Class.forName(driver);     
 		          }catch(Exception e){     
 		           e.printStackTrace();     
 		       }    
 		      Connection conn=DriverManager.getConnection(url,user,key);
 		      Statement stmt=conn.createStatement();
 		      ResultSet rset=stmt.executeQuery("select * from BuyGoods where customer_id="+id);
 		      while (rset.next()){    
 		    	 Order  o=new Order(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getDouble(8), rset.getString(9),rset.getString(10));
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
     public static List<Order> getOrderBySeller( int id){    //通过卖家id,查看所有交易信息
  		List<Order> list = new ArrayList<Order>();
  		try{    
  		      try{     
  		          Class.forName(driver);     
  		          }catch(Exception e){     
  		           e.printStackTrace();     
  		       }    
  		      Connection conn=DriverManager.getConnection(url,user,key);
  		      Statement stmt=conn.createStatement();
  		      ResultSet rset=stmt.executeQuery("select * from BuyGoods where seller_id="+id);
  		      while (rset.next()){    
  		    	 Order  o=new Order(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getDouble(8), rset.getString(9),rset.getString(10));
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
     public static Order getOrderId(int id){    //通过卖家id,查看所有交易信息
   		Order o=null;
   		try{    
   		      try{     
   		          Class.forName(driver);     
   		          }catch(Exception e){     
   		           e.printStackTrace();     
   		       }    
   		      Connection conn=DriverManager.getConnection(url,user,key);
   		      Statement stmt=conn.createStatement();
   		      ResultSet rset=stmt.executeQuery("select * from BuyGoods where id="+id);
   		      if(rset.next()){    
   		    	 o=new Order(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getDouble(8), rset.getString(9),rset.getString(10));
   		         
   		      }  
   		      rset.close();  
   		      stmt.close();  
   		      conn.close();  
   		    }catch(SQLException sqle){  
   		          System.err.println(sqle);  
   		  } 
   		return o;
   	}
     public static List<Order> OrderFind(int id,String year,String month,String day){    //模糊查询,需要顾客ID
   		List<Order> list = new ArrayList<Order>();
   		if(year!=null&&year!="") { //如果不为空
   			year="="+year;
   		}
   		else {//year=0
   			year=">0";
   		}
   		if(month!=null&&month!="") { //如果不为空
   			month="="+month;
   		}
   		else {//year=0
   			month=">0";
   		}
   		if(day!=null&&day!="") { //如果不为空
   			day="="+day;
   		}
   		else {//year=0
   			day=">0";
   		}
   		try{    
   		      try{     
   		          Class.forName(driver);     
   		          }catch(Exception e){     
   		           e.printStackTrace();     
   		       }    
   		      Connection conn=DriverManager.getConnection(url,user,key);
   		      Statement stmt=conn.createStatement();
   		     
   		      ResultSet rset=stmt.executeQuery("select * from BuyGoods where CUSTOMER_ID="+id+"  and year"+year+"  and month"+month+"  and day"+day+";");
   		      while (rset.next()){    
   		    	 Order  o=new Order(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getDouble(8), rset.getString(9),rset.getString(10));
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
     public static List<Order> OrderFindBySeller(int id,String year,String month,String day){    //模糊查询,需要卖家ID
    		List<Order> list = new ArrayList<Order>();
    		if(year!=null&&year!="") { //如果不为空
    			year="="+year;
    		}
    		else {//year=0
    			year=">0";
    		}
    		if(month!=null&&month!="") { //如果不为空
    			month="="+month;
    		}
    		else {//year=0
    			month=">0";
    		}
    		if(day!=null&&day!="") { //如果不为空
    			day="="+day;
    		}
    		else {//year=0
    			day=">0";
    		}
    		try{    
    		      try{     
    		          Class.forName(driver);     
    		          }catch(Exception e){     
    		           e.printStackTrace();     
    		       }    
    		      Connection conn=DriverManager.getConnection(url,user,key);
    		      Statement stmt=conn.createStatement();
    		     
    		      ResultSet rset=stmt.executeQuery("select * from BuyGoods where seller_ID="+id+"  and year"+year+"  and month"+month+"  and day"+day+";");
    		      while (rset.next()){    
    		    	 Order  o=new Order(rset.getInt(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getString(7), rset.getDouble(8), rset.getString(9),rset.getString(10));
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
}
