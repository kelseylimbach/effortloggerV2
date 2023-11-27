package application;
//written by Sabrina Nelson & Saachi Mota
//imports
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class EffortLogEditorPageController {
	
	//choice boxes
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
	
	//text fields
	@FXML
	private TextField Date;
	@FXML
	private TextField StartTime;
	@FXML
	private TextField StopTime;
	
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
      
    public List<String> readDataFromFile(String fileName) {
        List<String> entries = new ArrayList<>();
        StringBuilder entryBuilder = new StringBuilder();
        boolean isBuildingEntry = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User:")) {
                    isBuildingEntry = true;
                    entryBuilder = new StringBuilder(); // Start a new entry
                }
                if (isBuildingEntry) {
                    entryBuilder.append(line).append("\n"); // Append the line to the current entry
                }
                if (line.contains("Plan:")) {
                    isBuildingEntry = false;
                    entries.add(entryBuilder.toString().trim()); // Add the completed entry to the list
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        return entries;
    }



    @FXML
    private void onDeleteEntryButtonClick(ActionEvent event) {
        String selectedEntry = SelectEffortLogEntry.getValue();
        if ("None Selected".equals(selectedEntry)) {
            // TODO: add error message 
            return;
        }

        // Read the data from the file
        List<String> dataFromFile = readDataFromFile("data.txt");

        // Remove the selected entry
        dataFromFile.remove(selectedEntry);

        // Write the updated data back to the file
        writeListDataToFile("data.txt", dataFromFile);

        // Clear the ChoiceBox and repopulate it with the updated data
        SelectEffortLogEntry.getItems().clear();
        dataFromFile.add(0, "None Selected");
        SelectEffortLogEntry.setItems(FXCollections.observableArrayList(dataFromFile));
    }

    public void writeListDataToFile(String fileName, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String entry : data) {
                writer.write(entry); //write each line
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    
    public void writeStringDataToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);	//write the string that was passed in
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    
    @FXML
    private void onUpdateEntryButtonClick(ActionEvent event) {
        String selectedEntry = SelectEffortLogEntry.getValue();
        if ("None Selected".equals(selectedEntry) || selectedEntry == null) {
            //TODO: add error message
            return;
        }

        // Read the entire file
        List<String> dataFromFile = readDataFromFile("data.txt");

        // Find and update the selected entry
        boolean isEntryFound = false;
        for (int i = 0; i < dataFromFile.size(); i++) {
            if (dataFromFile.get(i).equals(selectedEntry)) {
                isEntryFound = true;
                String updatedEntry = updateSelectedEntry(dataFromFile.get(i));
                dataFromFile.set(i, updatedEntry);
                break;
            }
        }

        if (isEntryFound) {
            // Write the updated content back to the file
            writeListDataToFile("data.txt", dataFromFile);

            // Refresh the ChoiceBox
            refreshChoiceBox();
            
         // Clear the Date, StartTime, and StopTime fields
            Date.clear();
            StartTime.clear();
            StopTime.clear();
        }
    }

    private String updateSelectedEntry(String entry) {
    	String[] lines = entry.split("\n");
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a M/d/yyyy"); 

        //parse the string version of the times
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].startsWith("Activity Started:")) {
                startTime = LocalDateTime.parse(StartTime.getText() + " " + Date.getText(), formatter);
                lines[i] = "Activity Started: " + StartTime.getText() + " " + Date.getText();
            } else if (lines[i].startsWith("Activity Ended:")) {
                endTime = LocalDateTime.parse(StopTime.getText() + " " + Date.getText(), formatter);
                lines[i] = "Activity Ended: " + StopTime.getText() + " " + Date.getText();
            } //get the updated project value if one exists
            else if (lines[i].startsWith("Project:") && SelectProject.getValue() != null && !SelectProject.getValue().isEmpty()) {
                lines[i] = "Project: " + SelectProject.getValue();
            } //get the updated life cycle value if one exists
            else if (lines[i].startsWith("Life Cycle:") && LifeCycle.getValue() != null && !LifeCycle.getValue().isEmpty()) {
                lines[i] = "Life Cycle: " + LifeCycle.getValue();
            } //get the updated effort category value if one exists
            else if (lines[i].startsWith("Effort Category:") && EffortCategory.getValue() != null && !EffortCategory.getValue().isEmpty()) {
                lines[i] = "Effort Category: " + EffortCategory.getValue();
            } //get the updated plan value if one exists
            else if (lines[i].startsWith("Plan:") && Plan.getValue() != null && !Plan.getValue().isEmpty()) {
                lines[i] = "Plan: " + Plan.getValue();
            }
             
        }
        
        if (startTime != null && endTime != null) {
            long duration = ChronoUnit.SECONDS.between(startTime, endTime); //calculate the time between the start and stop times
            String elapsedTime = formatDuration(duration); //format the elapsed time
            for (int i = 0; i < lines.length; i++) {
                if (lines[i].startsWith("Total time elapsed:")) {
                    lines[i] = "Total time elapsed: " + elapsedTime; //edit the elapsed time line
                    break;
                }
            }
        }

        return String.join("\n", lines);
    }
    
    private String formatDuration(long durationInSeconds) {
        long hours = durationInSeconds / 3600;
        long minutes = (durationInSeconds % 3600) / 60;
        long seconds = durationInSeconds % 60;
        
        return hours + " hours, " + minutes + " minutes, " + seconds + " seconds";
    }

    private void refreshChoiceBox() {
    	//get updated log
        List<String> updatedData = readDataFromFile("data.txt");
        //add none as an option
        updatedData.add(0, "None Selected");
        //reset the choice box
        SelectEffortLogEntry.setItems(FXCollections.observableArrayList(updatedData));
    }


    @FXML
    private void onClearEffortLogButtonClick(ActionEvent event) {
    	// Clear the file content
        clearDataFile("data.txt");

        // Reset the ChoiceBox with only "None Selected"
        SelectEffortLogEntry.getItems().clear();
        SelectEffortLogEntry.getItems().add("None Selected");
        SelectEffortLogEntry.setValue("None Selected");

        // Clear other fields and selections as needed
        SelectProject.getSelectionModel().clearSelection();
        Date.clear();
        StartTime.clear();
        StopTime.clear();
        LifeCycle.getSelectionModel().clearSelection();
        EffortCategory.getSelectionModel().clearSelection();
        Plan.getSelectionModel().clearSelection();
    }
    
    private void clearDataFile(String fileName) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Write an empty string 
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception 
        }
		
	}

	public void initialize() {
        System.out.println("Initializing...");
        //initialize the select project choice box
        SelectProject.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));

        List<String> dataFromFile = null;
		dataFromFile = readDataFromFile("data.txt");
        dataFromFile.add(0, "None Selected"); // Add "None Selected" as the first option
        refreshChoiceBox();
        System.out.println("after choice box refresh");
        //intitalize the choice boxes
        SelectEffortLogEntry.setItems(FXCollections.observableArrayList(dataFromFile));

        LifeCycle.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding", "Verifying",
                "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"));
        EffortCategory.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
        Plan.setItems(FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan",
                "Implementation Plan"));
    }
   
}