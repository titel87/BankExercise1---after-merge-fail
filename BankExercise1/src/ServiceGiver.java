import java.util.List;

public abstract class ServiceGiver {
	protected List<Customer> custQ;
	protected Customer currCustomer;
	
	protected void addCustomerToQueue(Customer c){
		custQ.add(c);
		//consider run the customer thread now as we did in the airplanes example
		//c.start();
	}
	
	protected void handleCustomer(){
		if(custQ.size() != 0){
			
		}
	}
}
