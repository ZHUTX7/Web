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
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      ResultSet rset=stmt.executeQuery("select * from  Room where id="+id+";");//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
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
	//添加房屋 √ 返回RoomID
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
	
	public static List<Room> allRoom(){    //查看所有房屋信息√
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
	public static void delRoom(int id){// 通过ID ，删除房屋信息 √
		 try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      stmt.executeUpdate( "delete from ROOM where id ="+id);//执行方法 
		      stmt.close();  
		      conn.close();  
		    }catch(SQLException sqle){  
		          System.err.println(sqle);  
		  } 
	
	}

	//模糊查询√
	public static List<Room> findRoomByString(int p1,int p2,String room_adress,int room_type,String room_toward,String room_decorate, int room_way){  
		//地址，价格，房型，朝向，出租方式（单间，整套），
		String way,type;
		if(room_way==0) {  //用户不关心出租方式
			way="";
		}
		else {
			way=" and room_way="+room_way+"  ";
		}
		if(room_type==0) {//用户不关心有几间房
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
		      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
		      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
		      String sql="select * from room where room_toward like '%"+room_toward+"%' and "
		      + "room_adress like '%"+room_adress+"%' and room_price>="+p1+" and room_price<="
		      +p2+"  and room_decorate like '%"+room_decorate+"%' "+way+type+" ;";
//		      String sql="select * from room where room_toward = '"+room_toward+"' and "
//				      + "room_adress like '%"+room_adress+"%' and room_price>="+p1+" and room_price<="
//				      +p2+"  and room_decorate ='"+room_decorate+"' "+way+type+" ;";
		      ResultSet rset=stmt.executeQuery(sql);//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
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
	//模糊查询
		public static int  sumRow(){  //获取表中总行数，即日志总数，用于分页查询
			int num=0;
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
			      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
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
			      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
			      Statement stmt=conn.createStatement();
			      String sql1="update Room set room_adress='"+room_adress+" ' ,room_area= "
			      +room_area+", room_floor="+room_floor+",room_price="
			      +room_price+",room_type="+room_type +",room_toward='"
			      +room_toward+"',room_decorate='"+room_decorate+"' ,room_way="
			      +room_way+",room_note='"+room_note+"' where id ="+id;
			      stmt.executeUpdate(sql1);//执行方法找到一个与 methodName 属性同名的方法，并在目标上调用该方法。  
			      stmt.close();  
			      conn.close();  
			      
			    }catch(SQLException sqle){  
			          System.err.println(sqle);  
			  } 
		
		}
		
		public static int  sumRow2(){  //获取表中总行数，即日志总数，用于分页查询
			int num=0;
			 try{    
			      try{     
			          Class.forName(driver);     
			          }catch(Exception e){     
			           e.printStackTrace();     
			       }    
			      Connection conn=DriverManager.getConnection(url,user,key);//把驱动放入连接  
			      Statement stmt=conn.createStatement();//创建一个 Statement 对象来将 SQL 语句发送到数据库。  
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
