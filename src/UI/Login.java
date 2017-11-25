package UI;

import java.util.HashMap;

import javax.swing.JOptionPane;

import javafx.application.Application;
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

public class Login extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	GridPane grid1 = null;
	Text messageBar = new Text();

	Stage bankAccount;
	Stage primaryStage;

	private void createSecondWindwo() {

		bankAccount = new BankAccount(primaryStage);
		messageBar.setText("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		primaryStage.setTitle("Two Windows");
		createSecondWindwo();

		primaryStage.setTitle("Bank");

		GridPane grid = new GridPane();

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		grid.setPadding(new Insets(50, 50, 50, 50));

		Text title = new Text("Banking System");
		title.setFill(Color.WHITE);
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		grid.add(title, 0, 1, 2, 1);

		Label userId = new Label("Admin");
		userId.setTextFill(Color.WHITE);
		userId.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(userId, 0, 4);

		TextField userIdTextField = new TextField("Admin");
		grid.add(userIdTextField, 1, 4);

		Label password = new Label("Password");
		password.setTextFill(Color.WHITE);
		password.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		grid.add(password, 0, 5);

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("password");
		grid.add(passwordField, 1, 5);

		Button login = new Button("login");
		login.setMaxSize(200, 30);
		login.setTextFill(Color.BLACK);
		login.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		login.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(login, 1, 7);

		Button userbutton = new Button("User");
		userbutton.setMaxSize(200, 30);
		userbutton.setTextFill(Color.BLACK);
		userbutton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		userbutton.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(userbutton, 0, 7);

		Button signup = new Button("Sign up");
		signup.setTextFill(Color.BLACK);
		signup.setMaxSize(200, 30);
		signup.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		signup.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(signup, 1, 8);

		final Text actiontarget = new Text();
		actiontarget.setFill(Color.FIREBRICK);
		grid.add(actiontarget, 1, 6);

		login.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				DBConnection db = new DBConnection();

				HashMap<String, String> hp = db.getlogin();

				if (userIdTextField.getText().length() < 3) {
					JOptionPane.showMessageDialog(null, "User name must be at least 3 charachter", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (passwordField.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "Password must be at least 6 charachter", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (!(hp.containsKey(userIdTextField.getText()) && (hp.containsValue(passwordField.getText())))) {

					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("invalid userName or password");

				} else {
					bankAccount.show();
					primaryStage.hide();
				}
			}

		});

		signup.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				CreateUserName signup = new CreateUserName(primaryStage);
				signup.primaryStage.show();
			}
		});

		userbutton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				UserLogin history = new UserLogin(primaryStage);
				history.primaryStage.show();
			}
		});

		Scene scene = new Scene(grid, 400, 300);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
