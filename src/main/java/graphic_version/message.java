package graphic_version;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

import java.util.Optional;

public class message {
    public static void warning(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    public static Pair<String, String> addWord() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Add");
        dialog.setHeaderText("New word:");

        ButtonType buttonTypeSubmit = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeSubmit, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField target = new TextField();
        target.setPromptText("Target");
        TextField definition = new TextField();
        definition.setPromptText("Definition");

        grid.add(new Label("Target"), 0, 0);
        grid.add(target, 1, 0);
        grid.add(new Label("Definition"), 0, 1);
        grid.add(definition, 1, 1);

        Node submitButton = dialog.getDialogPane().lookupButton(buttonTypeSubmit);
        submitButton.setDisable(true);

        target.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        }));
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeSubmit) {
                return new Pair<>(target.getText(), definition.getText());
            }
            return new Pair<>("", "");
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return new Pair<>("", ""); // Dialog was closed without a result
        }
    }

    public static Pair<String, String> fixWord(String word, String meaning) {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Fix");
        dialog.setHeaderText("");

        ButtonType buttonTypeSubmit = new ButtonType("Fix", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(buttonTypeSubmit, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField target = new TextField();
        target.setPromptText("New target");
        target.setText(word);
        TextField definition = new TextField();
        definition.setPromptText("New definition");
        definition.setText(meaning);

        grid.add(new Label("New Target"), 0, 0);
        grid.add(target, 1, 0);
        grid.add(new Label("New definition"), 0, 1);
        grid.add(definition, 1, 1);

        Node submitButton = dialog.getDialogPane().lookupButton(buttonTypeSubmit);
        submitButton.setDisable(target.getText().trim().isEmpty());

        target.textProperty().addListener((observableValue, oldValue, newValue) -> {
            submitButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == buttonTypeSubmit) {
                return new Pair<>(target.getText(), definition.getText());
            }
            return new Pair<>("", "");
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return new Pair<>("", ""); // Dialog was closed without a result
        }
    }

    public static boolean deleteWord() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("");
        alert.setContentText("Are you sure want to delete this word?");

        ButtonType buttonTypeYes = new ButtonType("Yes");
        ButtonType buttonTypeNo = new ButtonType("No");
        alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        alert.showAndWait();
        if (alert.getResult() == buttonTypeYes) return true;
        return false;
    }
}
