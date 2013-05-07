import java.util.ArrayList;
import java.util.List;


public class Banker extends ServiceGiver {
	
	public Banker(){
		custQ = new ArrayList<Customer>();
		mutex = new Object();
	}
	
	@Override
	protected void addCustomerToQueue(Customer c) {
		custQ.add(c);
		System.out.println(c+" is added to Line for Banker");
		
		//log
	}

	@Override
	protected void handleCustomer(Customer c) {
		
	}

	@Override
	public void run() {
		for(Customer c : custQ){
			synchronized(c){
				c.notify();
			}
		}
	}

}
