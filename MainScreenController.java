package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
//import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.*;

public class MainScreenController {

    @FXML
    private ChoiceBox<String> projectChoiceBox;
    @FXML
    private ChoiceBox<String> lifeCycleBox;
    @FXML
    private ChoiceBox<String> effortBox1;
    @FXML
    private ChoiceBox<String> effortBox2;
    @FXML
    private Button managerDashboard;
    
    private Stage stage;
    private Scene scene;
    private Parent root;

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
    public void switchToManagerDashboard(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
    
    private final String PASSWORD = "1234";
    @SuppressWarnings("unused")
    @FXML
	private void onManagerDashboardClicked(ActionEvent event) throws IOException {
    	
    	TextInputDialog passwordDialog = new TextInputDialog();
        passwordDialog.setTitle("A Manager Authentication Key");
        passwordDialog.setHeaderText("Enter the key to access the Manager Dashboard:");
        passwordDialog.setContentText("Authentication Key:");

        String enteredPassword = passwordDialog.showAndWait().orElse("");
        if (enteredPassword.equals(PASSWORD)) {
            System.out.println("correct password");
            
            Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
    		stage =(Stage)((Node)event.getSource()).getScene().getWindow();
    		stage.setScene(scene);
    		stage.show();
            
//            try {
//                Parent managerDashboardRoot = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
//                Scene managerDashboardScene = new Scene(managerDashboardRoot);
//                
//                // Getting the current stage
//                Stage currentStage = (Stage) managerDashboard.getScene().getWindow();
//                currentStage.setScene(managerDashboardScene);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }else {
        	System.out.println("incorrect password");
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect Password");
        alert.setContentText("The entered key is incorrect. You cannot access this content.");
        alert.showAndWait();
    }
}
    

}
