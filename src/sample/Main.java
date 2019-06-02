package sample;

import com.supermax.javapos.service.SuperScan;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jpos.BaseControl;
import jpos.config.simple.SimpleEntry;
import jpos.config.simple.xml.SimpleXmlRegPopulator;
import jpos.events.*;
import jpos.services.EventCallbacks;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setScene(new Scene(root, 300, 275));
        GridPane gridPane = new GridPane();
        Button open = new Button("Открыть");
        open.setOnMouseClicked(event -> {
            System.out.println("get event" + event);
        });

        SuperScan superScan = new SuperScan();
        SimpleEntry simpleEntry = new SimpleEntry(new SimpleXmlRegPopulator());
        superScan.setJposEntry(simpleEntry);
        try {
            superScan.open("DL-Portal-Scanner", new EventCallbacks() {
                @Override
                public void fireDataEvent(DataEvent dataEvent) {

                }

                @Override
                public void fireDirectIOEvent(DirectIOEvent directIOEvent) {

                }

                @Override
                public void fireErrorEvent(ErrorEvent errorEvent) {

                }

                @Override
                public void fireOutputCompleteEvent(OutputCompleteEvent outputCompleteEvent) {

                }

                @Override
                public void fireStatusUpdateEvent(StatusUpdateEvent statusUpdateEvent) {

                }

                @Override
                public BaseControl getEventSource() {
                    return null;
                }
            });
        } catch (Exception e) {
            throw e;
//            e.printStackTrace();
        }

        gridPane.getChildren().add(open);
        primaryStage.setScene(new Scene(gridPane, 300, 275));
        primaryStage.setTitle("Hello World");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
