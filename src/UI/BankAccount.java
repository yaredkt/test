package UI;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BankAccount extends Stage {
	
	Stage primaryStage;
	GridPane grid = new GridPane();

	public BankAccount(Stage stage) {
		primaryStage = stage;

		setTitle("Bank Account");
		grid.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(100, 100, 100, 150));

		Button button1 = new Button("Create Personal Account");
		button1.setTextFill(Color.BLACK);
		button1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button1, 1, 1);

		Button button2 = new Button("Create Business Account");
		button2.setTextFill(Color.BLACK);
		button2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button2, 1, 2);

		Button button3 = new Button("Loan");
		button3.setMaxSize(200, 30);
		button3.setTextFill(Color.BLACK);
		button3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button3, 1, 3);

		Button button4 = new Button("Deposit");
		button4.setTextFill(Color.BLACK);
		button4.setMaxSize(200, 30);
		button4.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button4, 1, 4);

		Button button5 = new Button("Withdraw");
		button5.setTextFill(Color.BLACK);
		button5.setMaxSize(200, 30);
		button5.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button5, 1, 5);
		
		Button button7 = new Button("History");
		button7.setMaxSize(200, 30);
		button7.setTextFill(Color.BLACK);
		button7.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button7, 1, 6);


		Button button6 = new Button("Exit");
		button6.setMaxSize(200, 30);
		button6.setTextFill(Color.BLACK);
		button6.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
		grid.add(button6, 1, 7);

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				
				PersonAccount wd = new PersonAccount(primaryStage);
				wd.primaryStage.show();

			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				BusinessAccount businessAccount = new BusinessAccount(primaryStage);
				businessAccount.primaryStage.show();

			}
		});

		button3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Loan creditAccount = new Loan(primaryStage);
				creditAccount.primaryStage.show();

			}
		});

		button4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Deposit deposit = new Deposit(primaryStage);
				deposit.primaryStage.show();

			}
		});

		button5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				WithDraw wd = new WithDraw(primaryStage);
				wd.primaryStage.show();

			}
		});

		button6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Platform.exit();

			}
		});
		
		button7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				History history = new History(primaryStage);
				history.primaryStage.show();

			}
		});

		Scene scene = new Scene(grid, 500, 500);
		positionSceneInStage(this, scene);
		setScene(scene);

	}

	void setBackground(Color color) {
		grid.backgroundProperty().set(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	void positionSceneInStage(Stage stage, Scene scene) {
		stage.setX(200);
		stage.setY(200);

	}

}
