package application;

//Written by Matthew Mulderink
//Implemented to Main By Sabrina Nelson


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;

public class DefinitionsPageController implements Initializable {

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
	
	
	//table1
    @FXML
	private TableView<Projects> table1;
    @FXML
    private TableColumn<Projects, String> ProjectNumberCol;
    @FXML
    private TableColumn<Projects, String> ProjectNameCol;
    @FXML
    private TableColumn<Projects, String> Step1Col;
    @FXML
    private TableColumn<Projects, String> Step2Col;
    @FXML
    private TableColumn<Projects, String> Step3Col;
    @FXML
    private TableColumn<Projects, String> Step4Col;
    @FXML
    private TableColumn<Projects, String> Step5Col;
    @FXML
    private TableColumn<Projects, String> Step6Col;  
    @FXML
    private TableColumn<Projects, String> Step7Col;    
    @FXML
    private TableColumn<Projects, String> Step8Col;    
    @FXML
    private TableColumn<Projects, String> Step9Col;    
    @FXML
    private TableColumn<Projects, String> Step10Col;    
    @FXML
    private TableColumn<Projects, String> Step11Col;    
    @FXML
    private TableColumn<Projects, String> Step12Col;    
    @FXML
    private TableColumn<Projects, String> Step13Col;    
    @FXML
    private TableColumn<Projects, String> Step14Col;    
    @FXML
    private TableColumn<Projects, String> Step15Col;    
    @FXML
    private TableColumn<Projects, String> Step16Col;    
    @FXML
    private TableColumn<Projects, String> Step17Col;    
    @FXML
    private TableColumn<Projects, String> Step18Col;    
    @FXML
    private TableColumn<Projects, String> Step19Col;    
    @FXML
    private TableColumn<Projects, String> Step20Col;    
    @FXML
    private TableColumn<Projects, String> Step21Col;    
    @FXML
    private TableColumn<Projects, String> Step22Col;    
    @FXML
    private TableColumn<Projects, String> Step23Col;    
    @FXML
    private TableColumn<Projects, String> Step24Col;    
    @FXML
    private TableColumn<Projects, String> Step25Col;

    //table2
    @FXML
    private TableView<LifeCycle> table2;
    
    @FXML
    private TableColumn<LifeCycle, String> LCNumColumn;

    @FXML
    private TableColumn<LifeCycle, String> LifeCycleStepColumn;
    
    @FXML
    private TableColumn<LifeCycle, String> EffortCategoryColumn;

    @FXML
    private TableColumn<LifeCycle, String> DefaultColumn;
    
    //table3
    @FXML
    private TableView<StepOutput> table3;
    
    @FXML
    private TableColumn<StepOutput, String> stepColumn;

    @FXML
    private TableColumn<StepOutput, String> outputColumn;
    
    //table4
    @FXML
    private TableView<StepOutput> table4;
    
    @FXML
    private TableColumn<StepOutput, String> stepColumn4;

    @FXML
    private TableColumn<StepOutput, String> outputColumn4;	
    
    //table5
    @FXML
    private TableView<StepOutput> table5;
    
    @FXML
    private TableColumn<StepOutput, String> stepColumn5;

    @FXML
    private TableColumn<StepOutput, String> outputColumn5;	
    
    //table6
    @FXML
    private TableView<StepOutput> table6;
    
    @FXML
    private TableColumn<StepOutput, String> stepColumn6;

    @FXML
    private TableColumn<StepOutput, String> outputColumn6;
    
    //table7
    @FXML
    private TableView<StepOutput> table7;
    
    @FXML
    private TableColumn<StepOutput, String> stepColumn7;

    @FXML
    private TableColumn<StepOutput, String> outputColumn7;
    
