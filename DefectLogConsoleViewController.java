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
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class DefectLogConsoleViewController {

	
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
    
    @FXML
    private Label statusLabel;

    @FXML
    private ChoiceBox<String> projectPicker;

    @FXML
    private ChoiceBox<String> defectPicker;

    @FXML
    private ChoiceBox<String> fixChoiceBox;

    @FXML
    private ChoiceBox<String> stepWhenInjected;

    @FXML
    private ChoiceBox<String> stepWhenRemoved;

    @FXML
    private ChoiceBox<String> defectCategory;
    
    @FXML
    private TextArea defectSymptoms;
    
    @FXML
    private TextField defectName;
    
    

    private String selectedProjectPicker, selectedDefectName, selectedDefectPicker, selectedFixChoiceBox,
            selectedStepWhenInjected, selectedStepWhenRemoved, selectedDefectCategory, selectedDefectSymptoms;

    @FXML
    private void onCloseButtonClick() {
        statusLabel.setText("Status: closed");
        // TO-DO: add remaining functionality for when closed
    }

    @FXML
    private void onReopenButtonClick() {
        statusLabel.setText("Status: opened");
        // TO-DO: add remaining functionality for when opened
    }

    @FXML
    private void onNewDefectButtonClick(ActionEvent event) throws IOException {
        // Get the values for the selected defect
        selectedProjectPicker = projectPicker.getValue();
        selectedDefectName = defectName.getText();
		selectedDefectSymptoms = defectSymptoms.getText();
        selectedDefectPicker = "- no defect selected -".equals(defectPicker.getValue()) ? "" : defectPicker.getValue();
        selectedFixChoiceBox = fixChoiceBox.getValue();
        selectedStepWhenInjected = stepWhenInjected.getValue();
        selectedStepWhenRemoved = stepWhenRemoved.getValue();
        selectedDefectCategory = defectCategory.getValue();
        
        writeDefectToData2();
        
        onClearLogButtonClick(event);
    }

    private void writeDefectToData2()
            throws IOException {
            // Format the entry as a single string
            String entry = selectedProjectPicker + ", " + 
            selectedDefectName + ", " +
            selectedDefectSymptoms + ", " +
            selectedStepWhenInjected + ", " + 
            selectedStepWhenRemoved + ", " + 
            selectedDefectCategory;
            
        try (PrintWriter writer = new PrintWriter(new FileWriter("data2.txt", true))) {
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
    private void onUpdateDefectButtonClick(ActionEvent event) throws IOException {
    	return;
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
    private void onClearLogButtonClick(ActionEvent event) throws IOException {
        // Clear the fields
        defectPicker.setValue("- no defect selected -");
        defectName.clear();
        defectSymptoms.clear();
        fixChoiceBox.setValue(null);
        stepWhenInjected.setValue(null);
        stepWhenRemoved.setValue(null);
        defectCategory.setValue(null);
    }
    
    @FXML
    private void onDeleteCurrentDefectButtonClick(ActionEvent event) {
        String selectedEntry = defectPicker.getValue();
        if ("- no defect selected - ".equals(selectedEntry)) {
            // Handle this case as desired, e.g., show an error message.
            return;
        }

        // Read the data from the file
        List<String> dataFromFile = readDataFromFile("data2.txt");

        // Remove the selected entry
        dataFromFile.remove(selectedEntry);

        // Write the updated data back to the file
        writeDataToFile("data2.txt", dataFromFile);

        // Clear the ChoiceBox and repopulate it with the updated data
        defectPicker.getItems().clear();
        dataFromFile.add(0, "- no defect selected -");
        defectPicker.setItems(FXCollections.observableArrayList(dataFromFile));
    }
    
	 @FXML
		public void initialize() {
			System.out.println("Initializing Defect Log Console...");
			projectPicker.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
					
			List<String> dataFromFile = null;
			dataFromFile = readDataFromFile("data2.txt");
			dataFromFile.add(0, "- no defect selected - ");
			
			defectPicker.setItems(FXCollections.observableArrayList(dataFromFile));
			
			fixChoiceBox.setItems(FXCollections.observableArrayList("Item 1"));
			stepWhenInjected.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding",
					"Verifying", "Outlining"));
			stepWhenRemoved.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding",
					"Verifying", "Outlining"));
			defectCategory.setItems(FXCollections.observableArrayList("Not Specified", "10 Documentation", "20 Syntax", "30 Build Package",
					"40 Assignment", "50 Interface", "60 Checking", "70 Data", "80 Function", "90 System", "100 Environment"));
		 	
			projectPicker.setOnAction(event->{
				selectedProjectPicker = projectPicker.getValue();
			});
			
			defectPicker.setOnAction(event->{
				selectedDefectPicker = defectPicker.getValue();
			});
			
			fixChoiceBox.setOnAction(event->{
				selectedFixChoiceBox = fixChoiceBox.getValue();
			});
			
			stepWhenInjected.setOnAction(event->{
				selectedStepWhenInjected = stepWhenInjected.getValue();
			});
			
			stepWhenRemoved.setOnAction(event->{
				selectedStepWhenRemoved = stepWhenRemoved.getValue();
			});
			
			defectCategory.setOnAction(event->{
				selectedDefectCategory = defectCategory.getValue();
			});
			
			selectedDefectName = defectName.getText();
			
			selectedDefectSymptoms = defectSymptoms.getText();
			
	 }
}