package com.company.demo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class BmiCalc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text welcomeText = new Text("Welcome to our Application");
        welcomeText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; ");

        Label userLabel = new Label("user label");
        Label passwordLabel = new Label("password label");

        TextField userNamefield = new TextField();
        PasswordField passwordField = new PasswordField();

        Button okButton = new Button();

        Button login = new Button("login");
        Button cancel = new Button("logout");

        GridPane gridPane = new GridPane();
        gridPane.add(welcomeText, 0, 0, 2, 1);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(login, cancel);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setSpacing(10);
        cancel.setOnAction(e-> stage.hide());
        gridPane.add(userLabel,0,1);
        gridPane.add(userNamefield,1,1);
        gridPane.add(passwordLabel,0,2);
        gridPane.add(passwordField,1,2);
        gridPane.add(hbox,1,3);



        Scene scene = new Scene(gridPane, 500, 400);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}
