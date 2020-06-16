import java.util.ArrayList;

public class Octopus {
	ArrayList<miner> miners = new ArrayList<>();

	public void initiateMiner() {
		for(int i = 0; i < 10; i++) {
			miner x = new miner(i, null, 0, 0);
			miners.add(x);
		}
	}
	
	public void runIt() {
		for(miner miner : this.miners) miner.run();
	}
	
	public static void main(String[] args) {
		Octopus manager = new Octopus();
		manager.initiateMiner();
		manager.runIt();
	}
}
