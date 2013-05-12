import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;


public class Customer implements Runnable{
	
	private static int idGenerator=0;
	private int id;
	private String name;
	private List<Account> accounts;
	public BankLogger theBankLogger;
	private FileHandler customerHanlder;
	private Action customerAction;
	private Account currentAccount;
	private Object mutex= new Object();
	
	public Customer(){
		super();
	}
	
	public Customer(String name, List<Account> accounts, BankLogger theLogger) throws SecurityException, IOException {
		super();
		id = ++idGenerator;
		this.name = name;
		this.accounts = accounts;
		theBankLogger = theLogger;
		customerHanlder = new FileHandler("ID_" + this.id + "_Name_" + this.name + ".xml", true);
		customerHanlder.setFormatter(new SimpleFormatter());
		
		theBankLogger.getTheLogger().addHandler(customerHanlder);
	}
	
	public void addAccount(Account theAccount){
		accounts.add(theAccount);
	}
	
	public void setAccountForAction(int accountID){
		if(!this.accounts.isEmpty()){
			for(Account tempAccount: this.accounts){
				if(tempAccount.getId() == accountID){
					this.currentAccount = tempAccount;
					return;
				}
			}
		}
	}
	
	public void applyAction(Action theAction){
		this.customerAction = theAction;
	}
	
	@Override
	public void run() {
		System.out.println(this + " is now running");
		theBankLogger.getTheLogger().log(Level.INFO, "You are now running");
		
		try {
			synchronized(this){
				System.out.println(this + " is waiting");
				theBankLogger.getTheLogger().log(Level.INFO, "You are waiting");
				this.wait();
				System.out.println(this + " has finished waiting");
				theBankLogger.getTheLogger().log(Level.INFO, "You have finished waiting");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		theBankLogger.getTheLogger().log(Level.INFO, "You have finished running");
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Action getCustomerAction() {
		return customerAction;
	}

	public void setCustomerAction(Action customerAction) {
		this.customerAction = customerAction;
	}

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}
	
	
	
}
