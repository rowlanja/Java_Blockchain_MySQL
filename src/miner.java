import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.time.*
;public class miner extends Thread	{

	public final String classname = "com.mysql.cj.jdbc.Driver"; 
	public final String connection = "jdbc:mysql://localhost:3306/transactions	";
	public final String type = "miner";
	public final String userPassword = "passwordMINER365";
	public int userId;
	public Connection con;
	public int count;
	public int winCount;

	public miner(int userId, Connection con, int missCount, int winCount) {
		this.userId = userId;
		this.con = con;
		this.count = missCount;
		this.winCount = winCount;
	}

	//the current proof of work uses transaction ID's and the last target to simulate mining a block
	/*
	 * structure of the sql transactions table is 
	 * to (unique INT) from (unique INT) date (date) transaction id(unique int identify)
	 */
	public void mine(int target, ResultSet Query) {
		try {
			int min, max;
			min = max  = 0;
			boolean finished = false;
			while(Query.next())count += Query.getInt(4);
			while(!finished) {
				if(this.winCount == 30) this.relax();

				LocalDate myObj = LocalDate.now(); // Create a date object
				max = 100  - this.count;
				int guess = Math.random(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void relax() {
		try {
			this.sleep(10000);
			this.winCount = this.count = 0;
			return;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	public ResultSet getTransactions() {
		ResultSet rs = null;
		try {
			Statement statement;
			statement = this.con.createStatement();
			rs=statement.executeQuery("select * from transactions");  
			con.close();  
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return rs;
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

