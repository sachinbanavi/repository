import java.sql.*;

public class Jdbcdata {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/STUDENTS";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "user";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      //STEP 4: Execute a query
	      //System.out.println("Creating database...");
	      //stmt = conn.createStatement();
	      
	      //String sql = "CREATE DATABASE STUDENTS";
	      //stmt.executeUpdate(sql);
	      //System.out.println("Database created successfully...");	
	   
	      System.out.println("Creating table in given database...");
	      stmt = conn.createStatement();
	      
	     /* String sql = "CREATE TABLE Tweet " +
	                   "(id INTEGER not NULL, " +
	                   " user VARCHAR(30), " + 
	                   " department VARCHAR(20), " +
	                   "tweets VARCHAR(200), " +
	                   " location VARCHAR(35), " + 
	                   " PRIMARY KEY ( id ))"; 

	      */
	      //stmt.executeUpdate(sql);
	      stmt.executeUpdate("INSERT INTO Tweet " + "VALUES ('12', 'Sachin', 'CS', 'Houdy!', 'Dallas')");
	      //stmt.executeUpdate(sql1);
	      System.out.println("Created table in given database...");	   
	   
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	}//end JDBCExample
