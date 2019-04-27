package cz.tul.rdb.controller;

import cz.tul.rdb.model.Exporter;
import cz.tul.rdb.model.Parser;
import java.io.File;
import java.io.InvalidClassException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;

public class Controller {
  @FXML
  Button loadBtn;
  @FXML
  Button exportBtn;
  @FXML
  Label resultLabel;

  //CheckBox for data markup choice when loading CSV (we dont always want to markup data :-))
  @FXML
  CheckBox choice;

  @Autowired
  private Parser parser;
  @Autowired
  private Exporter exp;

  @FXML
  public void onLoadBtnClick(ActionEvent actionEvent) throws InvalidClassException {

    /*
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV (*.csv)", "*.csv");
    fileChooser.getExtensionFilters().add(extFilter);

    File selectedFile = fileChooser.showOpenDialog(null);
     */
    DirectoryChooser directoryChooser = new DirectoryChooser();
    directoryChooser.setTitle("Choose directory with database files");
    File selectedDirectory = directoryChooser.showDialog(null);
    if(selectedDirectory != null) {
      boolean result = parser.parse(selectedDirectory);
      resultLabel.setText(result ? "Naše data" : "Cizí data");
    }
    /*
    if (selectedFile != null) {
      boolean result = parser.parse(selectedFile);
      resultLabel.setText(result ? "Naše data" : "Cizí data");
    }
    */
  }

  public void onExportBtnClick(ActionEvent actionEvent) {
      DirectoryChooser directoryChooser = new DirectoryChooser();
      directoryChooser.setTitle("Choose directory with database files");
      File selectedDirectory = directoryChooser.showDialog(null);
      if(selectedDirectory != null) {
          boolean result = exp.export(selectedDirectory);
          resultLabel.setText(result ? "Vygenerováno" : "Chyba");
      }
  }

}
