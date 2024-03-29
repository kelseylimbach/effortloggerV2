package application;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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
	private TextField Date;
	@FXML
	private TextField StartTime;
	@FXML
	private TextField StopTime;
	
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
    
   
    
    public List<String> readDataFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    data.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        return data;
    }


    @FXML
    private void onDeleteEntryButtonClick(ActionEvent event) {
        String selectedEntry = SelectEffortLogEntry.getValue();
        if ("None Selected".equals(selectedEntry)) {
            // Handle this case as desired, e.g., show an error message.
            return;
        }

        // Read the data from the file
        List<String> dataFromFile = readDataFromFile("data.txt");

        // Remove the selected entry
        dataFromFile.remove(selectedEntry);

        // Write the updated data back to the file
        writeDataToFile("data.txt", dataFromFile);

        // Clear the ChoiceBox and repopulate it with the updated data
        SelectEffortLogEntry.getItems().clear();
        dataFromFile.add(0, "None Selected");
        SelectEffortLogEntry.setItems(FXCollections.observableArrayList(dataFromFile));
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
    private void onClearEffortLogButtonClick(ActionEvent event) {
    	SelectProject.getSelectionModel().clearSelection();
        Date.clear();
        StartTime.clear();
        StopTime.clear();
        SelectEffortLogEntry.getSelectionModel().clearSelection();
        LifeCycle.getSelectionModel().clearSelection();
        EffortCategory.getSelectionModel().clearSelection();
        Plan.getSelectionModel().clearSelection();
    }
    
    public void initialize() {
        System.out.println("Initializing...");
        SelectProject.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));

        List<String> dataFromFile = null;
		dataFromFile = readDataFromFile("data.txt");
        dataFromFile.add(0, "None Selected"); // Add "None Selected" as the first option

        SelectEffortLogEntry.setItems(FXCollections.observableArrayList(dataFromFile));

        LifeCycle.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying",
                "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"));
        EffortCategory.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
        Plan.setItems(FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan",
                "Implementation Plan"));
    }
   
}