    public void projectEditHelper() {
    	ProjectNumberCol.setCellValueFactory(new PropertyValueFactory<Projects,String>("ProjectNumber"));
    	//ProjectNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	/*
    	ProjectNumberCol.setOnEditCommit(event -> {
	        Projects item = event.getRowValue();
	        item.setStep1(event.getNewValue());
	    });
	     */
    	
    	ProjectNameCol.setCellValueFactory(new PropertyValueFactory<Projects,String>("ProjectName"));
    	ProjectNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    	ProjectNameCol.setOnEditCommit(event -> {
	        Projects item = event.getRowValue();
	        item.setProjectName(event.getNewValue());
	    });
    	
    	// Step 1
    	Step1Col.setCellValueFactory(new PropertyValueFactory<Projects,String>("Step1"));
    	Step1Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step1Col.setOnEditCommit(event -> {
	        Projects item = event.getRowValue();
	        item.setStep1(event.getNewValue());
	    });
    	
    	// Step 2
    	Step2Col.setCellValueFactory(new PropertyValueFactory<Projects,String>("Step2"));
    	Step2Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step2Col.setOnEditCommit(event -> {
	        Projects item = event.getRowValue();
	        item.setStep2(event.getNewValue());
	    });
    	
    	// Step 3
    	Step3Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step3"));
    	Step3Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step3Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep3(event.getNewValue());
    	});

    	// Step 4
    	Step4Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step4"));
    	Step4Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step4Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep4(event.getNewValue());
    	});

    	// Step 5
    	Step5Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step5"));
    	Step5Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step5Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep5(event.getNewValue());
    	});
    	
    	// Step 6
    	Step6Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step6"));
    	Step6Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step6Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep6(event.getNewValue());
    	});

    	// Step 7
    	Step7Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step7"));
    	Step7Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step7Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep7(event.getNewValue());
    	});

    	// Step 8
    	Step8Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step8"));
    	Step8Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step8Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep8(event.getNewValue());
    	});

    	// Step 9
    	Step9Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step9"));
    	Step9Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step9Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep9(event.getNewValue());
    	});

    	// Step 10
    	Step10Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step10"));
    	Step10Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step10Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep10(event.getNewValue());
    	});

    	// Step 11
    	Step11Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step11"));
    	Step11Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step11Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep11(event.getNewValue());
    	});

    	// Step 12
    	Step12Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step12"));
    	Step12Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step12Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep12(event.getNewValue());
    	});

    	// Step 13
    	Step13Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step13"));
    	Step13Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step13Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep13(event.getNewValue());
    	});

    	// Step 14
    	Step14Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step14"));
    	Step14Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step14Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep14(event.getNewValue());
    	});

    	// Step 15
    	Step15Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step15"));
    	Step15Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step15Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep15(event.getNewValue());
    	});

    	// Step 16
    	Step16Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step16"));
    	Step16Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step16Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep16(event.getNewValue());
    	});

    	// Step 17
    	Step17Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step17"));
    	Step17Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step17Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep17(event.getNewValue());
    	});

    	// Step 18
    	Step18Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step18"));
    	Step18Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step18Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep18(event.getNewValue());
    	});

    	// Step 19
    	Step19Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step19"));
    	Step19Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step19Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep19(event.getNewValue());
    	});

    	// Step 20
    	Step20Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step20Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step20Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep20(event.getNewValue());
    	});
    	
    	// Step 21
    	Step21Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step21Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step21Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep21(event.getNewValue());
    	});
    	
    	// Step 22
    	Step22Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step22Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step22Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep22(event.getNewValue());
    	});
    	
    	// Step 23
    	Step23Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step23Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step23Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep23(event.getNewValue());
    	});
    	
    	// Step 24
    	Step24Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step24Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step24Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep24(event.getNewValue());
    	});
    	
    	// Step 25
    	Step25Col.setCellValueFactory(new PropertyValueFactory<Projects, String>("Step20"));
    	Step25Col.setCellFactory(TextFieldTableCell.forTableColumn());
    	Step25Col.setOnEditCommit(event -> {
    	    Projects item = event.getRowValue();
    	    item.setStep25(event.getNewValue());
    	});
    	
    }    
    
    public void lifeCycleHelper() {
        LCNumColumn.setCellValueFactory(new PropertyValueFactory<LifeCycle, String>("Step"));
    	/*
    	LCNumColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	    LCNumColumn.setOnEditCommit(event -> {
	        LifeCycle item = event.getRowValue();
	        item.setStep(event.getNewValue());
	    });	
	    */
	    
        LifeCycleStepColumn.setCellValueFactory(new PropertyValueFactory<LifeCycle, String>("LifeCycle"));
    	LifeCycleStepColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    	LifeCycleStepColumn.setOnEditCommit(event -> {
	        LifeCycle item = event.getRowValue();
	        item.setLifeCycle(event.getNewValue());
	    });	
    	
        EffortCategoryColumn.setCellValueFactory(new PropertyValueFactory<LifeCycle, String>("EffortCategory"));
    	EffortCategoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    	EffortCategoryColumn.setOnEditCommit(event -> {
	        LifeCycle item = event.getRowValue();
	        item.setEffortCategory(event.getNewValue());
	    });	
    	
        DefaultColumn.setCellValueFactory(new PropertyValueFactory<LifeCycle, String>("Default"));
    	DefaultColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    	DefaultColumn.setOnEditCommit(event -> {
	        LifeCycle item = event.getRowValue();
	        item.setDefault(event.getNewValue());
	    });	
    }
    
    public void editHelper(TableColumn<StepOutput, String> step, TableColumn<StepOutput, String> output) {
    	step.setCellValueFactory(new PropertyValueFactory<StepOutput,String>("Step"));
    	output.setCellValueFactory(new PropertyValueFactory<StepOutput,String>("Output"));
	    output.setCellFactory(TextFieldTableCell.forTableColumn());
	    output.setOnEditCommit(event -> {
	        StepOutput item = event.getRowValue();
	        item.setOutput(event.getNewValue());
	    });	
    }
    
	public void initialize(URL url, ResourceBundle rb) {
		//table1
	    //table1.setEditable(true);
	    //editHelper(stepColumn, outputColumn);
		projectEditHelper();
        ObservableList<Projects> dataT1 = FXCollections.observableArrayList(
                new Projects("1", "Business Project","17","18","19","20","21","22","23","24","25","26",
                		"","","","","","","","","","","","","","",""),
                new Projects("2", "Development Project","1","2","3","4","5","6","7","8","9","10",
                		"11","12","13","14","15","16","","","","","","","","",""),
                new Projects("3", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("4", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("5", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("6", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("7", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("8", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("9", "","","","","","","","","","","","","","","","","","","","","","","","","",""),
                new Projects("10", "","","","","","","","","","","","","","","","","","","","","","","","","","")
            );
        
        table1.setItems(dataT1);
        
        //table2
	    table2.setEditable(true);
	    lifeCycleHelper();

        ObservableList<LifeCycle> dataT2 = FXCollections.observableArrayList(
                new LifeCycle("1", "Problem Understanding", "2", "1"),
                new LifeCycle("2", "Conceptual Design Plan", "1", "3"),
                new LifeCycle("3", "Requirements", "2", "1"),
                new LifeCycle("4", "Conceptual Design Plan Review", "2", "1"),
                new LifeCycle("5", "Conceptual Design Review", "2", "1"),
                new LifeCycle("6", "Detailed Design Plan", "1", "4"),
                new LifeCycle("7", "Detailed Design/Prototype", "2", "2"),
                new LifeCycle("8", "Detailed Design Review", "2", "2"),
                new LifeCycle("9", "Implementation Plan", "1", "5"),
                new LifeCycle("10", "Test Case Generation", "2", "3"),
                new LifeCycle("11", "Solution Specification", "2", "4"),
                new LifeCycle("12", "Solution Review", "2", "4"),
                new LifeCycle("13", "Solution Implementation", "2", "4"),
                new LifeCycle("14", "Unit/System Test", "2", "4"),
                new LifeCycle("15", "Reflection", "2", "4"),
                new LifeCycle("16", "Repository Update", "2", "4"),
                new LifeCycle("17", "Planning", "1", "1"),
                new LifeCycle("18", "Information Gathering", "2", "1"),
                new LifeCycle("19", "Information Understanding", "2", "1"),
                new LifeCycle("20", "Verifying", "2", "1"),
                new LifeCycle("21", "Outlining", "2", "6"),
                new LifeCycle("22", "Drafting", "2", "7"),
                new LifeCycle("23", "Finalizing", "2", "8"),
                new LifeCycle("24", "Team Meeting", "2", "1"),
                new LifeCycle("25", "Coach Meeting", "2", "1"),
                new LifeCycle("26", "Stakeholder Meeting", "2", "1"),
                new LifeCycle("27", "", "", ""),
                new LifeCycle("28", "", "", ""),
                new LifeCycle("29", "", "", ""),
                new LifeCycle("30", "", "", ""),
                new LifeCycle("31", "", "", ""),
                new LifeCycle("32", "", "", ""),
                new LifeCycle("33", "", "", ""),
                new LifeCycle("34", "", "", ""),
                new LifeCycle("35", "", "", ""),
                new LifeCycle("36", "", "", ""),
                new LifeCycle("37", "", "", ""),
                new LifeCycle("38", "", "", ""),
                new LifeCycle("39", "", "", ""),
                new LifeCycle("40", "", "", ""),
                new LifeCycle("41", "", "", ""),
                new LifeCycle("42", "", "", ""),
                new LifeCycle("43", "", "", ""),
                new LifeCycle("44", "", "", ""),
                new LifeCycle("45", "", "", ""),
                new LifeCycle("46", "", "", ""),
                new LifeCycle("47", "", "", ""),
                new LifeCycle("48", "", "", ""),
                new LifeCycle("49", "", "", ""),
                new LifeCycle("50", "", "", "")
            );
        
        table2.setItems(dataT2); 
        
        
		//table3
	    table3.setEditable(true);
	    editHelper(stepColumn, outputColumn);

        ObservableList<StepOutput> dataT3 = FXCollections.observableArrayList(
                new StepOutput("1", "Plans"),
                new StepOutput("2", "Deliverables"),
                new StepOutput("3", "Interruptions"),
                new StepOutput("4", "Defects"),
                new StepOutput("5", "Others")
            );
        
        table3.setItems(dataT3);
        
        
        //table4
	    table4.setEditable(true);
	    editHelper(stepColumn4, outputColumn4);

        ObservableList<StepOutput> dataT4 = FXCollections.observableArrayList(
                new StepOutput("1", "Project Plan"),
                new StepOutput("2", "Risk Management Plan"),
                new StepOutput("3", "Conceptual Design Plan"),
                new StepOutput("4", "Detail Design Plan"),
                new StepOutput("5", "Implementation Plan")
            );
        
        table4.setItems(dataT4);
                
        //table5
	    table5.setEditable(true);
	    editHelper(stepColumn5, outputColumn5);

        ObservableList<StepOutput> dataT5 = FXCollections.observableArrayList(
                new StepOutput("1", "Conceptual Design"),
                new StepOutput("2", "Detailed Design"),
                new StepOutput("3", "Test Cases"),
                new StepOutput("4", "Solution"),
                new StepOutput("5", "Reflection"),
                new StepOutput("6", "Outline"),
                new StepOutput("7", "Draft"),
                new StepOutput("8", "Report"),
                new StepOutput("9", "User Defined"),
                new StepOutput("10", "Other")
            );
        
        table5.setItems(dataT5);
        
		//table6
	    table6.setEditable(true);
	    editHelper(stepColumn6, outputColumn6);
	
	    ObservableList<StepOutput> dataT6 = FXCollections.observableArrayList(
	            new StepOutput("1", "Break"),
	            new StepOutput("2", "Phone"),
	            new StepOutput("3", "Teammate"),
	            new StepOutput("4", "Vistor"),
	            new StepOutput("5", "Other"),
	            new StepOutput("6", ""),
	            new StepOutput("7", ""),
	            new StepOutput("8", ""),
	            new StepOutput("9", ""),
	            new StepOutput("10", "")
	        );
	    
	    table6.setItems(dataT6);        
	
		//table7
	    table7.setEditable(true);
	    editHelper(stepColumn7, outputColumn7);
	
	    ObservableList<StepOutput> dataT7 = FXCollections.observableArrayList(
	            new StepOutput("1", "Not specified"),
	            new StepOutput("2", "10 Documentation"),
	            new StepOutput("3", "20 Syntax"),
	            new StepOutput("4", "30 Build, Package"),
	            new StepOutput("5", "40 Assignments"),
	            new StepOutput("6", "50 Interface"),
	            new StepOutput("7", "60 Checking"),
	            new StepOutput("8", "70 Data"),
	            new StepOutput("9", "80 Function"),
	            new StepOutput("10", "90 System"),
	            new StepOutput("11", "100 Environment"),
	            new StepOutput("12", ""),
	            new StepOutput("13", ""),
	            new StepOutput("14", ""),
	            new StepOutput("15", "")
	        );
	    
	    table7.setItems(dataT7);

	
    
    
	
	}
	
	
}
