package application;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javafx.collections.*;

import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class DisplayViewController {
	@FXML
	private ChoiceBox<String> projectChoiceBox;
	@FXML
	private ChoiceBox<String> lifeCycleBox;
	@FXML
	private ChoiceBox<String> effortBox1;
	@FXML
	private ChoiceBox<String> effortBox2;
	@FXML
    private Label clockStatusLabel;

	@FXML
	private Label loginSuccessLabel; // New label for login success

	 private LocalDateTime startTime;
	 private LocalDateTime endTime;
	 private Login login;
	 private String selectedProject, selectedLifeCycle, selectedEffortBox1, selectedEffortBox2;
	 private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a M/d/yyyy");



	 @FXML
	    private void onStartActivityButtonClick() {
		 	startTime = LocalDateTime.now(); // Capture the start time
	        clockStatusLabel.setText("Clock is Running");
	        clockStatusLabel.setStyle("-fx-text-fill: white; -fx-background-color: green; -fx-padding: 10;");
	        clockStatusLabel.setFont(new Font(14));
	    }

	    @FXML
	    private void onStopActivityButtonClick() {
	        clockStatusLabel.setText("Clock is stopped");
	        clockStatusLabel.setStyle("-fx-text-fill: white; -fx-background-color: red; -fx-padding: 10;");
	        clockStatusLabel.setFont(new Font(14));
	    	 endTime = LocalDateTime.now();
	         clockStatusLabel.setText("Clock is stopped");
	         clockStatusLabel.setStyle("-fx-text-fill: white; -fx-background-color: red; -fx-padding: 10;");
	         writeActivityLog();
	    }

	    private void writeActivityLog() {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a M/d/yyyy");
	        String startFormatted = startTime.format(formatter);
	        String endFormatted = endTime.format(formatter);
	        Duration duration = Duration.between(startTime, endTime);

	        long seconds = duration.getSeconds();
	        long absSeconds = Math.abs(seconds);
	        String elapsedTime = String.format(
	            "%d days, %d hours, %d minutes, %d seconds",
	            absSeconds / 86400,
	            (absSeconds % 86400) / 3600,
	            ((absSeconds % 86400) % 3600) / 60,
	            (absSeconds % 60));
	        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
	            out.println("***");
	            out.println("User: " + login.getName());
	            out.println("Activity Started: " + startFormatted);
	            out.println("Activity Ended: " + endFormatted);
	            out.println("Total time elapsed: " + elapsedTime);
	            out.println("Project: " + selectedProject);
	            out.println("Life Cycle: " + selectedLifeCycle);
	            out.println("Effort Category: " + selectedEffortBox1);
	            out.println("Effort Category 2: " + selectedEffortBox2);
	            out.println("***");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	 @FXML
	    private void onELEditorButtonClick() throws IOException {
	        // Load the FXML file for the Effort Log Editor Page
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortLogEditorPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onTutorialButtonClick() throws IOException {
	        // Load the FXML file 
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("Tutorial.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onEffortDefectLogButtonClick() throws IOException {
	        // Load the FXML file 
		 System.out.println("Loading Effort & defect log console...");
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("EffortDefectLogs.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("Finished loading Effort & defect log console...");
	    }
	 @FXML
	    private void onDefinitionButtonClick() throws IOException {
	        // Load the FXML file
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("DefinitionsPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	    }
	 @FXML
	    private void onDefectLogConsoleButtonClick() throws IOException {
	        // Load the FXML file
		 System.out.println("Loading defect log console...");
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("DefectLogConsolePage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("Finished loading defect log console...");
	    }
	 
	 @FXML
	  private void onPlanningPokerDashboardButtonClick() throws IOException {
	        // Load the FXML file
		 System.out.println("Loading planning poker console...");
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlanningPokerPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("Finished loading planning poker console...");
	    }
	 
	 @FXML
	  private void onManagerDashboardButtonClick() throws IOException {
	        // Load the FXML file
		 System.out.println("Loading manager console...");
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManagerDashboardPage.fxml"));
	        Parent root = loader.load();
	        
	        // Get the current stage (window)
	        Stage stage = (Stage) projectChoiceBox.getScene().getWindow();
	        
	        // Create a new scene with the loaded FXML root
	        Scene scene = new Scene(root);
	        
	        // Set the new scene to the current stage
	        stage.setScene(scene);
	        stage.show();
	        System.out.println("Finished loading manager console...");
	    }
	@FXML
	public void initialize() {
		System.out.println("Initializing...");
		projectChoiceBox.setItems(FXCollections.observableArrayList("Business Project", "Development Project"));
		 	lifeCycleBox.setItems(FXCollections.observableArrayList("Planning", "Information Gathering", "Information Understanding",
				"Verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"));
		 	effortBox1.setItems(FXCollections.observableArrayList("Plans", "Deliverables", "Interruptions", "Defects", "Others"));
		 	effortBox2.setItems(FXCollections.observableArrayList("Project Plan", "Risk Management Plan", "Conceptual Desing Plan",
				 "Detailed Design Plan", "Implementation Plan"));
		 	
		projectChoiceBox.setOnAction(event->{
			selectedProject = projectChoiceBox.getValue();
		});
		
		lifeCycleBox.setOnAction(event->{
			selectedLifeCycle = lifeCycleBox.getValue();
		});
		
		effortBox1.setOnAction(event->{
			selectedEffortBox1 = effortBox1.getValue();
		});
		
		effortBox2.setOnAction(event->{
			selectedEffortBox2 = effortBox2.getValue();
		});
		
	}

	public void setLogin(Login login) {
		this.login = login;

	}
}