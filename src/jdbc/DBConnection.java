package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class DBConnection {

	private Connection con;
	private java.sql.Statement st;
	private ResultSet rs;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://sql9.freesqldatabase.com:3306/sql9200211", "sql9200211",
					"p6a3YhXQnM");
			st = con.createStatement();
		} catch (Exception ex) {
			System.out.println("Error:" + ex);
		}
	}

	public void getData() {
		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from login";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			System.out.println("The results from our Database:");

			while (rs.next()) {
				String username = rs.getString("userName");
				String password = rs.getString("Password");

				System.out.println("username : " + username + " password : " + password);
			}
		} catch (Exception ex) {
			System.out.println(ex);

		}
	}

	// retrieving balance from personalcheking
	public HashMap<String, String> getBalancePersonalChecking() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalChecking";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	// retrieving balance from personalSaving
	public HashMap<String, String> getBalancePersonalSaving() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalSaving";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	// retrieving balance from personalSaving
	public HashMap<String, String> getBalancePersonalCredit() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalCredit";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	// retrieving balance from personalSaving
	public HashMap<String, String> getBalanceBusinessChecking() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessChecking";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getBalanceBusinessSaving() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessSaving";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getBalanceBusinessCredit() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessCredit";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("Balance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	// retriving login data from my database
	public HashMap<String, String> getlogin() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from login";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String username = rs.getString("UserName");
				String password = rs.getString("Password");

				hp.put(username, password);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	// retrieving Admin data from my database

	public HashMap<String, String> getAdmin() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from Admin";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String username = rs.getString("UserName");
				String password = rs.getString("Password");

				hp.put(username, password);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}
	
	public HashMap<String, String> getUser() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from User";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String username = rs.getString("UserName");
				String password = rs.getString("Password");

				hp.put(username, password);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public void setData() {
		String query = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`, `nationality`, `joinedOn`, `team`) "
				+ "VALUES (NULL, 'Alice', 'Bob', '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updatePersonalCheckingBalance(double balance, String account) {

		String query = "update PersonalChecking set Balance = '" + balance + "' where AccountNumber = '" + account
				+ "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updatePersonalSavingBalance(double balance, String account) {

		String query = "update PersonalSaving set Balance = '" + balance + "' where AccountNumber = '" + account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updatePersonalCreditBalance(double balance, String account) {

		String query = "update PersonalCredit set Balance = '" + balance + "' where AccountNumber = '" + account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateBusinessCheckingBalance(double balance, String account) {

		String query = "update BusinessChecking set Balance = '" + balance + "' where AccountNumber = '" + account
				+ "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateBusinessSavingBalance(double balance, String account) {

		String query = "update BusinessSaving set Balance = '" + balance + "' where AccountNumber = '" + account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateBusinessCreditBalance(double balance, String account) {

		String query = "update BusinessCredit set Balance = '" + balance + "' where AccountNumber = '" + account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public List<String> getAccountNumberPersonalChecking() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalChecking";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public List<String> getAccountNumberPersonalSaving() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalSaving";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public List<String> getAccountNumberPersonalCredit() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalCredit";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public List<String> getAccountNumberBusinessChecking() {

		List<String> list = new ArrayList<>();

		try {

			String query = "select * from BusinessChecking";
			rs = st.executeQuery(query);

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public List<String> getAccountNumberBusinessSaving() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessSaving";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	public List<String> getAccountNumberBusinessCredit() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessCredit";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	// settin data to my database
	public void setloginData(String firstName, String LastName, String username, String password) {
		String query = "INSERT INTO `login` (`FirstName`, `LastName`, `UserName`, `Password`) " + "VALUES ('" + firstName
				+ "', '" + LastName + "','" + username + "', '" + password + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// setting personalChecking data to my database

	public void setPersonalChecking(String name, LocalDate birthdate, String accnr, String street, String city,
			String zip, String state, String country, String accType, double balance, String ssn, String email) {
		String query = "INSERT INTO `PersonalChecking` (`Name`, `BirthDate`,`AccountNumber`, `Street`,`City`, `Zip`,`State`, `Country`,`AccountType`, `Balance`,`SSN`, `Email`) "
				+ "VALUES ( '" + name + "', '" + birthdate + "','" + accnr + "','" + street + "', '" + city + "', '"
				+ zip + "', '" + state + "', '" + country + "', '" + accType + "', '" + balance + "', '" + ssn + "', '"
				+ email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// setting personalSaving data to my database

	public void setPersonalSaving(String name, LocalDate birthdate, String accnr, String street, String city,
			String zip, String state, String country, String accType, double balance, String ssn, String email) {
		String query = "INSERT INTO `PersonalSaving` (`Name`, `BirthDate`,`AccountNumber`, `Street`,`City`, `Zip`,`State`, `Country`,`AccountType`, `Balance`,`SSN`, `Email`) "
				+ "VALUES ( '" + name + "', '" + birthdate + "','" + accnr + "','" + street + "', '" + city + "', '"
				+ zip + "', '" + state + "', '" + country + "', '" + accType + "', '" + balance + "', '" + ssn + "', '"
				+ email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// setting personalCredit data to my database
	public void setPersonalCredit(String name, LocalDate birthdate, String accnr, String street, String city,
			String zip, String state, String country, String accType, double balance, String ssn, String email) {
		String query = "INSERT INTO `PersonalCredit` (`Name`, `BirthDate`,`AccountNumber`, `Street`,`City`, `Zip`,`State`, `Country`,`AccountType`, `Balance`,`SSN`, `Email`) "
				+ "VALUES ( '" + name + "', '" + birthdate + "','" + accnr + "','" + street + "', '" + city + "', '"
				+ zip + "', '" + state + "', '" + country + "', '" + accType + "', '" + balance + "', '" + ssn + "', '"
				+ email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Setting businessChecking in my database
	public void setBusinessChecking(String name, String accnr, String street, String city, String zip, String state,
			String country, String accType, double balance, String email) {
		String query = "INSERT INTO `BusinessChecking` (`Name`,`AccountNumber`, `Street`, `City`, `Zip`, `State`, `Country`, `AccountType`, `Balance`, `Email`) "
				+ "VALUES ( '" + name + "', '" + accnr + "', '" + street + "', '" + city + "', '" + zip + "', '" + state
				+ "', '" + country + "', '" + accType + "', '" + balance + "', '" + email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Setting businessSaving in my database
	public void setBusinessSaving(String name, String accnr, String street, String city, String zip, String state,
			String country, String accType, double balance, String email) {
		String query = "INSERT INTO `BusinessSaving` (`Name`,`AccountNumber`, `Street`,`City`, `Zip`,`State`, `Country`,`AccountType`, `Balance`, `Email`) "
				+ "VALUES ( '" + name + "', '" + accnr + "','" + street + "', '" + city + "', '" + zip + "', '" + state
				+ "', '" + country + "', '" + accType + "', '" + balance + "', '" + email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// Setting businessCredit in my database
	public void setBusinessCredit(String name, String accnr, String street, String city, String zip, String state,
			String country, String accType, double balance, String email) {
		String query = "INSERT INTO `BusinessCredit` (`Name`,`AccountNumber`, `Street`,`City`, `Zip`,`State`, `Country`,`AccountType`, `Balance`, `Email`) "
				+ "VALUES ( '" + name + "', '" + accnr + "','" + street + "', '" + city + "', '" + zip + "', '" + state
				+ "', '" + country + "', '" + accType + "', '" + balance + "', '" + email + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void setPersonalLoan(String name, String accnr, double autuLoan, double businessLoan) {
		String query = "INSERT INTO `PersonalLoan` (`Name`, `AccountNumber`, `AutoLoanBalance`,`BusinessLoanBalance`) "
				+ "VALUES ( '" + name + "', '" + accnr + "','" + autuLoan + "', '" + businessLoan + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// setting businessLoan into database
	public void setBusinessLoan(String name, String accnr, double autuLoan, double businessLoan) {
		String query = "INSERT INTO `BusinessLoan` (`Name`, `AccountNumber`, `AutoLoanBalance`,`BusinessLoanBalance`) "
				+ "VALUES ( '" + name + "', '" + accnr + "','" + autuLoan + "', '" + businessLoan + "')";

		try {
			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = con.prepareStatement(query);
			/*
			 * preparedStmt.setString (1, "Barney"); preparedStmt.setString (2, "Rubble");
			 * preparedStmt.setDate (3, startDate); preparedStmt.setBoolean(4, false);
			 * preparedStmt.setInt (5, 5000);
			 */

			// execute the preparedstatement
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// getting AccountNumber from the database
	public List<String> getAccountNumberBusinessLoan() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessLoan";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return list;
	}

	// getting AccountNumber from the database
	public List<String> getAccountNumberPersonalLoan() {

		List<String> list = new ArrayList<>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalLoan";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNumber = rs.getString("AccountNumber");

				list.add(accountNumber);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return list;
	}

	// updating BusinessLoan
	public void updateBusinessAutoLoanBalance(double balance, String account) {

		String query = "update BusinessLoan set AutoLoanBalance = '" + balance + "' where AccountNumber = '" + account
				+ "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateBusinessBusinessLoanBalance(double balance, String account) {

		String query = "update BusinessLoan set BusinessLoanBalance = '" + balance + "' where AccountNumber = '"
				+ account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// updating PersonalLoan
	public void updatePersonalAutoLoanBalance(double balance, String account) {

		String query = "update PersonalLoan set AutoLoanBalance = '" + balance + "' where AccountNumber = '" + account
				+ "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	// updating PersonalLoan
	public void updatePersonalBusinessLoanBalance(double balance, String account) {

		String query = "update PersonalLoan set BusinessLoanBalance = '" + balance + "' where AccountNumber = '"
				+ account + "'";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateData() {

		String query = "update manager set firstName = 'Morinho' where id = 2";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public HashMap<String, String> getBalancePersonalAutoLoan() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalLoan";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("AutoLoanBalance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getBalancePersonalBusinessLoan() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from PersonalLoan";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("BusinessLoanBalance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getBalanceBusinessBusinessLoan() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			String query = "select * from BusinessLoan";
			rs = st.executeQuery(query);

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("BusinessLoanBalance");

				hp.put(accountNum, balance);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getBalanceBusinessAutoLoan() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			// String query2 = "INSERT INTO `manager` (`id`, `firstName`, `lastName`, `dob`,
			// `nationality`, `joinedOn`, `team`) VALUES (NULL, 'Alice', 'Bob',
			// '2015-10-01', 'American', '2007-07-07', 'Arsenal')";
			String query = "select * from BusinessLoan";
			rs = st.executeQuery(query);
			// rs = st.executeQuery(query1);

			// System.out.println("The results from our Database:");

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String balance = rs.getString("AutoLoanBalance");

				hp.put(accountNum, balance);
				// System.out.println("username Name: " + username + " password Name: " +
				// password);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getStreetPersonalChecking() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			String query = "select * from PersonalChecking";
			rs = st.executeQuery(query);

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String street = rs.getString("Street");

				hp.put(accountNum, street);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}

	public HashMap<String, String> getCityPersonalChecking() {

		HashMap<String, String> hp = new HashMap<String, String>();

		try {

			String query = "select * from PersonalChecking";
			rs = st.executeQuery(query);

			while (rs.next()) {
				String accountNum = rs.getString("AccountNumber");
				String city = rs.getString("City");

				hp.put(accountNum, city);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return hp;
	}


		public HashMap<String, String> getStatePersonalChecking() {

			HashMap<String, String> hp = new HashMap<String, String>();

			try {

				String query = "select * from PersonalChecking";
				rs = st.executeQuery(query);

				while (rs.next()) {
					String accountNum = rs.getString("AccountNumber");
					String state = rs.getString("State");

					hp.put(accountNum, state);

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

			return hp;
		}
		

		public HashMap<String, String> getCountryPersonalChecking() {

			HashMap<String, String> hp = new HashMap<String, String>();

			try {

				String query = "select * from PersonalChecking";
				rs = st.executeQuery(query);

				while (rs.next()) {
					String accountNum = rs.getString("AccountNumber");
					String country = rs.getString("Country");

					hp.put(accountNum, country);

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

			return hp;
		}


		public HashMap<String, String> getZipPersonalChecking() {

			HashMap<String, String> hp = new HashMap<String, String>();

			try {

				String query = "select * from PersonalChecking";
				rs = st.executeQuery(query);

				while (rs.next()) {
					String accountNum = rs.getString("AccountNumber");
					String zip = rs.getString("Zip");

					hp.put(accountNum, zip);

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

			return hp;
		}

	public void deleteData() {
		String query = "delete from manager where id = 2";
		try {
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.execute();

			// con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
