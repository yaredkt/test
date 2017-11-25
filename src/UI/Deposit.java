package UI;

import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import Entity.CheckingAccount;
import Entity.SavingAccount;
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

public class Deposit extends Stage {

	Stage primaryStage;

	public Deposit(Stage stage) {

		primaryStage = stage;
		GridPane grid = new GridPane();
		primaryStage.setTitle("Deposit");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label acNumber = new Label("Account Number");
		acNumber.setTextFill(Color.WHITE);
		acNumber.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(acNumber, 1, 1);

		TextField actNumTextField = new TextField();
		grid.add(actNumTextField, 2, 1);

		Label account = new Label("Account");
		account.setTextFill(Color.WHITE);
		account.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(account, 1, 2);

		TextField accountTextField = new TextField();
		grid.add(accountTextField, 2, 2);

		Label acType = new Label("Account type");
		acType.setTextFill(Color.WHITE);
		acType.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(acType, 1, 3);

		TextField acTypeTextField = new TextField();
		grid.add(acTypeTextField, 2, 3);

		Label amount = new Label("Amount");
		amount.setTextFill(Color.WHITE);
		amount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(amount, 1, 4);

		TextField amountTextField = new TextField();
		grid.add(amountTextField, 2, 4);

		Button depositButton = new Button("Deposit");
		depositButton.setTextFill(Color.BLACK);
		depositButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		depositButton.setMaxSize(200, 30);
		depositButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(depositButton, 2, 6);

		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		grid.add(actiontarget, 2, 7);

		Button exitButton = new Button("Exit");
		exitButton.setTextFill(Color.BLACK);
		exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		exitButton.setMaxSize(200, 30);
		exitButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(exitButton, 1, 6);

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		depositButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();
				db.getAccountNumberPersonalChecking();
				List<String> accountNumpersonalsaving = db.getAccountNumberPersonalSaving();

				List<String> accountNumbusinesschecking = db.getAccountNumberBusinessChecking();
				List<String> accountNumbusinesssaving = db.getAccountNumberBusinessSaving();

				double deposit = Double.parseDouble(amountTextField.getText());

				if (accountTextField.getText().equalsIgnoreCase("Personal")) {
					if (acTypeTextField.getText().equalsIgnoreCase(AccountType.CHECKING.toString())) {
						db.updatePersonalCheckingBalance(deposit, actNumTextField.getText());
						actiontarget.setFill(Color.FIREBRICK);
						actiontarget.setText("Deposited in Checking");
						actNumTextField.setText("");
						accountTextField.setText("");
						acTypeTextField.setText("");
						amountTextField.setText("");
						return;
					}

					if (acTypeTextField.getText().equalsIgnoreCase(AccountType.SAVING.toString())) {
						double orginal = 0.0;
						HashMap<String, String> hp = db.getBalancePersonalSaving();

						if (hp.containsKey(actNumTextField.getText())) {
							orginal = Double.parseDouble(hp.get(actNumTextField.getText()));
						}

						for (String account : accountNumpersonalsaving) {
							if (actNumTextField.getText().equals(account)) {
								db.updatePersonalSavingBalance(orginal + deposit, actNumTextField.getText());
								actiontarget.setFill(Color.FIREBRICK);
								actiontarget.setText("Deposited in Saving");
								actNumTextField.setText("");
								accountTextField.setText("");
								acTypeTextField.setText("");
								amountTextField.setText("");
								return;
							}
						}
					}

					else {
						actiontarget.setText("account number not found");
						return;
					}

				} else if (accountTextField.getText().equalsIgnoreCase("business")) {

					if (acTypeTextField.getText().equalsIgnoreCase(AccountType.CHECKING.toString())) {
						double orginal = 0.0;
						HashMap<String, String> hp = db.getBalanceBusinessChecking();
						if (hp.containsKey(actNumTextField.getText())) {
							orginal = Double.parseDouble(hp.get(actNumTextField.getText()));
						}

						for (String account : accountNumbusinesschecking) {
							if (actNumTextField.getText().equals(account)) {
								db.updateBusinessCheckingBalance(orginal + deposit, actNumTextField.getText());
								actiontarget.setFill(Color.FIREBRICK);
								actiontarget.setText("Deposited in Checking");
								actNumTextField.setText("");
								accountTextField.setText("");
								acTypeTextField.setText("");
								amountTextField.setText("");
								return;
							}
						}
					}

					if (acTypeTextField.getText().equalsIgnoreCase(AccountType.SAVING.toString())) {
						double orginal = 0.0;
						HashMap<String, String> hp = db.getBalancePersonalSaving();
						if (hp.containsKey(actNumTextField.getText())) {
							orginal = Double.parseDouble(hp.get(actNumTextField.getText()));
						}

						for (String account : accountNumbusinesssaving) {
							if (actNumTextField.getText().equals(account)) {
								db.updateBusinessSavingBalance(orginal + deposit, actNumTextField.getText());
								actiontarget.setFill(Color.FIREBRICK);
								actiontarget.setText("Deposited in Saving");
								actNumTextField.setText("");
								accountTextField.setText("");
								acTypeTextField.setText("");
								amountTextField.setText("");
								return;
							}
						}
					}

					else {
						actiontarget.setText("account number not found");
						return;
					}

				}

			}

		});

		Scene scene1 = new Scene(grid);
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
}
