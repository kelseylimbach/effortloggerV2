package application;
//Written by Sabrina Nelson
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class PlanningPokerPageController {

	
    @FXML
    private void onBackToConsoleButtonClick(ActionEvent event) throws IOException {
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
}