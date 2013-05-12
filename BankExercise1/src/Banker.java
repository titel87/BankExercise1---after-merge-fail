import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


public class Banker extends ServiceGiver {

	static int bankerNumber= 0; //for account indexing in the bank
	
	private String name;
	
	public Banker(String name, BankLogger theLogger) throws SecurityException, IOException{
		custQ = new ArrayList<Customer>();
		mutex = new Object();
		this.name = name;
		this.id = ++bankerNumber;
		myBankLogger = theLogger;
		serviceGiverHanlder = new FileHandler("ID_" + this.id + "_Name_" + this.name + ".xml", true);
		serviceGiverHanlder.setFormatter(new SimpleFormatter());
	}
	
	@Override
	protected void addCustomerToQueue(Customer c) {
		custQ.add(c);
		System.out.println(c+" is added to Line for Banker");
	}

	@Override
	protected void handleCustomer(Customer c) {
		//EXECUTE
		boolean result = c.getCustomerAction().execute(c.getCurrentAccount());
		if(result == false){
			c.theBankLogger.getTheLogger().log(Level.INFO, "---Failed executing action on account #" + c.getCurrentAccount().getId());
			myBankLogger.getTheLogger().log(Level.INFO, "---Failed executing action on account #" + c.getCurrentAccount().getId());
		}
		else{
			c.theBankLogger.getTheLogger().log(Level.INFO, "---Finished executing action on acount #" + c.getCurrentAccount().getId());
			myBankLogger.getTheLogger().log(Level.INFO, "Finished " + c.getCustomerAction());
		}
	}


	@Override
	public void run() {
	synchronized(mutex){
			if(!custQ.isEmpty()){
				for(Customer c : custQ){
						synchronized(c){
							System.out.println("Banker is Notifying Customer");
							c.notify();
							this.handleCustomer(c);
						}
				}	
			}
		}
	}

}
