package sample;


import com.supermax.javapos.service.SuperScan;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import jpos.BaseControl;
import jpos.JposException;
import jpos.config.simple.SimpleEntry;
import jpos.config.simple.xml.SimpleXmlRegPopulator;
import jpos.events.*;
import jpos.services.EventCallbacks;

public class Controller {
    @FXML
    private Button btnOpen, btnEnabled, btnClaim;

    private SuperScan superScan = new SuperScan();


    @FXML
    public void initialize() {
        SimpleEntry simpleEntry = new SimpleEntry(new SimpleXmlRegPopulator());
        superScan.setJposEntry(simpleEntry);

        GridPane gridPane = new GridPane();
        btnOpen.setOnMouseClicked(event -> {
            System.out.println("openBtn clicked. Start open function");
            try {
                superScan.open("DL-Portal-Scanner", new EventCallbacks() {
                    @Override
                    public void fireDataEvent(DataEvent dataEvent) {
                        System.out.println("data event: " + dataEvent.toString());
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
                btnOpen.setText("Закрыть");
            } catch (JposException e) {
                e.printStackTrace();
            }
        });

        btnClaim.setOnMouseClicked(event -> {
            try {
                superScan.claim(1000);
                btnClaim.setText("Освободить");
            } catch (JposException e) {
                e.printStackTrace();
                btnClaim.setText("Занять");
            }
        });

        btnEnabled.setOnMouseClicked(event -> {
            try {
                boolean value = superScan.getDeviceEnabled();
                if (value) btnEnabled.setText("Отключить");
                else btnEnabled.setText("Включить");
                superScan.setDeviceEnabled(!value);
            } catch (JposException e) {
               e.printStackTrace();
            }
        });

//        btnOpen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                btnOpen.setText("Закрыть");
//            }
//        });
    }
}
