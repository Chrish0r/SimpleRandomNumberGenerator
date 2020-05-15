package version1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // setting up container
        GridPane root = new GridPane();
        //root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        // nodes
        Label label = new Label("Enter Your Values Below...");
        label.setTextFill(Color.GREEN);
        label.setStyle("-fx-font: 14 Arial");
        root.add(label, 0 , 0);

        Label fromLabel = new Label("FROM");
        root.add(fromLabel, 0 , 1 );
        Label toLabel = new Label("TO");
        root.add(toLabel, 0, 3);

        TextField minInput = new TextField("Start Number...");
        root.add(minInput, 0, 2);
        TextField maxInput = new TextField("End Number...");
        root.add(maxInput, 0, 4);

        Label randomNumberLabel = new Label("");
        root.add(randomNumberLabel, 2,2);

        Button generateButton = new Button("Generate");
        generateButton.setPrefSize(70,20);
        root.add(generateButton, 0, 6);

        Button clearButton = new Button("Clear");
        clearButton.setPrefSize(generateButton.getPrefWidth(), generateButton.getPrefHeight());
        root.add(clearButton, 1, 6);

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(generateButton.getPrefWidth(), generateButton.getPrefHeight());
        root.add(exitButton, 3, 0);



        // EventHandling
        generateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) throws NumberFormatException {

                if(minInput.getText() != null && !maxInput.getText().isEmpty()) {
                    try {
                        Label label = new Label("Enter Your Values Below...");
                        label.setTextFill(Color.GREEN);
                        Random random = new Random();
                        String lowString = minInput.getText();
                        int low = Integer.parseInt(lowString);
                        String highString = maxInput.getText();
                        int high = Integer.parseInt(highString);
                        high = high +1;

                        if(high > low) {
                            int randomNumber = random.nextInt(high - low) + low;
                            String randomNumberString = Integer.toString(randomNumber);
                            System.out.println(randomNumber);
                            randomNumberLabel.setText(randomNumberString);
                        } else {
                            label.setText("First Number Must Be Lower!");
                            label.setTextFill(Color.RED);
                        }

                    } catch (NumberFormatException nfe) {
                        label.setText("Please Enter Whole Numbers!");
                        label.setTextFill(Color.RED);
                    }

                } else {
                    label.setTextFill(Color.RED);
                }
            }
        });

        clearButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                minInput.clear();
                maxInput.clear();
                randomNumberLabel.setText("");
            }
        });

        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });

        // scence
        primaryStage.setTitle("Random Number Generator");
        primaryStage.setScene(new Scene(root, 360, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
