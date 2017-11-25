package UI;

import java.util.HashMap;

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

public class UserLogin {

	Stage primaryStage;

	public UserLogin(Stage stage) {

		primaryStage = stage;
		GridPane grid = new GridPane();
		primaryStage.setTitle("Create User Name");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label userName = new Label("User Name");
		userName.setTextFill(Color.WHITE);
		userName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(userName, 1, 1);

		TextField auserNameTextField = new TextField();
		grid.add(auserNameTextField, 2, 1);

		Label passsword = new Label("Password");
		passsword.setTextFill(Color.WHITE);
		passsword.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(passsword, 1, 2);

		PasswordField passWordtField = new PasswordField();
		grid.add(passWordtField, 2, 2);

		Button dsignupButton = new Button("Login");
		dsignupButton.setTextFill(Color.BLACK);
		dsignupButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		dsignupButton.setMaxSize(200, 30);
		dsignupButton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(dsignupButton, 2, 3);
		
		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		grid.add(actiontarget, 2, 4);

		dsignupButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();

				HashMap<String, String> hp = db.getUser();

				if (!(hp.containsKey(auserNameTextField.getText()) && (hp.containsValue(passWordtField.getText())))) {

					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("invalid username or password");
					return;

				}

				else {

					History signup = new History(primaryStage);
					signup.primaryStage.show();

				}
			}
		});

		Scene scene1 = new Scene(grid);
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
}
