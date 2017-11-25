package UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class Loan extends Stage {
	Stage primaryStage;

	public Loan(Stage stage) {
		primaryStage = stage;
		primaryStage.setTitle("Loan");
		GridPane grid = new GridPane();
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label name = new Label("Name");
		name.setTextFill(Color.WHITE);
		name.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(name, 1, 1);

		TextField nameText = new TextField();
		grid.add(nameText, 2, 1);

		Label AccNr = new Label("Account number");
		AccNr.setTextFill(Color.WHITE);
		AccNr.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(AccNr, 1, 2);

		TextField AccNrText = new TextField();
		grid.add(AccNrText, 2, 2);

		Label loanAccount = new Label("Account");
		loanAccount.setTextFill(Color.WHITE);
		loanAccount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(loanAccount, 1, 3);

		TextField loanAccountText = new TextField();
		grid.add(loanAccountText, 2, 3);

		Label loanType = new Label("Loan Type");
		loanType.setTextFill(Color.WHITE);
		loanType.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(loanType, 1, 4);

		TextField loanTypeText = new TextField();
		grid.add(loanTypeText, 2, 4);

		Label loanAmount = new Label("Amount");
		loanAmount.setTextFill(Color.WHITE);
		loanAmount.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(loanAmount, 1, 5);

		TextField loanAmountText = new TextField();
		grid.add(loanAmountText, 2, 5);

		Button createLoan = new Button("Add Loan");
		createLoan.setMaxSize(200, 30);
		createLoan.setTextFill(Color.BLACK);
		createLoan.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(createLoan, 2, 6);
		grid.setGridLinesVisible(false);

		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		grid.add(actiontarget, 2, 7);

		Button payLoan = new Button("Pay Loan");
		payLoan.setMaxSize(200, 30);
		payLoan.setTextFill(Color.BLACK);
		payLoan.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(payLoan, 1, 6);
		grid.setGridLinesVisible(false);

		final Text payactiontarget = new Text();
		payactiontarget.setFill(Color.FIREBRICK);
		grid.add(payactiontarget, 1, 7);

		createLoan.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();
				
				List<String> accountNumBusiness = db.getAccountNumberBusinessChecking();
				List<String> accountNumPersonal = db.getAccountNumberPersonalChecking();
				
				boolean foundPersonal = false;
				boolean foundBusiness = false;

				for (String account : accountNumPersonal) {
					if (account.equals(AccNrText.getText())) {
						foundPersonal = true;
					}
				}

				for (String account : accountNumBusiness) {
					if (account.equals(AccNrText.getText())) {
						foundBusiness = true;
					}
				}

				boolean foundPersonalAtuoLoan = false;
				boolean foundPersonalBusinessLoan = false;

				HashMap<String, String> hp = db.getBalancePersonalAutoLoan();
				HashMap<String, String> hp1 = db.getBalancePersonalBusinessLoan();

				for (Entry<String,String> m : hp.entrySet()) {

					if (m.getKey().equals(AccNrText.getText())) {
						double value = Double.parseDouble((String) m.getValue());
						if (value != 0) {
							foundPersonalAtuoLoan = true;
						}
					}
				}

				for (Entry<String,String> m : hp1.entrySet()) {

					if (m.getKey().equals(AccNrText.getText())) {
						double value = Double.parseDouble((String) m.getValue());
						if (value != 0) {
							foundPersonalBusinessLoan = true;
						}
					}
				}

				boolean foundBusinessAtuoLoan = false;
				boolean foundBusinessBusinessLoan = false;

				HashMap<String, String> hb = db.getBalanceBusinessAutoLoan();
				HashMap<String, String> hb1 = db.getBalanceBusinessBusinessLoan();

				for (Entry<String,String> m : hb.entrySet()) {

					if (m.getKey().equals(AccNrText.getText())) {
						double value = Double.parseDouble((String) m.getValue());
						if (value != 0) {
							foundBusinessAtuoLoan = true;
						}
					}
				}

				for (Entry<String,String> m : hb1.entrySet()) {

					if (m.getKey().equals(AccNrText.getText())) {
						double value = Double.parseDouble((String) m.getValue());
						if (value != 0) {
							foundBusinessBusinessLoan = true;
						}
					}
				}

				if (loanAccountText.getText().equalsIgnoreCase("Personal")) {

					if (foundPersonal) {

						if (loanTypeText.getText().equalsIgnoreCase("AutoLoan")) {

							if (!foundPersonalAtuoLoan) {

								double atuoloan = Double.parseDouble(loanAmountText.getText());

								if (foundPersonalBusinessLoan) {

									db.updatePersonalAutoLoanBalance(atuoloan, AccNrText.getText());
									actiontarget.setText("AutoLoan added");
								}

								else {

									db.setPersonalLoan(nameText.getText(), AccNrText.getText(), atuoloan, 0.0);
									actiontarget.setText("AutoLoan added");
								}
							}
						}

						else {

							if (loanTypeText.getText().equalsIgnoreCase("BusinessLoan")) {

								if (!foundPersonalBusinessLoan) {

									double balanceloan = Double.parseDouble(loanAmountText.getText());

									if (foundPersonalAtuoLoan) {

										db.updatePersonalBusinessLoanBalance(balanceloan, AccNrText.getText());
										actiontarget.setText("BusinessLoan added");

									}

									else {

										db.setPersonalLoan(nameText.getText(), AccNrText.getText(), 0.0, balanceloan);
										actiontarget.setText("BusinessLoan added");
									}
								}
							}
						}
					}
				}

				else if (loanAccountText.getText().equalsIgnoreCase("Business")) {

					if (foundBusiness) {

						if (loanTypeText.getText().equalsIgnoreCase("AutoLoan")) {

							if (!foundBusinessAtuoLoan) {

								double atuoloan = Double.parseDouble(loanAmountText.getText());

								if (foundBusinessBusinessLoan) {

									db.updateBusinessAutoLoanBalance(atuoloan, AccNrText.getText());
									actiontarget.setText("AutoLoan added");
								}

								else {

									db.setBusinessLoan(nameText.getText(), AccNrText.getText(), atuoloan, 0.0);
									actiontarget.setText("AutoLoan added");
								}
							}
						}

						else {

							if (loanAccountText.getText().equalsIgnoreCase("Business")) {

								if (foundBusiness) {

									if (loanTypeText.getText().equalsIgnoreCase("BusinessLoan")) {

										if (!foundBusinessBusinessLoan) {

											double atuoloan = Double.parseDouble(loanAmountText.getText());

											if (foundBusinessAtuoLoan) {

												db.updateBusinessBusinessLoanBalance(atuoloan, AccNrText.getText());
												actiontarget.setText("BusinessLoan added");
											}

											else {

												db.setBusinessLoan(nameText.getText(), AccNrText.getText(), 0.0,
														atuoloan);
												actiontarget.setText("BusinessLoan added");
											}
										}
									}
								}
							}
						}
					}
				}

				else {
					actiontarget.setText("wrong input");
					return;
				}
			}

		});

		payLoan.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();
				double deposit = Double.parseDouble(loanAmountText.getText());

				List<String> accountNumBusiness = db.getAccountNumberBusinessChecking();
				List<String> accountNumPersonal = db.getAccountNumberPersonalChecking();

				List<String> accountPersonalLoan = db.getAccountNumberPersonalLoan();
				List<String> accountBusinessLoan = db.getAccountNumberBusinessLoan();

				boolean foundPersonal = false;
				boolean foundBusiness = false;

				for (String account : accountNumPersonal) {
					if (account.equals(AccNrText.getText())) {
						foundPersonal = true;
					}
				}

				for (String account : accountNumBusiness) {
					if (account.equals(AccNrText.getText())) {
						foundBusiness = true;
					}
				}

				if (loanAccountText.getText().equalsIgnoreCase("Personal")) {

					if (foundPersonal) {

						if (loanTypeText.getText().equalsIgnoreCase("AutoLoan")) {

							HashMap<String, String> hp = db.getBalancePersonalAutoLoan();
							double autoloan = 0.0;

							if (hp.containsKey(AccNrText.getText())) {

								autoloan = Double.parseDouble(hp.get(AccNrText.getText()));
							}

							for (String account : accountPersonalLoan) {

								if (AccNrText.getText().equals(account)) {

									db.updatePersonalAutoLoanBalance(autoloan - deposit, AccNrText.getText());
									payactiontarget.setText("AutoLoan paid");
									return;
								}
							}

						}

						else {

							if (loanTypeText.getText().equalsIgnoreCase("BusinessLoan")) {

								HashMap<String, String> hp = db.getBalancePersonalBusinessLoan();
								double autoloan = 0.0;

								if (hp.containsKey(AccNrText.getText())) {

									autoloan = Double.parseDouble(hp.get(AccNrText.getText()));
								}

								for (String account : accountPersonalLoan) {

									if (AccNrText.getText().equals(account)) {

										db.updatePersonalBusinessLoanBalance(autoloan - deposit, AccNrText.getText());
										payactiontarget.setText("BusinessLoan paid");
										return;
									}
								}

							}
						}
					}
				}

				else if (loanAccountText.getText().equalsIgnoreCase("Business")) {

					if (foundBusiness) {

						if (loanTypeText.getText().equalsIgnoreCase("AutoLoan")) {

							HashMap<String, String> hp = db.getBalanceBusinessAutoLoan();
							double autoloan = 0.0;

							if (hp.containsKey(AccNrText.getText())) {

								autoloan = Double.parseDouble(hp.get(AccNrText.getText()));
							}

							for (String account : accountBusinessLoan) {

								if (AccNrText.getText().equals(account)) {

									db.updateBusinessAutoLoanBalance(autoloan - deposit, AccNrText.getText());
									payactiontarget.setText("AutoLoan paid");
									return;
								}
							}

						}

						else {

							if (loanTypeText.getText().equalsIgnoreCase("BusinessLoan")) {

								HashMap<String, String> hp = db.getBalanceBusinessBusinessLoan();
								double autoloan = 0.0;

								if (hp.containsKey(AccNrText.getText())) {

									autoloan = Double.parseDouble(hp.get(AccNrText.getText()));
								}

								for (String account : accountBusinessLoan) {

									if (AccNrText.getText().equals(account)) {

										db.updateBusinessBusinessLoanBalance(autoloan - deposit, AccNrText.getText());
										payactiontarget.setText("BusinessLoan paid");
										return;
									}
								}

							}
						}
					}

				}

				else {
					payactiontarget.setText("wrong input");
					return;
				}
			}

		});

		Scene scene = new Scene(grid);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
