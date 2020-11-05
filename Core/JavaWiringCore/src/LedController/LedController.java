package LedController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class LedController extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainView.fxml")));
        Scene scene = new Scene(root, 310, 60);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("LED Controller");
        primaryStage.show();
    }
}
