import java.util.List;
import java.util.logging.FileHandler;

public abstract class ServiceGiver implements Runnable {
	
	protected List<Customer> custQ;
	protected Customer currCustomer;
	protected static Object mutex;
	protected BankLogger myBankLogger;
	protected FileHandler serviceGiverHanlder;
	protected int id;
	
	protected abstract void addCustomerToQueue(Customer c);
	
	protected abstract void handleCustomer(Customer c);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
