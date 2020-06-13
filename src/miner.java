import java.sql.*;

public class miner {
	
	public final String classname = "com.mysql.cj.jdbc.Driver"; 
	public final String connection = "jdbc:mysql://localhost:3306/chatRoom";
	public final String type = "user";
	public final String userPassword = "passwordUSER365";
	public int userId;
	public Connection con;

	public worker(int userId, Connection con) {
		this.userId = userId;
		this.con = con;
	}

	public void sendMessage() {
		Statement statement;
		try {
			statement = this.con.createStatement();
			statement.executeUpdate("INSERT INTO messages " + "VALUES (, 'Simpson', 'Mr.', 'Springfield', 2001)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//this method connects to the user account on the database;
	//here chatRoom is database name, root is username and password  

	public void connectDB() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(
					this.connection,
					this.type,
					this.userPassword
			);  
			this.con = con;
		}catch(Exception e){ 
			System.out.println(e);
		}  
	}

	public static void main(String[] args) {
		user x = new user("jim", 1,null);
		x.connectDB();
	}
}
}
