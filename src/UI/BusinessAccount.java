package UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import Factory.AccountFactory;
import Factory.AccountType;
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

public class BusinessAccount extends Stage {

	Stage primaryStage;

	public BusinessAccount(Stage stage) {

		GridPane grid = new GridPane();
		primaryStage = stage;
		primaryStage.setTitle("Business Account");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(100, 100, 100, 150));

		Label name = new Label("Name");
		name.setTextFill(Color.WHITE);
		name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(name, 1, 1);

		TextField nameText = new TextField();
		grid.add(nameText, 2, 1);

		final Text nameActiontarget = new Text();
		nameActiontarget.setFill(Color.FIREBRICK);
		grid.add(nameActiontarget, 3, 1);

		Label accNr = new Label("Account Number");
		accNr.setTextFill(Color.WHITE);
		accNr.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(accNr, 1, 2);

		TextField accNrText = new TextField();
		grid.add(accNrText, 2, 2);

		final Text accountNumberActiontarget = new Text();
		accountNumberActiontarget.setFill(Color.FIREBRICK);
		grid.add(accountNumberActiontarget, 3, 2);

		Label street = new Label("Street");
		street.setTextFill(Color.WHITE);
		street.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(street, 1, 3);

		TextField streetText = new TextField();
		grid.add(streetText, 2, 3);

		final Text streetNumberActiontarget = new Text();
		streetNumberActiontarget.setFill(Color.FIREBRICK);
		grid.add(streetNumberActiontarget, 3, 3);

		Label city = new Label("City");
		city.setTextFill(Color.WHITE);
		city.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(city, 1, 4);

		TextField cityText = new TextField();
		grid.add(cityText, 2, 4);

		final Text cityActiontarget = new Text();
		cityActiontarget.setFill(Color.FIREBRICK);
		grid.add(cityActiontarget, 3, 4);

		Label zip = new Label("Zip");
		zip.setTextFill(Color.WHITE);
		zip.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(zip, 1, 5);

		TextField zipText = new TextField();
		grid.add(zipText, 2, 5);

		final Text zipActiontarget = new Text();
		zipActiontarget.setFill(Color.FIREBRICK);
		grid.add(zipActiontarget, 3, 5);

		Label state = new Label("State");
		state.setTextFill(Color.WHITE);
		state.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(state, 1, 6);

		TextField stateText = new TextField();
		grid.add(stateText, 2, 6);

		final Text stateActiontarget = new Text();
		stateActiontarget.setFill(Color.FIREBRICK);
		grid.add(stateActiontarget, 3, 6);

		Label country = new Label("Country");
		country.setTextFill(Color.WHITE);
		country.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(country, 1, 7);

		TextField countryText = new TextField();
		grid.add(countryText, 2, 7);

		final Text countryActiontarget = new Text();
		countryActiontarget.setFill(Color.FIREBRICK);
		grid.add(countryActiontarget, 3, 7);

		Label accountType = new Label("Account Type");
		accountType.setTextFill(Color.WHITE);
		accountType.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(accountType, 1, 8);

		TextField accountTypeText = new TextField();
		grid.add(accountTypeText, 2, 8);

		final Text accountTypeActiontarget = new Text();
		accountTypeActiontarget.setFill(Color.FIREBRICK);
		grid.add(accountTypeActiontarget, 3, 8);

		Label email = new Label("Email");
		email.setTextFill(Color.WHITE);
		email.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(email, 1, 9);

		TextField emailText = new TextField();
		grid.add(emailText, 2, 9);

		Button depositButton = new Button("Deposit");
		depositButton.setTextFill(Color.WHITE);
		depositButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(depositButton, 2, 12);

		Button create = new Button("Create");
		create.setTextFill(Color.BLACK);
		create.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		create.setAlignment(Pos.BOTTOM_CENTER);
		create.setMaxSize(200, 30);
		grid.add(create, 2, 12);
		grid.setGridLinesVisible(false);

		Button exitButton = new Button("Exit");
		exitButton.setTextFill(Color.BLACK);
		exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		exitButton.setMaxSize(200, 30);
		exitButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(exitButton, 1, 12);
		
		final Text createActiontarget = new Text();
		createActiontarget.setFill(Color.FIREBRICK);
		grid.add(createActiontarget, 2, 13);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		create.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

//				if (nameText.getText().length() == 0) {
//					nameActiontarget.setFill(Color.FIREBRICK);
//					nameActiontarget.setText("Invalid Name");
//					return;
//				}

				if (!accNrText.getText().matches("[0-9]{9}")) {
					accountNumberActiontarget.setFill(Color.FIREBRICK);
					accountNumberActiontarget.setText("Invalid Account Number");
					return;
				}

				if (streetText.getText().length() == 0) {
					streetNumberActiontarget.setText("Invalid Street");
					return;
				}

				if (cityText.getText().length() == 0) {
					cityActiontarget.setFill(Color.FIREBRICK);
					cityActiontarget.setText("Invalid City");
					return;
				}

				if (!zipText.getText().matches("[0-9]{5}")) {
					zipActiontarget.setFill(Color.FIREBRICK);
					zipActiontarget.setText("Invalid Zip");
					return;
				}

				if (countryText.getText().length() == 0) {
					countryActiontarget.setFill(Color.FIREBRICK);
					countryActiontarget.setText("Invalid Country");
					return;
				}

				if (!stateText.getText().matches("[A-Z]{2}")) {
					stateActiontarget.setFill(Color.FIREBRICK);
					stateActiontarget.setText("Invalid State");
					return;
				}
				DBConnection db = new DBConnection();
				double balance = 0.0;
				List<String> accountNum = db.getAccountNumberBusinessChecking();

				boolean found = false;
				for (String account : accountNum) {
					if (account.equals(accNrText.getText())) {
						found = true;
					}
				}

				if (accountTypeText.getText().equalsIgnoreCase(AccountType.CHECKING.toString())) {
					AccountFactory.createAccount(AccountType.CHECKING);

					db.setBusinessChecking(nameText.getText(), accNrText.getText(), street.getText(),
							cityText.getText(), zipText.getText(), stateText.getText(), countryText.getText(),
							accountTypeText.getText(), balance, emailText.getText());
					
					createActiontarget.setFill(Color.FIREBRICK);
					createActiontarget.setText("Account created");

					return;
				}

				else if (accountTypeText.getText().equalsIgnoreCase(AccountType.SAVING.toString())) {

					if (found) {
						AccountFactory.createAccount(AccountType.SAVING);

						db.setBusinessSaving(nameText.getText(), accNrText.getText(), street.getText(),
								cityText.getText(), zipText.getText(), stateText.getText(), countryText.getText(),
								accountTypeText.getText(), balance, emailText.getText());
                          
						createActiontarget.setFill(Color.FIREBRICK);
						createActiontarget.setText("Account created");
						
						return;

					} else {

						return;
					}
				} else if (accountTypeText.getText().equalsIgnoreCase(AccountType.CREDIT.toString())) {

					if (found) {
						AccountFactory.createAccount(AccountType.CREDIT);

						db.setBusinessSaving(nameText.getText(), accNrText.getText(), street.getText(),
								cityText.getText(), zipText.getText(), stateText.getText(), countryText.getText(),
								accountTypeText.getText(), balance, emailText.getText());
						
						createActiontarget.setFill(Color.FIREBRICK);
						createActiontarget.setText("Account created");

						return;

					} else {

						return;
					}
				} else {

					return;

				}
			}
		});

		Scene scene = new Scene(grid, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
