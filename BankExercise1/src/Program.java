
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
		int i=0; //for future loop
		
		Banker theBanker= new Banker(); //LATER---> will be a list
		ATM theATM= new ATM(); //LATER---> will be a list
		
		ArrayList<Action> ActionsListForExecution= new ArrayList<Action>();
		Account myAccount = new Account(Account.AccountType.Student);
		ArrayList<Account> myAccountsList = new ArrayList<Account>();
		myAccountsList.add(myAccount);
		
		double amount;
		String answer;
		boolean isBanker;

		Customer c1 = new Customer("Tamar", myAccountsList);
		Scanner theScanner = new Scanner(System.in);
		//Print Customers - to choose
		System.out.println("Customers in system:\n"+ (i+1) +". " + c1);
		//int chosen_customer= theScanner.nextInt();
		
		//Print Accounts - to choose
		//int chosen_account= theScanner.nextInt();
		
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
			WithdrawOrDeposit withdraw = new WithdrawOrDeposit(-amount, isBanker);
			//add customer to service giver queue
			if(isBanker)
				theBanker.addCustomerToQueue(c1);
			else
				theATM.addCustomerToQueue(c1);
			ActionsListForExecution.add(withdraw);
			break;
		case 2:
			System.out.println("Please Insert Amount to DEPOSIT:");
			amount= theScanner.nextDouble();
			theScanner.nextLine(); //empty nextLine
			isBanker = chooseServiceGiver();
			WithdrawOrDeposit deposit = new WithdrawOrDeposit(amount, chooseServiceGiver());
			if(isBanker)
				theBanker.addCustomerToQueue(c1);
			else
				theATM.addCustomerToQueue(c1);
			ActionsListForExecution.add(deposit);
			break;
		case 3:
			System.out.println("Please Insert the Authorizee's Name");
			answer= theScanner.nextLine();
			isBanker = chooseServiceGiver();
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
		System.out.println("Would you like to Execute? (Y/N)");
		answer= theScanner.nextLine();
		if(answer.equals("Y")){
			Runnable rc = c1, rb = theBanker, ra = theATM;
			Thread tc = new Thread(rc);
			Thread tb = new Thread(rb);
			Thread ta = new Thread(ra);
			tc.start();
			tb.start();
			ta.start();
			
		}
		
		
		//finally-after loop
		theScanner.close();
		
	}
	
	//return true if chose Banker, else if chose ATM return false
	public static boolean chooseServiceGiver(){
		Scanner serviceScanner = new Scanner(System.in);
		System.out.println("Would you like tu use a banker or an ATM? (B/A)");
		String answer= serviceScanner.nextLine();
		if(answer.equals("B")) //if banker
			return true;
		else
			return false;
	}
}
