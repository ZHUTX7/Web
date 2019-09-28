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
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("select * from  Goods where id="+id);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
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
	public static List<Goods> allGoods(){    //�鿴���з�����Ϣ
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
	
	public static void delGoods(int id){// ͨ��ID ��ɾ������
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from Goods where id ="+id);//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	//ģ����ѯ
		public static List<Goods> findGoodsByString(String keyWords){  
			//�ؼ��ֶβ�ѯ
			List<Goods> list = new ArrayList<Goods>();
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
			      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
			      String sql="select * from Goods where  goods_name like '%"+keyWords+"%' ";
			      ResultSet rset=stmt.executeQuery(sql);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
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
			      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
			      Statement stmt=conn.createStatement();
			      String sql1="update Goods set GOODS_NAME  ='"+goods_name+" ' ,goods_price="
					      +goods_price+", goods_type='"+goods_type+"',goods_note='"
					      +goods_note+"',goods_img='"+goods_img +"'where id ="+id;
			      stmt.executeUpdate(sql1);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
			      stmt.close();  
			      conn.close();  
			      
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
		
		}

}
