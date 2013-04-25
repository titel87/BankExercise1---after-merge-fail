import java.util.List;


public class Customer {
	
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
}
