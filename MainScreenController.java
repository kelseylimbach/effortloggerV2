package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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

    @FXML
    public void initialize() {
    	System.out.println("Initializing...");
    	 projectChoiceBox.setItems(FXCollections.observableArrayList("Option A", "Option B", "Option C"));
    	 lifeCycleBox.setItems(FXCollections.observableArrayList("Option A", "Option B", "Option C"));
    	 effortBox1.setItems(FXCollections.observableArrayList("Option A", "Option B", "Option C"));
    	 effortBox2.setItems(FXCollections.observableArrayList("Option A", "Option B", "Option C"));
    }
    
    private final String PASSWORD = "1234";
    @SuppressWarnings("unused")
    @FXML
	private void onManagerDashboardClicked() {
    	
    	TextInputDialog passwordDialog = new TextInputDialog();
        passwordDialog.setTitle("A Manager Authentication Key");
        passwordDialog.setHeaderText("Enter the key to access the Manager Dashboard:");
        passwordDialog.setContentText("Authentication Key:");

        String enteredPassword = passwordDialog.showAndWait().orElse("");
        if (enteredPassword.equals(PASSWORD)) {
            System.out.println("correct password");
            try {
                Parent managerDashboardRoot = FXMLLoader.load(getClass().getResource("ManagerScreen.fxml"));
                Scene managerDashboardScene = new Scene(managerDashboardRoot);
                
                // Getting the current stage
                Stage currentStage = (Stage) managerDashboard.getScene().getWindow();
                currentStage.setScene(managerDashboardScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
