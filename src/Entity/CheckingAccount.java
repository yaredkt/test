package Entity;

public class CheckingAccount extends AccountImp {

	@Override
	public void deposit(Double amount) {
		setBalance(getBalance() + amount);

		//AccountEntryImp newAccountEntry = new AccountEntryImp(amount, getAccountNumber(), getCustomer().getName());
		//getAccountEntries().add(newAccountEntry);

	}

	@Override
	public void withdraw(Double amount) {
		setBalance(getBalance() - amount);

		AccountEntryImp newAccountEntry = new AccountEntryImp(amount, getAccountNumber(), getCustomer().getName());
		getAccountEntries().add(newAccountEntry);

	}

}
