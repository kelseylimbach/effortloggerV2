package application;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
//import javafx.collections.FXCollections;

public class MainScreenController {

    @FXML
    private ChoiceBox<String> projectChoiceBox;
    private ChoiceBox<String> lifeCycleBox;

    @FXML
    public void initialize() {
    	System.out.println("Initializing...");
    	 projectChoiceBox.setItems(FXCollections.observableArrayList("Option A", "Option B", "Option C"));
    	 
    }
    

}
