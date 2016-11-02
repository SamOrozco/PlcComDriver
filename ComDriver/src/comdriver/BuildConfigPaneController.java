/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comdriver;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author samo
 */
public class BuildConfigPaneController implements Initializable {

    @FXML
    TextField plcName;

    @FXML
    ComboBox<String> pullType;

    @FXML
    TextField interval;

    @FXML
    ComboBox<String> unitOfTime;

    @FXML
    ListView<String> eventList;

    private String[] pullTypes = {"Interval", "Single", "Scheduled"};

    private String[] unitsOfTime = {"miliseconds", "seconds", "minutes", "Hours"};

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        initPullType();

        initUnitOfTime();
        
        
        
        eventList.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Text text = (Text) event.getTarget();
                System.out.println(text.getText());
                Node node = (Node) event.getPickResult().getIntersectedNode();
                
                
            }

        });
    }

    @FXML
    private void addWriteEvent() {
        String add = "Write" + (eventList.getItems().size() + 1);
        eventList.getItems().add(add);
    }

    @FXML
    private void addReadEvent() {
        String add = "Read" + (eventList.getItems().size() + 1);
        eventList.getItems().add(add);

    }

    /**
     *
     */
    private void initPullType() {
        pullType.getItems().clear();
        pullType.getItems().addAll(pullTypes);
    }

    /**
     *
     */
    private void initUnitOfTime() {
        unitOfTime.getItems().clear();
        unitOfTime.getItems().addAll(unitsOfTime);
    }
}
