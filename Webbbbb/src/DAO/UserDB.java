package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	public static User getUserById(int id){
		User us=null;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("select * from  User where id="+id+";");//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      if (rset.next())  
		      {           
		    	  us=new User(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));         
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return us;
	}
	public static void addUser(String user_password,String user_name,String user_sex,String user_email,String user_mobile,String user_personalID,String user_adress){
		int id=1;
		
		try{    
		      try{     
		          Class.forName(driver);     
		      }catch(Exception e){     
		           e.printStackTrace();     
		      }  
		      
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt = conn.createStatement();
		      ResultSet rset = stmt.executeQuery("select max(id) from User "+";");
		      if (rset.next())           
		    	id = rset.getInt(1)+1;
		      rset.close();  
		      stmt.close(); 		      
		      PreparedStatement pstmt=conn.prepareStatement("insert into User values(?,?,?,?,?,?,?,?)"+";");  	      
		      pstmt.setInt(1, id);
		      pstmt.setString(2, user_password);
		      pstmt.setString(3,user_name);	
		      pstmt.setString(4,user_sex);
		      pstmt.setString(5,user_email);
		      pstmt.setString(6,user_mobile);
		      pstmt.setString(7,user_personalID);
		      pstmt.setString(8,user_adress);
		      pstmt.execute();
		      pstmt.close();
		      conn.close();  
		     }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return ;
		
	}
	public static List<User> allUser(){    //�鿴�����û���Ϣ
		List<User> list = new ArrayList<User>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from User ORDER BY id "+";");
		      while (rset.next()){           
		    	  User us=new User(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));    
		            list.add(us);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	public static void delUser(int id){// ͨ��ID ��ɾ���û�
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from User where id ="+id+";");//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static void modifyUser(int id,String user_name,String user_sex,String user_email,String user_mobile,String user_adress){
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();
		      String sql1="update User set user_name='"+user_name+"' ,user_sex='"
				      +user_sex+"', user_email='"+user_email+"',user_mobile='"
				      +user_mobile+"',user_adress='"+user_adress +"'where id ="+id;
		      stmt.executeUpdate(sql1);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      stmt.close();  
		      conn.close();  
		      
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}
	public static User userLogin(String mobile,String psw){ //��½�������ֻ���+�����½
		User us=null;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("select * from  User where user_mobile='"+mobile+"' ;");//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      if (rset.next())  
		      {           
		    	  us=new User(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));         
		      }  
		     
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		if(us!=null&&psw.equals(us.getUser_password()))
		    return us;
		else 
			return null;
	}
	public static boolean compareUserMobile(String mobile){
		User us=null;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("select * from  User where user_mobile='"+mobile+"' ;");//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      if (rset.next())  
		      {           
		    	  us=new User(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));         
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		if(us!=null) {
			System.out.println("false");
			return false;//���ֻ����Ѿ��������������ٴ���
			
		}
		else {
			System.out.println("true");
			return true; //���ֻ���û�б����������Դ���
		}
			
	}
	public static void modifyPassword(int id,String password){
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();
		      String sql1="update User set user_password='"+password+"' where id ="+id+";";
		      stmt.executeUpdate(sql1);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
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
		      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM User "+";");//
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
	public static List<User> findUser(String key){    //ģ����ѯ
		List<User> list = new ArrayList<User>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from User where user_name like '%"+key+"%' ;");
		      while (rset.next()){           
		    	  User us=new User(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getString(5),rset.getString(6),rset.getString(7),rset.getString(8));    
		            list.add(us);
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
