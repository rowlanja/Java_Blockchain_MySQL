import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class miner {

	public final String classname = "com.mysql.cj.jdbc.Driver"; 
	public final String connection = "jdbc:mysql://localhost:3306/transactions	";
	public final String type = "miner";
	public final String userPassword = "passwordMINER365";
	public int userId;
	public Connection con;

	public miner(int userId, Connection con) {
		this.userId = userId;
		this.con = con;
	}

	//the current proof of work uses transaction ID's and the last target to simulate mining a block
	public void mine(int target, ArrayList<String> transactions) {
		boolean finished = false;
		while(!finished) {
			Collections.sort(transactions);
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<String> getTransactions() {
		ArrayList<String> transactions = new ArrayList<String>();
		try {
			Statement statement;
			statement = this.con.createStatement();
			ResultSet rs=statement.executeQuery("select * from transactions");  
			while(rs.next()) transactions.add(rs.getString(0));  
			con.close();  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		return transactions;
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
	}
}

