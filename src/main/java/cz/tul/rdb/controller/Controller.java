package cz.tul.rdb.controller;

import cz.tul.rdb.model.Parser;
import java.io.File;
import java.io.InvalidClassException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
  @FXML
  Button loadBtn;
  @FXML
  Button exportBtn;
  @FXML
  Label resultLabel;

  @Autowired
  private Parser parser;

  @FXML
  public void onLoadBtnClick(ActionEvent actionEvent) throws InvalidClassException {

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
