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



public class GoodsDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	
	public static Goods getGoodsById(int id){
		 Goods goods=null;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      ResultSet rset=stmt.executeQuery("select * from  Goods where id="+id);//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
		      if (rset.next())  
		      {           
		    	  goods=new Goods(rset.getInt(1),rset.getString(2),rset.getDouble(3),rset.getString(4),rset.getString(5),rset.getString(6));         
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return goods;
	}
	public static int addGoods(String goods_name,double goods_price,String goods_types,String goods_note,String goods_img){
		int id=1;
		try{    
		      try{     
		          Class.forName(driver);     
		      }catch(Exception e){     
		           e.printStackTrace();     
		      }  
		      
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt = conn.createStatement();
		      ResultSet rset = stmt.executeQuery("select max(id) from Goods");
		      if (rset.next())           
		    	id = rset.getInt(1)+1;
		      rset.close();  
		      stmt.close(); 		      
		      PreparedStatement pstmt=conn.prepareStatement("insert into Goods values(?,?,?,?,?,?)");  
		      pstmt.setInt(1, id);
		      pstmt.setString(2, goods_name);
		      pstmt.setDouble(3,goods_price);	
		      pstmt.setString(4,goods_types);
		      pstmt.setString(5,goods_note);
		      pstmt.setString(6,"roomImg/"+id+".png");
		      
		      pstmt.execute();
		      pstmt.close();
		      conn.close();  
		      
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return id;
	}
	public static List<Goods> allGoods(){    //查看所有房屋信息
		List<Goods> list = new ArrayList<Goods>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from Goods ORDER BY id");
		      while (rset.next()){           
		    	  Goods  goods=new Goods(rset.getInt(1),rset.getString(2),rset.getDouble(3),rset.getString(4),rset.getString(5),rset.getString(6));   
		          list.add(goods);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	
	public static void delGoods(int id){// 通过ID ，删除货物
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from Goods where id ="+id);//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	//模糊查询
		public static List<Goods> findGoodsByString(String keyWords){  
			//关键字段查询
			List<Goods> list = new ArrayList<Goods>();
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
			      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
			      String sql="select * from Goods where  goods_name like '%"+keyWords+"%' ";
			      ResultSet rset=stmt.executeQuery(sql);//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
			      while (rset.next())  
			      {           
			    	  Goods gs=new Goods(rset.getInt(1),rset.getString(2),rset.getDouble(3),rset.getString(4),rset.getString(5),rset.getString(6));    
			          list.add(gs);
			      }  
			      rset.close();  
			      stmt.close();  
			      conn.close();  
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
			return list;
		}
		public static void modifyGoods(int id,String goods_name,double goods_price,String goods_type,String goods_note,String goods_img){
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
			      Statement stmt=conn.createStatement();
			      String sql1="update Goods set GOODS_NAME  ='"+goods_name+" ' ,goods_price="
					      +goods_price+", goods_type='"+goods_type+"',goods_note='"
					      +goods_note+"',goods_img='"+goods_img +"'where id ="+id;
			      stmt.executeUpdate(sql1);//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
			      stmt.close();  
			      conn.close();  
			      
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
		
		}

}
