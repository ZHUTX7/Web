package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Room;

public class RoomDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	
	public static Room getRoomById(int id){ 
		 Room room=null;
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      ResultSet rset=stmt.executeQuery("select * from  Room where id="+id+";");//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      if (rset.next())  
		      {           
		    	  room=new Room(rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getString(7),rset.getString(8),rset.getInt(9),rset.getString(10),rset.getString(11));         
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return room;
	}
	//��ӷ��� �� ����RoomID
	public static int addRoom(String room_adress,int room_area,int room_floor,int room_price,int room_type,String room_toward,String room_decorate,int room_way,String room_note,String room_img){
		int id=1;
		try{    
		      try{     
		          Class.forName(driver);     
		      }catch(Exception e){     
		           e.printStackTrace();     
		      }  
		      
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt = conn.createStatement();
		      ResultSet rset = stmt.executeQuery("select max(id) from ROOM");
		      if (rset.next())           
		    	id = rset.getInt(1)+1;
		      rset.close();  
		      stmt.close(); 		      
		      PreparedStatement pstmt=conn.prepareStatement("insert into room values(?,?,?,?,?,?,?,?,?,?,?)");  
		      pstmt.setInt(1, id);
		      pstmt.setString(2, room_adress);
		      pstmt.setInt(3,room_area);	
		      pstmt.setInt(4,room_floor);
		      pstmt.setInt(5,room_price);
		      pstmt.setInt(6,room_type);
		      pstmt.setString(7, room_toward);
		      pstmt.setString(8, room_decorate);
		      pstmt.setInt(9, room_way);
		      pstmt.setString(10,room_note);
		      pstmt.setString(11,"roomImg/"+id+".jpg");
		      pstmt.execute();
		      pstmt.close();
		      conn.close();  
		      
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return id;
	}
	
	public static List<Room> allRoom(){    //�鿴���з�����Ϣ��
		List<Room> list = new ArrayList<Room>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from room ORDER BY id");
		      while (rset.next()){           
		    	  Room room=new Room(rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getString(7),rset.getString(8),rset.getInt(9),rset.getString(10),rset.getString(11)); 
		            list.add(room);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	public static void delRoom(int id){// ͨ��ID ��ɾ��������Ϣ ��
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      stmt.executeUpdate( "delete from ROOM where id ="+id);//ִ�з��� 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}

	//ģ����ѯ��
	public static List<Room> findRoomByString(int p1,int p2,String room_adress,int room_type,String room_toward,String room_decorate, int room_way){  
		//��ַ���۸񣬷��ͣ����򣬳��ⷽʽ�����䣬���ף���
		String way,type;
		if(room_way==0) {  //�û������ĳ��ⷽʽ
			way="";
		}
		else {
			way=" and room_way="+room_way+"  ";
		}
		if(room_type==0) {//�û��������м��䷿
			type="";
		}
		else {
			type=" and room_type="+room_type+ "  " ;
		}
		List<Room> list = new ArrayList<Room>();
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
		      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
		      String sql="select * from room where room_toward like '%"+room_toward+"%' and "
		      + "room_adress like '%"+room_adress+"%' and room_price>="+p1+" and room_price<="
		      +p2+"  and room_decorate like '%"+room_decorate+"%' "+way+type+" ;";
//		      String sql="select * from room where room_toward = '"+room_toward+"' and "
//				      + "room_adress like '%"+room_adress+"%' and room_price>="+p1+" and room_price<="
//				      +p2+"  and room_decorate ='"+room_decorate+"' "+way+type+" ;";
		      ResultSet rset=stmt.executeQuery(sql);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
		      while (rset.next())  
		      {           
		    	  Room room=new Room(rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),rset.getInt(6),rset.getString(7),rset.getString(8),rset.getInt(9),rset.getString(10),rset.getString(11)); 
		          list.add(room);
		      }  
		      rset.close();  
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
		return list;
	}
	//ģ����ѯ
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
			      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM room");//
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
		public static void modifyRoom(int id,String room_adress,int room_area,int room_floor,int room_price,int room_type,String room_toward,String room_decorate,int room_way,String room_note){
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
			      Statement stmt=conn.createStatement();
			      String sql1="update Room set room_adress='"+room_adress+" ' ,room_area= "
			      +room_area+", room_floor="+room_floor+",room_price="
			      +room_price+",room_type="+room_type +",room_toward='"
			      +room_toward+"',room_decorate='"+room_decorate+"' ,room_way="
			      +room_way+",room_note='"+room_note+"' where id ="+id;
			      stmt.executeUpdate(sql1);//ִ�з����ҵ�һ���� methodName ����ͬ���ķ���������Ŀ���ϵ��ø÷�����  
			      stmt.close();  
			      conn.close();  
			      
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
		
		}
		
		public static int  sumRow2(){  //��ȡ����������������־���������ڷ�ҳ��ѯ
			int num=0;
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//��������������  
			      Statement stmt=conn.createStatement();//����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣  
			      ResultSet rset=stmt.executeQuery("SELECT COUNT(*) FROM Room");//
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
