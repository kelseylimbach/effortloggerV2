package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//Written by Matthew Mulderink
//Implemented to Main By Sabrina Nelson
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DefinitionsPageController implements Initializable {

	// init
//    @FXML
//    private Label DefTitle;
//    
//    @FXML
//    private TableView<Projects> table;
//
//    @FXML
//    private TableColumn<Projects, String> ProjectNameCol;
//    
//    @FXML
//    private TableColumn<Projects, Integer> ProjectNumberCol;
//    
//    @FXML
//    private TableColumn<Projects, Integer> Step1Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step2Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step3Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step4Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step5Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step6Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step7Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step8Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step9Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step10Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step11Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step12Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step13Col;
//    
//    @FXML
//    private TableColumn<Projects, Integer> Step14Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step15Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step16Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step17Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step18Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step19Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step20Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step21Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step22Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step23Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step24Col;
//     
//    @FXML
//    private TableColumn<Projects, Integer> Step25Col;
//    
    /*
    @FXML
    private TextField ProjectName;
    
    @FXML
    private TextField ProjectNumber;
    
    @FXML
    private TextField Step1;
     
    @FXML
    private TextField Step2;
     
    @FXML
    private TextField Step3;
     
    @FXML
    private TextField Step4;
     
    @FXML
    private TextField Step5;
     
    @FXML
    private TextField Step6;
     
    @FXML
    private TextField Step7;
     
    @FXML
    private TextField Step8;
     
    @FXML
    private TextField Step9;
     
    @FXML
    private TextField Step10;
     
    @FXML
    private TextField Step11;
     
    @FXML
    private TextField Step12;
     
    @FXML
    private TextField Step13;
     
    @FXML
    private TextField Step14;
     
    @FXML
    private TextField Step15;
     
    @FXML
    private TextField Step16;
     
    @FXML
    private TextField Step17;
     
    @FXML
    private TextField Step18;
     
    @FXML
    private TextField Step19;
     
    @FXML
    private TextField Step20;
     
    @FXML
    private TextField Step21;
     
    @FXML
    private TextField Step22;
     
    @FXML
    private TextField Step23;
     
    @FXML
    private TextField Step24;
     
    @FXML
    private TextField Step25;
    */

/*
    @Override    	
    public void initialize(URL url, ResourceBundle rb) {
    	
    }
    */
    	/*
    	ProjectNumberCol.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Project Number"));
    	ProjectNameCol.setCellValueFactory(new PropertyValueFactory<Projects,String>("Project Name"));
    	Step1Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step1"));
    	Step2Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step2"));
    	Step3Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step3"));
    	Step4Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step4"));
    	Step5Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step5"));
    	Step6Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step6"));
    	Step7Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step7"));
    	Step8Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step8"));
    	Step9Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step9"));
    	Step10Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step10"));
    	Step11Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step11"));
    	Step12Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step12"));
    	Step13Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step13"));
    	Step14Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step14"));
    	Step15Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step15"));
    	Step16Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step16"));
    	Step17Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step17"));
    	Step18Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step18"));
    	Step19Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step19"));
    	Step20Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step20"));
    	Step21Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step21"));
    	Step22Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step22"));
    	Step23Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step23"));
    	Step24Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step24"));
    	Step25Col.setCellValueFactory(new PropertyValueFactory<Projects,Integer>("Step25"));
    	
    	table.setItems(getProjects());
    	*/
    	
    	// table.setEditable(true);
    	// ProjectNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	
    	/*
    	Step1Col.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>(Integer.parseUnsignedInt(Step1Col))));
    	Step2.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step3.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step4.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step5.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step6.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step7.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step8.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step9.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step10.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step11.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step12.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step13.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step14.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step15.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step16.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step17.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step18.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step19.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step20.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step21.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step22.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step23.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step24.setCellValueFactory(TextFieldTableCell.forTableColumn());
    	Step25.setCellValueFactory(TextFieldTableCell.forTableColumn());
		*/
    	/*
    }	
	*/
//	public void changeProjectName(CellEditEvent edittedCell)
//	{
//    		Projects projectSelected =  table.getSelectionModel().getSelectedItem();
//    		projectSelected.setProjectName(edittedCell.getNewValue().toString());
//	}


//    public ObservableList<Projects> getProjects() {
//        ObservableList<Projects> projects = FXCollections.observableArrayList();
//        projects.add(new Projects(1, "Business Project", 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
//		return projects;
//	}


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

	
    // init
//    @FXML
//    private TableView<StepOutput> EffortCategories;
//
//    @FXML
//    private TableColumn<StepOutput, String> ECStepCol;
//    
//    @FXML
//    private TableColumn<StepOutput, String> ECOutputCol;
//    
//	@FXML
//	private TextField ECstep;
//	
//	@FXML
//	private TextField ECoutput;
	/*
	public void changeECStep(CellEditEvent<StepOutput, String> editCell){
		StepOutput selected = (StepOutput) EffortCategories.getSelectionModel().getSelectedItem();
		selected.setStep(editCell.getNewValue().toString());
	}
	*/
	public void initialize(URL url, ResourceBundle rb) {
		/*
		  #load cols
		ECStepCol.setCellValueFactory(new PropertyValueFactory<StepOutput,String>("Step"));
		ECOutputCol.setCellValueFactory(new PropertyValueFactory<StepOutput,String>("Output"));
		
		#display list from getEC()
		EffortCategories.setItems(getEC());

		EffortCategories.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		*/
	}
	/*
    public ObservableList<StepOutput> getEC() {
        ObservableList<StepOutput> ec = FXCollections.observableArrayList();
        ec.add(new StepOutput("1", "Plans"));
		return ec;
	}
    */
}