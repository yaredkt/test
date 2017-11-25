package Entity;

import java.util.List;

public interface Account {
 /*samdfffdfg
 fgfg 
 fgfg*/
	/**
	 * @param amount
	 */
	void deposit(Double amount);

	/**
	 * @param amount
	 */
	void withdraw(Double amount);

	/**
	 * @return
	 */
	String getAccountNumber();

	/**
	 * @param accountNumber
	 */
	void setAccountNumber(String accountNumber);

	/**
	 * @return
	 */
	Customer getCustomer();

	/**
	 * @param customer
	 */
	void setCustomer(Customer customer);

	/**
	 * @return
	 */
	Double getBalance();

	/**
	 * @param balance
	 */
	void setBalance(Double balance);

	/**
	 * @return
	 */
	List<AccountEntry> getAccountEntries();

	/**
	 * @param accountEntries
	 */
	void setAccountEntries(List<AccountEntry> accountEntries);

}
