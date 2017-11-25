package UI;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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

public class SignUp extends Stage {

	Stage primaryStage;

	public SignUp(Stage stage) {

		primaryStage = stage;
		GridPane grid = new GridPane();
		primaryStage.setTitle("sign up");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label firstName = new Label("First Name");
		firstName.setTextFill(Color.WHITE);
		firstName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(firstName, 1, 1);

		TextField firstNameField = new TextField();
		grid.add(firstNameField, 2, 1);

		Label lastName = new Label("Last Name");
		lastName.setTextFill(Color.WHITE);
		lastName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(lastName, 1, 2);

		TextField lastNametField = new TextField();
		grid.add(lastNametField, 2, 2);

		Label userName = new Label("User Name");
		userName.setTextFill(Color.WHITE);
		userName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(userName, 1, 3);

		TextField auserNameTextField = new TextField();
		grid.add(auserNameTextField, 2, 3);

		Label passsword = new Label("Password");
		passsword.setTextFill(Color.WHITE);
		passsword.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(passsword, 1, 4);

		PasswordField passWordtField = new PasswordField();
		grid.add(passWordtField, 2, 4);

		Button exitButton = new Button("Exit");
		exitButton.setTextFill(Color.BLACK);
		exitButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		exitButton.setMaxSize(200, 30);
		exitButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(exitButton, 1, 5);

		Button dsignupButton = new Button("Sign up");
		dsignupButton.setTextFill(Color.BLACK);
		dsignupButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		dsignupButton.setMaxSize(200, 30);
		dsignupButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(dsignupButton, 2, 5);

		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		grid.add(actiontarget, 2, 6);

		dsignupButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				if (auserNameTextField.getText().length() < 3) {
					JOptionPane.showMessageDialog(null, "User name must be at least 3 charachter", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (passWordtField.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "Password must be at least 6 charachter", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				else {

					DBConnection db = new DBConnection();
					db.setloginData(firstNameField.getText(), lastNametField.getText(), auserNameTextField.getText(),
							passWordtField.getText());
					
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Account Created");

				}
			}

		});

		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				primaryStage.close();

			}
		});

		Scene scene1 = new Scene(grid);
		primaryStage.setScene(scene1);
		primaryStage.show();
	}

}