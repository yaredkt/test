package Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class AccountImp  implements Account{
	
	private String accountNumber;
	private Customer customer;
	private Double balance ;
	private List<AccountEntry> accountEntries = new ArrayList<>();

	public AccountImp() {
		balance = 0.0;
			}

	 
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public Double getBalance() {
		return balance;
	}
	public Double getBalance(String account) {
		return balance;
	}

	@Override
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public List<AccountEntry> getAccountEntries() {
		return accountEntries;
	}

	@Override
	public void setAccountEntries(List<AccountEntry> accountEntries) {
		this.accountEntries = accountEntries;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer=" + customer + ", balance=" + balance + "]";
	}

}
