package application;
import javafx.collections.FXCollections;
//Written by Sabrina Nelson
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDateTime;

public class DefectLogConsolePageController {

	
    @FXML
    private void onBackToHomeButtonClick(ActionEvent event) throws IOException {
        // Load the FXML file for the main screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/DisplayPage.fxml"));
        Parent root = loader.load();

        // Get the current stage (window)
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Create a new scene with the loaded FXML root
        Scene scene = new Scene(root);

        // Set the new scene to the current stage
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void onClearLogButtonClick(ActionEvent event) throws IOException {
    	System.out.println("Clear button clicked");
    }
    @FXML
    private void onNewDefectButtonClick(ActionEvent event) throws IOException {
    	System.out.println("New Defect button clicked");
    }
    @FXML
    private void onUpdateDefectButtonClick(ActionEvent event) throws IOException {
    	System.out.println("Update Defect button clicked");
    }
    @FXML
    private void onDeleteDefectButtonClick(ActionEvent event) throws IOException {
    	System.out.println("Delete Defect button clicked");
    }
    
    @FXML
    private Label statusLabel;
    
    @FXML
	private ChoiceBox<String> projectPicker;
    
    @FXML
	private ChoiceBox<String> defectPicker;
    
    @FXML
   	private ChoiceBox<String> fixChoiceBox;
    
	 @FXML
	    private void onCloseButtonClick() {
	        statusLabel.setText("Status: closed");
	        //TO-DO: add remaining functionality for when closed
	 }
	 
	 @FXML
	    private void onReopenButtonClick() {
	        statusLabel.setText("Status: opened");
	      //TO-DO: add remaining functionality for when opened
	 }
	 
	 @FXML
		public void initialize() {
			System.out.println("Initializing Defect Log Console...");
			//TO-DO: add correct items to choice boxes
			// let choice boxes auto populate based on the projectPicker
			projectPicker.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
			defectPicker.setItems(FXCollections.observableArrayList("- no defect selected - ", "Item 2", "Item 3"));
			fixChoiceBox.setItems(FXCollections.observableArrayList("Item 1", "Item 2", "Item 3"));
	 }
}
