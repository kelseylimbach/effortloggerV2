package application;

//import javafx.fxml. *;
//import javafx.scene.control.*;

//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
import javafx.collections.*;
//import javafx.event.*;
import javafx.fxml.*;
//import javafx.scene.*;
//import javafx.collections.FXCollections;
import javafx.scene.control.*;
//import javafx.scene.control.Alert.AlertType;
//import javafx.stage.*;


public class DisplayViewController {
	
	@FXML
	private ChoiceBox<String> projectChoiceBox;
	@FXML
	private ChoiceBox<String> lifeCycleBox;
	@FXML
	private ChoiceBox<String> effortBox1;
	@FXML
	private ChoiceBox<String> effortBox2;
	
	@FXML
	private Label loginSuccessLabel; // New label for login success
//	private Stage stage;
//	private Scene scene;
//	private Parent root;

	@FXML
	public void initialize() {
		System.out.println("Initializing...");
		projectChoiceBox.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
		 	lifeCycleBox.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding",
				"Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"));
		 	effortBox1.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
		 	effortBox2.setItems(FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Desing Plan",
				 "Detailed Design Plan", "Implementation Plan"));
	}



//    @FXML
//    private Label username;
//    @FXML
//    private Label password;
//    @FXML
//    private Label passwordLength; // Password length label
//    
//    @FXML
//    private Label loginSuccessLabel; // New label for login success
//
//    public void setLogin(Login login) {
//        username.setText("Name: " + login.getName());
//        password.setText("Password: " + login.getPassword());
//        passwordLength.setText("Length: " + login.getPasswordLength());
//    }
}
