package UI;

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
import javafx.stage.Stage;

public class UserHistory extends Stage {
	Stage primaryStage;

	public UserHistory(Stage stage) {
			primaryStage = stage;
			GridPane grid = new GridPane();
			primaryStage.setTitle("User History");
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

			Label lastName = new Label("Account type");
			lastName.setTextFill(Color.WHITE);
			lastName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
			grid.add(lastName, 1, 2);

			TextField lastNametField = new TextField();
			grid.add(lastNametField, 2, 2);

			Label userName = new Label("Account Number");
			userName.setTextFill(Color.WHITE);
			userName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
			grid.add(userName, 1, 3);

			TextField auserNameTextField = new TextField();
			grid.add(auserNameTextField, 2, 3);

			
			Button showButton = new Button("Show");
			showButton.setTextFill(Color.BLACK);
			showButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
			showButton.setMaxSize(200, 30);
			showButton.setAlignment(Pos.BOTTOM_CENTER);
			grid.add(showButton, 1, 4);
			
			showButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					History history = new History(primaryStage);
					history.primaryStage.show();
					
			       
				
				}
			});

			Scene scene1 = new Scene(grid);
			primaryStage.setScene(scene1);
			primaryStage.show();
		}

	}



