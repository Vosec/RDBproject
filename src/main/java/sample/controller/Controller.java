package sample.controller;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import sample.model.Parser;

public class Controller {

  private Parser parser;

  @FXML
  Button loadBtn;
  @FXML
  Button exportBtn;
  @FXML
  Label resultLabel;

  public Controller() {
    parser = new Parser();
  }

  @FXML
  public void onLoadBtnClick(ActionEvent actionEvent) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    File selectedFile = fileChooser.showOpenDialog(null);

    if (selectedFile != null) {
      boolean result = parser.parse(selectedFile);
      resultLabel.setText(result ? "Naše data" : "Cizí data");
    }
  }

  public void onExportBtnClick(ActionEvent actionEvent) {
    //TODO
  }
}
