package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.UserRoom;

public class UserRoomDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
		public static UserRoom getUserRoomById(int id){
			UserRoom Ur=null;
			try {
				try {
					 Class.forName(driver);    //��������
				}catch(Exception e) {
					e.printStackTrace();
				}
				Connection  conn=DriverManager.getConnection(url, user, key);//��������
				Statement stmt=conn.createStatement();
				ResultSet rset=stmt.executeQuery("select * from UserRoom where id ="+id);
				if(rset.next()) {
					Ur= new UserRoom(rset.getInt(1),rset.getInt(2),rset.getInt(3));
				}
				rset.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return Ur;
		}
		
		public static void addUserRoom(int user_id,int room_id) {
			int id=0;
			try {
				try{
					Class.forName(driver);
				}catch(Exception e) {
					e.printStackTrace();
				}
				Connection conn=DriverManager.getConnection(url, user, key);
				Statement stmt = conn.createStatement();
				ResultSet rset =stmt.executeQuery("select max(id) from USERROOM");
				if(rset.next())
				  id=rset.getInt(1)+1;
				 rset.close();  
			     stmt.close(); 
				String sql="insert into USERROOM values(?,?,?)";
				PreparedStatement pr=conn.prepareStatement(sql);
				pr.setInt(1,id);
				pr.setInt(2, user_id);
				pr.setInt(3, room_id);
				pr.execute();
				pr.close();
				
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static List<UserRoom> allUserRoom(){    
			List<UserRoom> list = new ArrayList<UserRoom>();
			try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);
			      Statement stmt=conn.createStatement();
			      ResultSet rset=stmt.executeQuery("select * from UserRoom ");
			      while (rset.next()){           
			    	  UserRoom ua=new UserRoom(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
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
		public static void delUserRoom(int id){// ���뷿��ID��ɾ��
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
			      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
			      stmt.executeUpdate( "delete from UserRoom where room_id ="+id);//ִ�з��� 
			      stmt.close();  
			      conn.close();  
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
		
		}
		public static List<UserRoom> getUserRoomByUser(int user_id){    
			List<UserRoom> list = new ArrayList<UserRoom>();
			try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);
			      Statement stmt=conn.createStatement();
			      ResultSet rset=stmt.executeQuery("select * from UserRoom where user_id="+user_id);
			      while (rset.next()){           
			    	  UserRoom ua=new UserRoom(rset.getInt(1),rset.getInt(2),rset.getInt(3));    
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
		
		public static int getUserId(int id){ //ͨ������roomid��ѯUserID
			int user_id=0;
			try {
				try {
					 Class.forName(driver);    //��������
				}catch(Exception e) {
					e.printStackTrace();
				}
				Connection  conn=DriverManager.getConnection(url, user, key);//��������
				Statement stmt=conn.createStatement();
				ResultSet rset=stmt.executeQuery("select * from UserRoom where room_id ="+id);
				if(rset.next()) {
					 user_id=rset.getInt(2);
				}
				rset.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return user_id;
		}
	}


