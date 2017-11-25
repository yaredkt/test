package UI;

import java.util.HashMap;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jdbc.DBConnection;

public class History extends Stage {
	Stage primaryStage;

	public History(Stage stage) {

		primaryStage = stage;
		GridPane grid = new GridPane();
		primaryStage.setTitle("History");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 100));

		Text title = new Text("Enter Information");
		title.setFill(Color.WHITE);
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		grid.add(title, 1, 1, 2, 1);

		Label name = new Label("Name");
		name.setTextFill(Color.WHITE);
		name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(name, 1, 3);

		TextField nameTextField = new TextField();
		grid.add(nameTextField, 2, 3);

		Label accountNumber = new Label("Account Number");
		accountNumber.setTextFill(Color.WHITE);
		accountNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(accountNumber, 1, 4);

		TextField accountNumberTextField = new TextField();
		grid.add(accountNumberTextField, 2, 4);

		Label street = new Label("Street");
		street.setTextFill(Color.WHITE);
		street.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(street, 1, 8);

		TextField streetTextField = new TextField();
		grid.add(streetTextField, 2, 8);

		Label city = new Label("City");
		city.setTextFill(Color.WHITE);
		city.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(city, 1, 9);

		TextField cityTextField = new TextField();
		grid.add(cityTextField, 2, 9);

		Label zip = new Label("Zip Code");
		zip.setTextFill(Color.WHITE);
		zip.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(zip, 1, 10);

		TextField zipTextField = new TextField();
		grid.add(zipTextField, 2, 10);

		Label country = new Label("Country");
		country.setTextFill(Color.WHITE);
		country.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(country, 1, 11);

		TextField countryTextField = new TextField();
		grid.add(countryTextField, 2, 11);

		Label state = new Label("State");
		state.setTextFill(Color.WHITE);
		state.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(state, 1, 12);

		TextField stateTextField = new TextField();
		grid.add(stateTextField, 2, 12);

		Label checkingBalance = new Label("Checking Balance");
		checkingBalance.setTextFill(Color.WHITE);
		checkingBalance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(checkingBalance, 1, 13);

		TextField checkingBalanceTextField = new TextField();
		grid.add(checkingBalanceTextField, 2, 13);

		Label savingBalance = new Label("Saving Balance");
		savingBalance.setTextFill(Color.WHITE);
		savingBalance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(savingBalance, 1, 14);

		TextField savingBalanceTextField = new TextField();
		grid.add(savingBalanceTextField, 2, 14);

		Label creditBalance = new Label("Credit Balance");
		creditBalance.setTextFill(Color.WHITE);
		creditBalance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(creditBalance, 1, 15);

		TextField creditBalanceTextField = new TextField();
		grid.add(creditBalanceTextField, 2, 15);

		Label autoLoanBalance = new Label("AutoLoan Balance");
		autoLoanBalance.setTextFill(Color.WHITE);
		autoLoanBalance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(autoLoanBalance, 1, 16);

		TextField autoLoanBalanceTextField = new TextField();
		grid.add(autoLoanBalanceTextField, 2, 16);

		Label businessBalance = new Label("BusinessLoan Balance");
		businessBalance.setTextFill(Color.WHITE);
		businessBalance.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(businessBalance, 1, 17);

		TextField businessBalanceTextField = new TextField();
		grid.add(businessBalanceTextField, 2, 17);

		Button showButton = new Button("Show");
		showButton.setTextFill(Color.BLACK);
		showButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		showButton.setMaxSize(200, 30);
		showButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(showButton, 2, 6);

		Button exitButton = new Button("Exit");
		exitButton.setTextFill(Color.BLACK);
		exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		exitButton.setMaxSize(200, 30);
		exitButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(exitButton, 2, 18);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		showButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();

				List<String> accountNumBusiness = db.getAccountNumberBusinessChecking();
				List<String> accountNumPersonal = db.getAccountNumberPersonalChecking();

				HashMap<String, String> street = db.getStreetPersonalChecking();
				HashMap<String, String> city = db.getCityPersonalChecking();
				HashMap<String, String> state = db.getStatePersonalChecking();
				HashMap<String, String> country = db.getCountryPersonalChecking();
				HashMap<String, String> zip = db.getZipPersonalChecking();
				HashMap<String, String> balanceChecking = db.getBalancePersonalChecking();
				HashMap<String, String> balanceSaving = db.getBalancePersonalSaving();
				HashMap<String, String> balanceCredit = db.getBalancePersonalCredit();
				HashMap<String, String> balanceatuoloan = db.getBalancePersonalAutoLoan();
				HashMap<String, String> balanceBusinessloan = db.getBalancePersonalBusinessLoan();

				boolean foundPersonal = false;
				boolean foundBusiness = false;

				for (String account : accountNumPersonal) {
					if (account.equals(accountNumberTextField.getText())) {
						foundPersonal = true;
					}
				}

				if (foundPersonal) {

					String name = nameTextField.getText();
					
					if (street.containsKey(accountNumberTextField.getText())) {

						streetTextField.setText(street.get(accountNumberTextField.getText()));

					}
					if (city.containsKey(accountNumberTextField.getText())) {

						cityTextField.setText(city.get(accountNumberTextField.getText()));

					}
					
					if (state.containsKey(accountNumberTextField.getText())) {

						stateTextField.setText(state.get(accountNumberTextField.getText()));

					}
					if (country.containsKey(accountNumberTextField.getText())) {

						countryTextField.setText(country.get(accountNumberTextField.getText()));

					}
					
					if (zip.containsKey(accountNumberTextField.getText())) {

						zipTextField.setText(zip.get(accountNumberTextField.getText()));

					}

					if (balanceChecking.containsKey(accountNumberTextField.getText())) {

						checkingBalanceTextField.setText(balanceChecking.get(accountNumberTextField.getText()));

					}

					if (balanceSaving.containsKey(accountNumberTextField.getText())) {

						savingBalanceTextField.setText(balanceSaving.get(accountNumberTextField.getText()));

					}
					if (balanceCredit.containsKey(accountNumberTextField.getText())) {

						creditBalanceTextField.setText(balanceCredit.get(accountNumberTextField.getText()));

					}
					if (balanceatuoloan.containsKey(accountNumberTextField.getText())) {

						autoLoanBalanceTextField.setText(balanceatuoloan.get(accountNumberTextField.getText()));

					}
					if (balanceBusinessloan.containsKey(accountNumberTextField.getText())) {

						businessBalanceTextField.setText(balanceBusinessloan.get(accountNumberTextField.getText()));

					}

				}

				for (String account : accountNumBusiness) {
					if (account.equals(accountNumberTextField.getText())) {
						foundBusiness = true;
					}
				}

			}
		});

		Scene scene1 = new Scene(grid, 600, 700);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
}
