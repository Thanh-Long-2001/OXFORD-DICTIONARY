package graphic_version;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class mainSceneController implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> {
            if (newTab == tabDictionary) {
                // Xử lý khi chuyển đến tab Dictionary
                System.out.println("Chuyển đến tab Dictionary");
            } else if (newTab == tabTranslate) {
                // Xử lý khi chuyển đến tab Translate
                System.out.println("Chuyển đến tab Translate");
            } else if (newTab == tabQuiz) {
                // Xử lý khi chuyển đến tab Game
                System.out.println("Chuyển đến tab Quiz");
            } else if (newTab == tabHM) {
                // Xử lý khi chuyển đến tab Setting
                System.out.println("Chuyển đến tab HangMan");
            }
        });
    }

    @FXML
    private Tab tabDictionary;

    @FXML
    private Tab tabTranslate;

    @FXML
    private Tab tabQuiz;

    @FXML
    private Tab tabHM;

    @FXML
    private TabPane tabPane;
}
