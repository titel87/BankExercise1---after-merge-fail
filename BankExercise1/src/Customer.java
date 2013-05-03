import java.util.List;


public class Customer extends Thread{
	
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
		System.out.println(this + "is now running");
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
}
