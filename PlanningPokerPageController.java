package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PlanningPokerPageController {
	
	 @FXML
	    private void onBackToConsoleButtonClick(ActionEvent event) throws IOException {
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

	 @FXML
	    private TextField backlogItemTitleField;
	 
	 @FXML
	    private TextField effortEstimateField;
	 
	 @FXML
	    private TextField storyPointEstimateField;
	 
	private String selectedBacklogItem, selectedEffortEstimate, selectedStoryPoint;
	
	
	@FXML
		private void onSaveButtonClick(ActionEvent event) throws IOException {
	        selectedBacklogItem = backlogItemTitleField.getText();
	        selectedEffortEstimate = effortEstimateField.getText();
			selectedStoryPoint = storyPointEstimateField.getText(); 
	        writePPToData3();       
	    }

	private void writePPToData3() throws IOException {
            // Format the entry as a single string
		String entry = selectedBacklogItem + ", " + 
	            selectedEffortEstimate + ", " +
	            selectedStoryPoint;
	            
	        try (PrintWriter writer = new PrintWriter(new FileWriter("data3.txt", true))) {
	        	writer.println(entry);
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
    }

	
	public void writeDataToFile(String fileName, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String entry : data) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
    }
	
	@FXML
		private void onEnterAnotherItemButtonClick(ActionEvent event) throws IOException{
			 backlogItemTitleField.clear();
		     effortEstimateField.clear();
		     storyPointEstimateField.clear();
		}
	
	 
    public void initialize() {
    	selectedBacklogItem = backlogItemTitleField.getText();
		
		selectedEffortEstimate = effortEstimateField.getText();
		
		selectedStoryPoint = storyPointEstimateField.getText();
    }
}