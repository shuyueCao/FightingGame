import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.fxmlLoader;

/**
 * @author phoebegl
 * @Date 2019/3/30.
 */
public class Main extends Application {


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{

        AnchorPane root = fxmlLoader.loadPanel("start.fxml");

        stage.setTitle("战斗成长游戏");
        stage.setWidth(1080);
        stage.setHeight(760);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }
}
