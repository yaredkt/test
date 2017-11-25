package Entity;

import java.time.LocalDate;

public interface AccountEntry {
	
	/**
	 * gets the entry date
	 * 
	 * @return the entry date
	 */
	LocalDate getDate();

	/**
	 * sets the entry date
	 * 
	 * @param date
	 *            the entry date
	 */
	void setDate(LocalDate date);

	/**
	 * gets the the amount entered by the customer
	 * 
	 * @return the amount entered by the customer
	 */
	Double getAmount();

	/**
	 * sets the amount entered by the customer
	 * 
	 * @param amount
	 *            the amount entered by the customer
	 */
	void setAmount(Double amount);

	/**
	 * @return
	 */
	String getFromAccountNumber();

	/**
	 * @param fromAccountNumber
	 */
	void setFromAccountNumber(String fromAccountNumber);

	/**
	 * @return
	 */
	String getFromPersonName();

	/**
	 * @param fromPersonName
	 */
	void setFromPersonName(String fromPersonName);

}

