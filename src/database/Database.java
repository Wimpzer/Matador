<<<<<<< HEAD
package database;

public class Database {

	
	
}
=======
package database;

public class Database {

	String url = "jdbc:mysql://82.211.212.144:3306";
	String DBuser = "user";
	String DBpassword = "123QWEasd";
	Connection conn;
	Statement stt;
	
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, DBuser, DBpassword);
		}catch(SQLException e){
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
}
>>>>>>> 683239968a3f96fca8af0c35e8383048f7e5e379
