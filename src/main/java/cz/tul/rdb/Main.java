package cz.tul.rdb;

import cz.tul.rdb.configuration.DBConfiguration;
import cz.tul.rdb.dao.JizdaDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

  private static final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfiguration.class);

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
    loader.setControllerFactory(applicationContext::getBean);

    Parent root = loader.load();
    primaryStage.setTitle("RDB projekt");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }
}
