import java.util.List;


public class Customer implements Runnable{
	
	private static int idGenerator=0;
	private int id;
	private String name;
	private List<Account> accounts;
	private Logger customerLogger;
	private CustomerAction customerAction;

	public Customer(String name, List<Account> accounts) {
		super();
		id = ++idGenerator;
		this.name = name;
		this.accounts = accounts;
	}

	@Override
	public void run() {
		System.out.println(this + " is now running");
		
		try {
			synchronized(this){
				System.out.println(this + " is waiting");
				this.wait();
				System.out.println(this + " has finish waiting");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean result = customerAction.execute();
			//write details to log 
		System.out.println(this + " has finished running");
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
}
