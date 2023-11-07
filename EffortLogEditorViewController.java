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
import java.io.BufferedReader;
import java.io.FileReader;
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
            StringBuilder entryBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // Skip empty lines and lines without a colon
                if (line.trim().isEmpty() || !line.contains(":")) {
                    if (entryBuilder.length() > 0) {
                        // Add the combined entry to the data list and reset the builder
                        data.add(entryBuilder.toString().trim());
                        entryBuilder.setLength(0);
                    }
                    continue;
                }

                // Remove the section before the colon and append to the current entry
                String entry = line.substring(line.indexOf(":") + 2); // +2 to skip ": "
                entryBuilder.append(entry).append(", ");
            }
            // Add the last combined entry to the data list (if any)
            if (entryBuilder.length() > 0) {
                data.add(entryBuilder.toString().trim());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
        return data;
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