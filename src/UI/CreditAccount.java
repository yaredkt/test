package UI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreditAccount extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Credit Account");

		GridPane grid = new GridPane();

		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setHgap(10);
		grid.setStyle("-fx-background: #6495ED;");
		
		grid.setPadding(new Insets(30, 50, 50, 0));

		Text title = new Text("Credit Account");
		title.setFill(Color.WHITE);
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
		grid.add(title, 0, 1, 2, 1);

		Label name = new Label("Name");
		name.setTextFill(Color.BLACK);
		name.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(name, 0, 4);

		TextField nameText = new TextField();
		grid.add(nameText, 1, 4);
		
		Label birthDate = new Label("BirthDate");
		birthDate.setTextFill(Color.BLACK);
		birthDate.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(birthDate, 0, 5);

		TextField birthDateText = new TextField();
		grid.add(birthDateText, 1, 5);

		Label AccNr = new Label("AccNr");
		AccNr.setTextFill(Color.BLACK);
		AccNr.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(AccNr, 0, 6);
		
		TextField AccNrText = new TextField();
		grid.add(AccNrText, 1, 6);
		
		Label street = new Label("Street");
		street.setTextFill(Color.BLACK);
		street.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(street, 0, 7);
		
		
		TextField streetText = new TextField();
		grid.add(streetText, 1, 7);
		
		Label city = new Label("City");
		city.setTextFill(Color.BLACK);
		city.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(city, 0, 8);
		
		
		TextField cityText = new TextField();
		grid.add(cityText, 1, 8);
		
		Label zip = new Label("Zip");
		zip.setTextFill(Color.BLACK);
		zip.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(zip, 0, 9);
		
		
		TextField zipText = new TextField();
		grid.add(zipText, 1, 9);
		
		Label state = new Label("State");
		state.setTextFill(Color.BLACK);
		state.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(state, 0, 10);
		
		
		TextField stateText = new TextField();
		grid.add(stateText, 1, 10);
		
		Label country = new Label("Country");
		country.setTextFill(Color.BLACK);
		country.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(country, 0, 11);
		
		
		TextField countryText = new TextField();
		grid.add(countryText, 1, 11);
		
		Label accountType = new Label("AccountType");
		accountType.setTextFill(Color.BLACK);
		accountType.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(accountType, 0, 12);
		
		
		TextField accountTypeText = new TextField();
		grid.add(accountTypeText, 1, 12);
		
		Label ssn = new Label("SSN");
		ssn.setTextFill(Color.BLACK);
		ssn.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(ssn, 0, 13);
		
		
		TextField ssnText = new TextField();
		grid.add(ssnText, 1, 13);
		
		Label email = new Label("Email");
		email.setTextFill(Color.BLACK);
		email.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 16));
		grid.add(email, 0, 14);
		
		
		TextField emailText = new TextField();
		grid.add(emailText, 1, 14);
		
		Button create = new Button("create");
		create.setTextFill(Color.BLACK);
		create.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
		HBox hbcreate = new HBox(8);
		hbcreate.setAlignment(Pos.BOTTOM_CENTER);
		hbcreate.getChildren().add(create);
		grid.add(hbcreate, 1,17);
		

		 grid.setGridLinesVisible(false) ;
		 
		Scene scene = new Scene(grid, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
