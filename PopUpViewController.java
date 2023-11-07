package application;


//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
//import javafx.collections.*;
//import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.*;
//import javafx.collections.FXCollections;
import javafx.scene.control.*;
//import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.IOException;

import javafx.animation.KeyFrame;

public class PopUpViewController {
	  	@FXML
	    private AnchorPane popupRoot;

	    @FXML
	    private Button closeButton;

	    @FXML
	    private Button stayLoggedInButton;

	    private Stage popupStage;
	    private Timeline countdownTimer;
	    private int secondsRemaining;
	    private int minutesInactive;
	    public Stage ownerStage;

	    private void closePopup() {
	        popupStage.close();
	    }

	    private void setPopup(Stage popupStage){	    	
	    	Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("PopUpPage.fxml"));
				Scene scene = new Scene(root);
		        popupStage.setScene(scene);

		        //popupStage.initModality(Modality.APPLICATION_MODAL);
		       // popupStage.initOwner(ownerStage);
		        popupStage.setTitle("Inactivity Warning");
		        //popupStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        //popupStage.setScene(scene); // Use the owner stage's scene
	    }

	    public void startInactivityTimer(Stage ownerStage) {
	    	this.ownerStage = ownerStage;
	    	Stage popupStage = new Stage();
	    	setPopup(popupStage);
	    	
	    	
	    	minutesInactive = 0;
	    			

	    		Timeline inactivityTimer = new Timeline(
	        	new KeyFrame(Duration.seconds(1), event -> {
	                //setPopupText("You've been inactive for 15 minutes. Do you want to stay logged in?");
	            	minutesInactive++;
	            	if(minutesInactive==15) {
	            		popupStage.show();
	            		startCountdownTimer(Duration.seconds(20));
	            	}
	        	})
	        );
	        inactivityTimer.setCycleCount(15);
	        inactivityTimer.play();
	    }
	    


	    private void startCountdownTimer(Duration countdownDuration) {
	        secondsRemaining = (int) countdownDuration.toSeconds();
	        countdownTimer = new Timeline(
	            new KeyFrame(Duration.seconds(1), event -> {
	                secondsRemaining--;
	                if (secondsRemaining == 0) {
	                    // User didn't click "Stay Logged In" within 60 seconds
	                    closePopup();
	                    // You can add code here to perform the logout action
	                    
	                }
	            })
	        );
	        countdownTimer.setCycleCount(secondsRemaining);
	        countdownTimer.play();
	    }

	    private void cancelCountdownTimer() {
	        if (countdownTimer != null) {
	            countdownTimer.stop();
	        }
	    }
	    @FXML
	    private void onStayLoggedInButtonClick(ActionEvent event) throws IOException {
        
//	        // Get the current stage (window)
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.close();
//	        // Create a new scene with the loaded FXML root

	    	cancelCountdownTimer();
	        
	    	
	    }
	    @FXML
	    private void onCloseButtonClick(ActionEvent event) throws IOException {
	    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml")); 
	    	Parent root = loader.load();
            
            Stage newStage = (Stage) closeButton.getScene().getWindow();

            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show(); 
	    
	    }

}
