package code;

public class DepositMoneyHandler {

	private Accounts accounts;
	private Display display;	
	
	public DepositMoneyHandler(Accounts accounts, Display display) {
		this.accounts = accounts;
		this.display = display;
	}	
	
	private boolean deposit(Integer accountNumber, Integer sum) {
		if(!accounts.doesAccountExist(accountNumber)){
			display.displayString("Account number: " + accountNumber + "  does not exist");
			return false;
		}
		accounts.deposit(accountNumber, sum);
		return true;
	}
	
	public boolean handleRequest(MyRequest myRequest) {
		if(myRequest.getRequestType().equals("DepositMoney")){
			return deposit(myRequest.getAccountNumber(),myRequest.getSum());
		}
		return false;
	}
}
