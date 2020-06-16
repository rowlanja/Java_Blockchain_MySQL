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
	public Connection con;
	public int count, winCount, minerId, gold;
	public final int TARGET = 1;

	//revise coming up with target this is just a placeholder right now to help come up with the mining function

	public miner(int minerId, Connection con, int missCount, int winCount) {
		this.minerId = minerId;
		this.con = con;
		this.count = missCount;
		this.winCount = winCount;
		this.gold = 0;
	}

	//the current proof of work uses transaction ID's and the last target to simulate mining a block
	/*
	 * structure of the sql transactions table is 
	 * to (unique INT) from (unique INT) date (date) transaction id(unique int identify)
	 */
	public void mine(int target, ResultSet Query) {
		try {
			Random rand = new Random(); //instance of random classS
			boolean finished = false;
			while(Query.next())count += Query.getInt(4);
			while(!finished) {
				if(this.winCount == 30) this.relax();
				int int_random = rand.nextInt(100); 
				int sum = Query.getInt(1);
				if(int_random + sum == TARGET) this.win(Query, sum,this.minerId);//FINISH;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * when a block is successfully mined we have to cancel mining of the transactions from other miners;
	 * remove all the transactions that were mined succesfully
	 * add the block to the block table
	 */

	public void win(ResultSet Qeury, int sum, int minerID) {
		try {
			Statement stmt = con.createStatement();
			while(Qeury.next()) {
				String Trans_ID = Qeury.getString(4);
				stmt.execute("DELETE FROM messages WHERE transaction_id = " + Trans_ID);
			}
			stmt.execute("INSERT INTO blockchain VALUES " + sum + " " + minerID);
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.gold += 1;
		}
	}

	public void relax() {
		try {
			Thread.sleep(10000);
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

