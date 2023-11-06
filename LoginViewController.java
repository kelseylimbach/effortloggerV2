package application;
//Written by Saachi Mota
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.Node;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class LoginViewController {
    private Scene scene;
    private Stage stage;
    private Login login = new Login();

    private boolean isNewUser = true;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    @FXML
    private Label welcomeMessage; 

    public void submitLogin(ActionEvent event) throws IOException {
        if (isNewUser) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (!containsUpperCase(password)) {
                errorMessage.setText("Password does not meet the requirements.");
                return;
            }

            login.setName(username);
            login.setPassword(password);
            isNewUser = false;
        } else {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (!validateUser(username, password)) {
                errorMessage.setText("Wrong password. Please try again.");
                return;
            }
        }

        errorMessage.setText("testing");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/DisplayPage.fxml"));
        errorMessage.setText("testing after");

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        errorMessage.setText("new window");
        scene = new Scene(fxmlLoader.load(),900,600);

        errorMessage.setText("blah");
        stage.setTitle("Welcome to EffortLogger V2");

        //DisplayViewController control = fxmlLoader.getController();
        //control.setLogin(login);
        stage.setScene(scene);
        stage.show();
    }

    private boolean containsUpperCase(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateUser(String username, String password) {
        return "demoUser".equals(username) && "Password123".equals(password);
    }
}