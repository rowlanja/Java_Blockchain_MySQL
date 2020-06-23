import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
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

	public void write() {

		Logger logger = Logger.getLogger("MyLog");  
		try {  
			logger.info("initiating transactions creation");  
			// This block configure the logger with handler and formatter 
			FileWriter writer = new FileWriter("//home//jr//Programs//gh//ProgrammingPractise//Java//EclipseWS//MySQL_BlockChain//transaction.log", true);
			FileWriter writer2 = new FileWriter("//home//jr//Programs//gh//ProgrammingPractise//Java//EclipseWS//MySQL_BlockChain//transactions.txt", true);
			writer2.write("");
			writer.write("Hello World");  
			Random rand = new Random(); //instance of random class
			int upperbound = 200;
			int count = 0;
			while(count < 200) {
				Random random = new Random();
				int minDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
				int maxDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
				long randomDay = minDay + random.nextInt(maxDay - minDay);

				LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
				int int_random = rand.nextInt(upperbound); 
				int int_random2 = rand.nextInt(upperbound); 
				if(int_random != int_random2) { 
					writer2.write(int_random + " " + int_random2 + " " + randomBirthDate.toString() + " " + count + "\n");
				}
				count++;
			}
			writer.close();
			writer2.close();
		} catch (SecurityException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		logger.info("200 sample transactions created");  
		logger.info("completed writing transactions");  
	}

	public static void main(String[] args) {
		writingTransactions writer = new writingTransactions();
		writer.clear("//home//jr//Programs//gh//ProgrammingPractise//Java//EclipseWS//MySQL_BlockChain//transactions.txt");
		writer.write();
	}
}
