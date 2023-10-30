import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class TutorialController {

    private TabPane tutorialTabs;

    private Button exitButton;

    public void initialize() {
    	
    }

    private void close(ActionEvent event) {
        System.exit(0);
    }

	public TabPane getTutorialTabs() {
		return tutorialTabs;
	}

	public void setTutorialTabs(TabPane tutorialTabs) {
		this.tutorialTabs = tutorialTabs;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public void setExitButton(Button exitButton) {
		this.exitButton = exitButton;
	}
}
