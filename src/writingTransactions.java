import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

/*
 * this file write all the transactions
 */
public class writingTransactions {
	public void clear(String name) {
		File f = new File(name);
		if(f.exists()){
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void write(String name) {
		Logger logger = Logger.getLogger("MyLog");  
		FileHandler fh;  
		try {  
			// This block configure the logger with handler and formatter  
			fh = new FileHandler("//home//jr//Programs//gh//ProgrammingPractise//Java//MySQL_BlockChain//transactions.log");  
			logger.addHandler(fh);
			Random rand = new Random(); //instance of random class
			int upperbound = 200;
			int count = 0;
			while(count < 200) {
				int int_random = rand.nextInt(upperbound); 
				int int_random2 = rand.nextInt(upperbound); 
				if(int_random != int_random2) { 

				}
				else {

				}
				count++;
			}
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  

		logger.info("Hi How r u?");  
	}

	public static void main(String[] args) {
		writingTransactions writer = new writingTransactions();
		writer.clear("//home//jr//Programs//gh//ProgrammingPractise//Java//MySQL_BlockChain//transactions.log");
		writer.write("//home//jr//Programs//gh//ProgrammingPractise//Java//MySQL_BlockChain//transactions.log");

	}
}
