/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlistview2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author karim
 */
public class JavaFXListView2 extends Application {
      

    @FXML
    private Button ltor;

    @FXML
    private Label label;

    
    
    private final TableView<Person> table1 = new TableView<Person>();
    private final ObservableList<Person> data;

    public JavaFXListView2() {
        this.data = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
        );
    }
    
    
    @Override
    public void start(Stage primaryStage) {

        ObservableList<String> items1 = FXCollections.observableArrayList("text1", "text2", "tesx3", "text4", "text5");
        ObservableList<String> items2 = FXCollections.observableArrayList("text1", "text2", "tesx3", "text4", "text5");

        //-----------------------for listview 1---------------------
        Button ltor = new Button(">>>");
        Button rtol = new Button("<<<");
        Button add = new Button("ADD");
        Button delete = new Button("DELETE");
        // Button update = new Button("UPDATE");
        TextField additem = new TextField();

        //----------------------- for listview 2 ---------------------
        Button add2 = new Button("ADD");
        Button delete2 = new Button("DELETE");
        // Button update2 = new Button("UPDATE");
        TextField additem2 = new TextField();

        System.out.println();

        ListView<String> listview1 = new ListView<>(items1);
        ListView<String> listview2 = new ListView<>(items2);

        //----------------------Left to Right Shift ----------------------
        ltor.setOnAction((ActionEvent event) -> {
            String item = listview1.getSelectionModel().getSelectedItem();
            
            //selectedItems =  listview1.getSelectionModel().getSelectedItems();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //for(int n=0;n<5;n++)
            //{
            //listview2.getItems().add(listview1.getItems().get(n));
            listview2.getItems().add(item);
            //System.out.println(listview1.getItems().get(0));
        });

        //----------------------Right to Left Shift ----------------------
        rtol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String item = listview2.getSelectionModel().getSelectedItem().toString();

                //selectedItems =  listview1.getSelectionModel().getSelectedItems();
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                //for(int n=0;n<5;n++)
                //{
                //listview2.getItems().add(listview1.getItems().get(n));
                listview1.getItems().add(item);
                //System.out.println(listview1.getItems().get(0));
            }
        });

        //----------------------Add new in list view 1 ----------------------
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //ObservableList<String> items1 = FXCollections.observableArrayList();
                //listview1.addtoList();
                String userInput = additem.getText();//Shouldn't this get the input from the TextField? 
                listview1.getItems().addAll(userInput);

            }

        });

        //----------------------Add new in list view 2 ----------------------
        add2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //ObservableList<String> items1 = FXCollections.observableArrayList();
                //listview1.addtoList();
                String userInput = additem2.getText();//Shouldn't this get the input from the TextField? 
                listview2.getItems().addAll(userInput);

            }

        });

        //----------------------delete from list view 1 ----------------------
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final int selectedIdx = listview1.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    String itemToRemove = listview1.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx
                            = (selectedIdx == listview1.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

                    listview1.getItems().remove(selectedIdx);
                    listview1.getSelectionModel().select(newSelectedIdx);

                }

            }

        });

        //----------------------delete from list view 2 ----------------------
        delete2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final int selectedIdx = listview2.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {
                    String itemToRemove = listview2.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx
                            = (selectedIdx == listview2.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

                    listview2.getItems().remove(selectedIdx);
                    listview2.getSelectionModel().select(newSelectedIdx);

                }

            }

        });

        //----------------------update item in list view 1 ----------------------
        listview1.setEditable(true);
        listview1.setCellFactory(TextFieldListCell.forListView());

        //----------------------update item in list view 2 ----------------------
        listview2.setEditable(true);
        listview2.setCellFactory(TextFieldListCell.forListView());

//===============================================================================================================
//=================================================================================================================
        //-------------------------table view-----------------------------------
        //TextField adddata = new TextField();
        //Button add3 = new Button("Add");
        //Button delete3 = new Button("Delete");
        table1.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));

        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override

            public void handle(CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(
                        
                        t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        }
        );

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName"));

        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override

            public void handle(CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(
                        
                        t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        }
        );

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email"));

        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Person, String>>() {
            @Override

            public void handle(CellEditEvent<Person, String> t) {

                ((Person) t.getTableView().getItems().get(
            
                        t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        }
        );

        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button add3 = new Button("Add");
        add3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                data.add(new Person(
                        addFirstName.getText(),
                        addLastName.getText(),
                        addEmail.getText()));
            }
        });

        Button delete3 = new Button("Delete");
        delete3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final int selectedIdx = table1.getSelectionModel().getSelectedIndex();
                if (selectedIdx != -1) {

                    Person itemToRemove = table1.getSelectionModel().getSelectedItem();

                    final int newSelectedIdx
                            = (selectedIdx == table1.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;

                    table1.getItems().remove(selectedIdx);

                    table1.getSelectionModel().select(newSelectedIdx);

                }

            }
        });
        
        table1.setItems(data);

        table1.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        
        TextField textField = new TextField();
        ChoiceBox<String> choicebox = new ChoiceBox();
        //Button search = new Button("Search");
       // String s = new String(addFirstName.getText());
        
        FilteredList<Person> flPerson = new FilteredList(data, p -> true);//Pass the data to a filtered list
                table1.setItems(flPerson);//Set the table's items using the filtered list
                table1.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

                //Adding ChoiceBox and TextField here!
              
                choicebox.getItems().addAll("First Name", "Last Name", "Email");
                choicebox.setValue("First Name");

               
                textField.setPromptText("Search here!");
                textField.setOnKeyReleased(keyEvent
                        -> {
                    switch (choicebox.getValue())//Switch on choiceBox value
                    {
                        case "First Name":
                            flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                            break;
                        case "Last Name":
                            flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                            break;
                        case "Email":
                            flPerson.setPredicate(p -> p.getEmail().toLowerCase().contains(textField.getText().toLowerCase().trim()));//filter table by first name
                            break;
                    }
                });

        //search.setOnAction(new EventHandler<ActionEvent>() {
            
            
            //@Override
            //public void handle(ActionEvent event) {
                //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                
              
            choicebox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                        -> {//reset table and textfield when new choice is selected
                    if (newVal != null) {
                        textField.setText("");
                        flPerson.setPredicate(null);//This is same as saying flPerson.setPredicate(p->true);
                    }
                });
            
        //});

        
        VBox shiftbtns = new VBox(ltor, rtol);

        HBox forlistview1_1 = new HBox(additem, add, delete);

        VBox forlistview1_2 = new VBox(forlistview1_1, listview1);

        HBox forlistview2_1 = new HBox(additem2, add2, delete2);

        VBox forlistview2_2 = new VBox(forlistview2_1, listview2);

        HBox fortable1_1 = new HBox(addFirstName, addLastName, addEmail, add3, delete3);//, search);

        VBox fortable1_2 = new VBox(fortable1_1, table1);

        
        HBox hBox = new HBox(choicebox, textField);
        
        HBox root = new HBox(forlistview1_2, shiftbtns, forlistview2_2, fortable1_2,hBox);

        Scene scene = new Scene(root);

        primaryStage.setTitle("ListView");

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public static class Person {

        static void setItems(SortedList<Person> sortedList) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;

        private Person(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String fName) {
            firstName.set(fName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String fName) {
            lastName.set(fName);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fName) {
            email.set(fName);
        }

        private int getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        Object getNom() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
