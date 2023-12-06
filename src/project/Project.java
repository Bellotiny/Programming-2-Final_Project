/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author 2255525
 */
public class Project extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    /**
     *
     * @param primaryStage
     */
    // 2 start methods for a scene change
    // and to not have too much code packed in 1 method
    @Override
    public void start(Stage primaryStage) {
        //Instantiation of accounts, customers and atm
        Chequing account1 = new Chequing(3000);
        Savings account2 = new Savings(5000);
        Customer client1 = new Customer("Sen", "1223", "321", account1);
        Customer client2 = new Customer("John", "4556", "654", account2);

        //Instantiated an ArrayList to be later used in atm's ArrayList
        ArrayList<Customer> cutomers = new ArrayList();
        cutomers.add(client1);
        cutomers.add(client2);
        ATM atm = new ATM(cutomers);

        primaryStage.setTitle("Welcome Customer");

        GridPane beforegrid = new GridPane();
        beforegrid.setAlignment(Pos.CENTER);
        beforegrid.setHgap(10);
        beforegrid.setVgap(10);
        beforegrid.setPadding(new Insets(25, 25, 25, 25));
        Scene beforescene = new Scene(beforegrid, 375, 325);
        primaryStage.setScene(beforescene);

        Button cheque = new Button("Chequing");
        Button save = new Button("Savings");
        beforegrid.add(cheque, 1, 1);
        beforegrid.add(save, 3, 1);

        Button[] btns = {cheque, save};

        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 375, 325);

        for (Button i : btns) {
            i.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    primaryStage.setScene(scene);
                }
            });
        }
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tamoha", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Bank number:");
        grid.add(userName, 0, 1);

        //Text field to input the bank number
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Pin:");
        grid.add(pw, 0, 2);

        //Password type text field to input the pin is used
        //since this class of textfield can conceal text
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Sign in button
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //Text to indicate correct or invalid password
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        //If correct bank number and pin entered
        //then start method will stop and implement method "start2"
        //if invalid then dispays "Bank number not found or incorrect pin"
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    int index = atm.s.verificationOfCustomer(userTextField.getText());
                if (atm.s.validation(userTextField.getText(), pwBox.getText())) {
                    primaryStage.close();
                    start2(atm.getCustomers().get(index), atm);
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Incorrect pin");
                }
                }catch(IllegalValidation t){
                actiontarget.setText(t.getMessage());}
            }
        });
        
        primaryStage.show();
    }

    /**
     *
     * @param client
     * @param atm
     */
    //start2 method takes a client and atm
    //since customers and atm were already made
    public void start2(Customer client, ATM atm) {
        Stage secondaryStage = new Stage();

        secondaryStage.setTitle("Welcome Customer");

        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(grid, 455, 500);
        Scene scene2 = new Scene(grid2, 455, 500);
        secondaryStage.setScene(scene);

        Text scenetitle = new Text("Welcome " + client.getName());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        grid.add(scenetitle, 5, 5, 1, 1);

        Label balc = new Label("Current Balance: ");
        grid.add(balc, 5, 6);

        //Text displaying customer's balance
        Label getBalance1 = new Label(client.getAccount().toString());
        getBalance1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
        grid.add(getBalance1, 5, 7);

        //Intantiation of buttons to deposit and withdraw
        Button btnDeposit = new Button("Deposit");
        Button btnWithdraw = new Button("Withdraw");
        Button btnFinish = new Button("Finish");

        TextField amount = new TextField();
        grid.add(amount, 5, 9);

        HBox hbBtn = new HBox(15);
        hbBtn.getChildren().addAll(btnDeposit, btnWithdraw);
        hbBtn.setAlignment(Pos.BOTTOM_CENTER);
        grid.add(hbBtn, 5, 10);

        //Text to display how much was withdrawn or depositted
        final Text actiontarget = new Text();
        VBox vbtn = new VBox();
        vbtn.getChildren().add(btnFinish);
        vbtn.getChildren().add(actiontarget);
        grid.add(vbtn, 5, 12);

        /*The 2 buttons will call atm's deposit/withdraw method
        they change displayed balance to the new one
        and display the amount withdrawn or depositted*/
        btnDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                atm.deposit(client, Double.parseDouble(amount.getText()));
                getBalance1.setText(client.getAccount().toString());
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("You have depositted $ " + Double.parseDouble(amount.getText()));
            }
        });
        btnWithdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                    atm.withdraw(client, Double.parseDouble(amount.getText()));
                    getBalance1.setText(client.getAccount().toString());
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("You have withdrawn $ " + Double.parseDouble(amount.getText()));
                }catch (IllelegalAmountException t){
                    actiontarget.setText(t.getMessage());
                }
                
                /*getBalance1.setText(client.getAccount().toString());
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("You have withdrawn $ " + Double.parseDouble(amount.getText()));*/
            }
        });
        btnFinish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                secondaryStage.setScene(scene2);
            }
        });
        
        grid2.setHgap(20);
        grid2.setVgap(20);
        grid2.setAlignment(Pos.CENTER);
        grid2.setPadding(new Insets(30, 30, 30, 30));
        
        Text scenetitleFinish = new Text("Good-Bye!");
        scenetitleFinish.setFont(Font.font("Aerial", FontWeight.NORMAL, 30));
        grid2.add(scenetitleFinish, 0, 0);

        secondaryStage.show();
    }
}
