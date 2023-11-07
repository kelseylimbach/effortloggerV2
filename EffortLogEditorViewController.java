package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import java.io.IOException;
public class EffortLogEditorViewController {
	
	@FXML
	private ChoiceBox<String> SelectProject;
	@FXML
	private ChoiceBox<String> SelectEffortLogEntry;
	@FXML
	private ChoiceBox<String> LifeCycle;
	@FXML
	private ChoiceBox<String> EffortCategory;
	@FXML
	private ChoiceBox<String> Plan;
	
    @FXML
    private void onBackToHomeButtonClick(ActionEvent event) throws IOException {
        // Load the FXML file for the main screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DisplayPage.fxml"));
        Parent root = loader.load();
        // Get the current stage (window)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create a new scene with the loaded FXML root
        Scene scene = new Scene(root);
        // Set the new scene to the current stage
        stage.setScene(scene);
        stage.show();
    }
    
    public void initialize() {
    	System.out.println("Initializing...");
    	SelectProject.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
    	SelectEffortLogEntry.setItems(FXCollections.observableArrayList("None Selected", "item1", "item2"));
    	LifeCycle.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding","Verifying", 
    			"Outlining","Drafting","Finalizing","Team Meeting","Coach Meeting","Stakeholder Meeting"));
    	EffortCategory.setItems(FXCollections.observableArrayList("Plans","Deliverables","Interruptions","Defects","Others"));
    	Plan.setItems(FXCollections.observableArrayList("Project Plan","Risk Management Plan","Conceptual Design Plan","Detailed Design Plan", 
    			"Implementation Plan"));
    }
   
}