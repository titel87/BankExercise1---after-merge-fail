import java.util.ArrayList;
import java.util.List;


public class Banker extends ServiceGiver {
	
	public Banker(){
		custQ = new ArrayList<Customer>();
	}
	
	@Override
	protected void addCustomerToQueue(Customer c) {
		custQ.add(c);
		
		//log
	}

	@Override
	protected void handleCustomer(Customer c) {
		
	}

	@Override
	public void run() {
		synchronized(mutex){
			for(Customer c : custQ){
				c.notify();
			}
		}
	}

}
