package application;

import java.io.IOException;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.*;
//import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.text.Font;
//import javafx.scene.control.Alert.AlertType;
//import javafx.stage.*;
import javafx.stage.Stage;


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
    private Label clockStatusLabel;

	@FXML
	private Label loginSuccessLabel; // New label for login success
//	private Stage stage;
//	private Scene scene;
//	private Parent root;
	
	 @FXML
	    private void onStartActivityButtonClick() {
	        clockStatusLabel.setText("Clock is Running");
	        clockStatusLabel.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-padding: 10;");
	        clockStatusLabel.setFont(new Font(14));
	    }

	    @FXML
	    private void onStopActivityButtonClick() {
	        clockStatusLabel.setText("Clock is stopped");
	        clockStatusLabel.setStyle("-fx-text-fill: white; -fx-background-color: red; -fx-padding: 10;");
	        clockStatusLabel.setFont(new Font(14));
	    }

	 @FXML
	    private void onELEditorButtonClick() throws IOException {
	        // Load the FXML file for the Effort Log Editor Page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EffortLogEditorPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onEffortDefectLogButtonClick() throws IOException {
	        // Load the FXML file for the Effort Log Editor Page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/EffortLogEditorPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onDefinitionButtonClick() throws IOException {
	        // Load the FXML file for the Effort Log Editor Page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DefinitionsPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onDefectLogConsoleButtonClick() throws IOException {
	        // Load the FXML file for the Effort Log Editor Page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DefectLogConsolePage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
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
}