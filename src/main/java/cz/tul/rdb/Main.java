package cz.tul.rdb;

import cz.tul.rdb.configuration.DBConfiguration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(DBConfiguration.class);
    context.refresh();

    Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
    primaryStage.setTitle("RDB projekt");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }
}
