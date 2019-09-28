package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Word;

public class MyWordDB {
	private static String url = "jdbc:mysql://localhost:3306/webdatabase";
	private static String user="root";  
	private static String key="123456"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	

	public static void addWordD(String wordKey ,int count ) {
		int id=0;
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			Statement stmt = conn.createStatement();
			ResultSet rset =stmt.executeQuery("select max(id) from myString");
			if(rset.next())
			  id=rset.getInt(1)+1;
			String sql="insert into myString values(?,?,?)";
			PreparedStatement pr=conn.prepareStatement(sql);
			pr.setInt(1,id);
			pr.setString(2, wordKey);
			pr.setInt(3,1);
			pr.execute();
			pr.close();
			rset.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Word> allWord(){    //查看所有
		List<Word> list = new ArrayList<Word>();
		try{    
		      try{     
		          Class.forName(driver);     
		          }catch(Exception e){     
		           e.printStackTrace();     
		       }    
		      Connection conn=DriverManager.getConnection(url,user,key);
		      Statement stmt=conn.createStatement();
		      ResultSet rset=stmt.executeQuery("select * from myString ");
		      while (rset.next()){           
		    	  Word ua= new Word(rset.getInt(1), rset.getString(2),rset.getInt(3));    
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
	
	public static void modifyAd(int id) {
		try {
			try{
				Class.forName(driver);
			}catch(Exception e) {
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection(url, user, key);
			 Statement stmt=conn.createStatement();
		      String sql1="update myString set count=count+1 where id="+id +" ;";
		      stmt.executeUpdate(sql1);
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
