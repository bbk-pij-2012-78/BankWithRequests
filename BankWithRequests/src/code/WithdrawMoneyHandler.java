/**
 * 
 */
package code;


/**
 * @author oded
 *
 */
public class WithdrawMoneyHandler {

	private Accounts accounts;
	private Money money;
	private Display display;

	public WithdrawMoneyHandler(Accounts accounts, Money money, Display display) {
		this.accounts = accounts;
		this.money = money;
		this.display = display;
	}

	private boolean withdraw(Integer accountNumber, Integer sum) {
		if(!accounts.doesAccountExist(accountNumber)){
			display.displayString("Account number: " + accountNumber + "  does not exist");
			return false;
		}
		if(sum >= accounts.getBalance(accountNumber)){
			display.displayString("Not enough money in the account current balance " + accounts.getBalance(accountNumber));
			return false;
		}
		accounts.withdraw(accountNumber, sum);
		money.giveMoney(sum);
		return true;
	}

	public boolean handleRequest(MyRequest myRequest) {
		// TODO Auto-generated method stub
		if(myRequest.getRequestType().equals("WithdrawMoney")){
			return withdraw(myRequest.getAccountNumber(),myRequest.getSum());
		}
		return false;
	}

}
