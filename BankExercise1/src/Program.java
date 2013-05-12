
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.logging.FileHandler;


public class Program {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, IOException {
		//read from xml file example
		/*try{
			XMLReader xmlR = new XMLReader();
			NodeList res = xmlR.readNodeFromFile("atm");
			for(int i=0; i<res.getLength(); i++){
				Node nNode = res.item(i);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
					System.out.println("Staff id : " + eElement.getAttribute("id"));
				}
			}
		
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}*/
		
		
		
		BankLogger myBankLogger = new BankLogger();
		
		
		Banker theBanker= new Banker("Banker1", myBankLogger); //LATER---> will be a list
		ATM theATM= new ATM(); //LATER---> will be a list
		
		ArrayList<Action> ActionsListForExecution= new ArrayList<Action>();
		Account myAccount = new Account(Account.AccountType.Student);
		ArrayList<Account> myAccountsList = new ArrayList<Account>();
		myAccountsList.add(myAccount);
		
		double amount;
		String answer;
		boolean isBanker;

		Customer c1 = new Customer("Shani", myAccountsList, myBankLogger);
		Scanner theScanner = new Scanner(System.in);
		
		//Print Customers - to choose
		//chooseCustomer();
		
		//Print Accounts - to choose
		//chooseAccountForAction(c1);
		
		//Print Actions - to choose
		System.out.println("Please choose an action:");
		System.out.println("1. Withdraw \n2. Deposit \n3. Give Authorization \n4. Print Info Page");
		
		int action= theScanner.nextInt();
		switch(action){
		case 1: //possibility - unite the cases 1+2
			System.out.println("Please Insert Amount to WITHDRAW:");
			amount= theScanner.nextDouble();
			theScanner.nextLine(); //empty nextLine
			isBanker = chooseServiceGiver();
			chooseAccountForAction(c1); //FUTURE --> for each customer
			WithdrawOrDeposit withdraw = new WithdrawOrDeposit(-amount, isBanker);
			//add customer to service giver queue
			if(isBanker)
				theBanker.addCustomerToQueue(c1);
			else
				theATM.addCustomerToQueue(c1);
			ActionsListForExecution.add(withdraw);//add action to action list to execute
			c1.applyAction(withdraw);//apply to customer
			break;
		case 2:
			System.out.println("Please Insert Amount to DEPOSIT:");
			amount= theScanner.nextDouble();
			theScanner.nextLine(); //empty nextLine
			isBanker = chooseServiceGiver();
			chooseAccountForAction(c1); //FUTURE --> for each customer
			WithdrawOrDeposit deposit = new WithdrawOrDeposit(amount, chooseServiceGiver());
			if(isBanker)
				theBanker.addCustomerToQueue(c1);
			else
				theATM.addCustomerToQueue(c1);
			ActionsListForExecution.add(deposit);//add action to action list to execute
			c1.applyAction(deposit);//apply to customer
			break;
		case 3:
			System.out.println("Please Insert the Authorizee's Name");
			answer= theScanner.nextLine();
			isBanker = chooseServiceGiver();
			chooseAccountForAction(c1); //FUTURE --> for each customer
			GiveAutorization author = new GiveAutorization(answer, isBanker);
			if(isBanker)
				theBanker.addCustomerToQueue(c1);
			else
				theATM.addCustomerToQueue(c1);
			ActionsListForExecution.add(author);
			break;
		case 4:
			
			break;
		}
		do{
			System.out.println("Would you like to Execute? (Y/N)");
			answer= theScanner.nextLine();
		}while(!answer.equals("Y") && !answer.equals("N"));
		if(answer.equals("Y")){
			Runnable rc = c1, rb = theBanker, ra = theATM;
			//HERE RUN ON ALL ACTIONS IN LIST
			Thread tc = new Thread(rc);
			Thread tb = new Thread(rb);
			Thread ta = new Thread(ra);
			tc.start();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//for customer to begin waiting
			tb.start();
			
			ta.start();
			
			
		}
		
		
		//finally-after loop
		theScanner.close();
		
	}
	
	public static void chooseAccountForAction(Customer cust){
		System.out.println("Please choose an account for action:");
		//read accounts from XML
		Scanner accountScanner = new Scanner(System.in);
		int accountID= accountScanner.nextInt();
		cust.setAccountForAction(accountID); //setting the customer's current account
	}
	
	public static Customer chooseCustomer(){
		Customer chosenCust = new Customer();
		System.out.println("Please choose a customer for action:");
		//read customers from XML
		Scanner custScanner = new Scanner(System.in);
		int chosenID = custScanner.nextInt();
		//match ID to customers in XML and return the customer
		//chosenCust= ...
		return chosenCust;
	}
	
	//return true if chose Banker, else if chose ATM return false
	public static boolean chooseServiceGiver(){
		Scanner serviceScanner = new Scanner(System.in);
		String answer;
		do{
			System.out.println("Would you like tu use a banker or an ATM? (B/A)");
			answer= serviceScanner.nextLine();
		}while(!answer.equals("B") && !answer.equals("A"));
		if(answer.equals("B")) //if banker
			return true;
		else
			return false;
	}
}
