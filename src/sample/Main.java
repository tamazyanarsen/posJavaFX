package sample;

import com.supermax.javapos.service.SuperScan;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jpos.BaseControl;
import jpos.JposException;
import jpos.config.simple.SimpleEntry;
import jpos.config.simple.xml.SimpleXmlRegPopulator;
import jpos.events.*;
import jpos.services.EventCallbacks;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 300, 275));
//        GridPane root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setScene(new Scene(root, 300, 275));


//        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
