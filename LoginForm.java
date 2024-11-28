package com.company.demo3;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class LoginForm extends Application {

    @Override
    public void start(Stage primaryStage) {

        ImageView imageView = null;
        try {
            Image image = new Image("file:D:/images.png");
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
        
        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        Button exitButton = new Button("Exit");

        Label messageLabel = new Label();

        VBox layout = new VBox(10);
        if (imageView != null) {
            layout.getChildren().add(imageView);
        }
        layout.getChildren().addAll(userLabel, usernameField, passLabel, passwordField, loginButton, exitButton, messageLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20; -fx-font-size: 14;");

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();

        loginButton.setOnAction(e -> {
            String enteredUsername = usernameField.getText().trim();
            String enteredPassword = passwordField.getText().trim();


            if (enteredUsername.isEmpty() || enteredPassword.isEmpty()) {
                messageLabel.setText("Username and Password cannot be empty!");
                messageLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            if (validateCredentials(enteredUsername, enteredPassword)) {

                showWelcomeWindow(enteredUsername);
                primaryStage.close();
            } else {
                messageLabel.setText("Incorrect username or password!");
                messageLabel.setStyle("-fx-text-fill: red;");
            }
        });

        exitButton.setOnAction(e -> primaryStage.close());
    }

    private boolean validateCredentials(String username, String password) {
        try (Scanner scanner = new Scanner(new File("credentials.txt"))) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Credentials file not found.");
        }
        return false;
    }

    private void showWelcomeWindow(String username) {
        Stage welcomeStage = new Stage();
        Label welcomeLabel = new Label("Welcome, " + username + "!");
        welcomeLabel.setStyle("-fx-font-size: 18; -fx-text-fill: green;");
        VBox layout = new VBox(10, welcomeLabel);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 300, 200);
        welcomeStage.setTitle("Welcome");
        welcomeStage.setScene(scene);
        welcomeStage.show();
    }

    public static void main(String[] args) {

        saveSampleCredentials();
        launch(args);
    }
    private static void saveSampleCredentials() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("credentials.txt", false))) {
            writer.println("user1,password123");
            writer.println("user2,password456");
        } catch (IOException e) {
            System.out.println("Error writing credentials to file: " + e.getMessage());
        }
    }
}








