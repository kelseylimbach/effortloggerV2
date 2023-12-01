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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	private ChoiceBox<String> stepWhenInjected;
    
    @FXML
	private ChoiceBox<String> stepWhenRemoved;
    
    
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
	 
	 ArrayList<String> EffortCategories = new ArrayList<>();
	 ArrayList<String> Plan2 = new ArrayList<>();
	 ArrayList<String> lifeCycles = new ArrayList<>();
	 ArrayList<String> lifeCycles2 = new ArrayList<>();
	 ArrayList<String> projectNames = new ArrayList<>();
	 ArrayList<String> Defects = new ArrayList<>();
	 
	 private void loadStepOutput(ArrayList<String> arr, String fileName, ChoiceBox<String> box) {
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            if (!line.matches("^\\d+,$")) {
		                String[] parts = line.split(",", 2);
		                if (parts.length > 1) {
		                	arr.add(parts[1].trim());
		                }
		            }
		        }
		        box.setItems(FXCollections.observableArrayList(arr));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	 
	 private void loadLifeCycle(ArrayList<String> arr, String fileName, ChoiceBox<String> box) {
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] parts = line.split(",", -1);
		            if (parts.length >= 2 && !parts[1].trim().isEmpty()) {
		            	arr.add(parts[1].trim());
		            }
		        }
		        box.setItems(FXCollections.observableArrayList(arr));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		} 
	 
	 private void loadProjects(ArrayList<String> arr, String fileName, ChoiceBox<String> box) {
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] parts = line.split(",", -1);
		            if (parts.length >= 2 && !parts[1].trim().isEmpty()) {
		            	arr.add(parts[1].trim());
		            }
		        }
		        box.setItems(FXCollections.observableArrayList(arr));
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}


	 
	 @FXML
		public void initialize() {
			System.out.println("Initializing Defect Log Console...");
			//TO-DO: add correct items to choice boxes
			// let choice boxes auto populate based on the projectPicker
			loadProjects(projectNames, "Projects.txt", projectPicker);
			/*
	        loadLifeCycle(lifeCycles, "LifeCycleSteps.txt", *ADD*);
	        loadStepOutput(EffortCategories, "EffortCategories.txt", *ADD*);
	        loadStepOutput(Plan2, "Plans.txt", *ADD*);
	        */
			loadLifeCycle(lifeCycles, "LifeCycleSteps.txt", stepWhenInjected);
			loadLifeCycle(lifeCycles2, "LifeCycleSteps.txt", stepWhenRemoved);
			//projectPicker.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
			loadStepOutput(Defects, "DefectCategories.txt", defectPicker);
			//defectPicker.setItems(FXCollections.observableArrayList("- no defect selected - ", "Item 2", "Item 3"));
			//fixChoiceBox.setItems(FXCollections.observableArrayList("Item 1", "Item 2", "Item 3"));
	 }
}