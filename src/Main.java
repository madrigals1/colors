import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.Random;


public class Main extends Application {

    Text txtScore, txtColor;
    Button btnYes, btnNo;
    Pane paneCenter;
    int score = 0;
    Random rand = new Random();

    String[] colors = new String[]{
            "#ff0000",
            "#00ff00",
            "#0000ff",
            "#FFA500",
            "#FFFF00",
            "#FF00FF"
    };

    String[] colorTexts = new String[]{
            "Red",
            "Green",
            "Blue",
            "Orange",
            "Yellow",
            "Magenta"
    };

    int thisColor;
    int thisText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Match colors");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        txtScore = new Text("Score : 0");
        txtColor = new Text("Color");
        btnYes = new Button();
        btnNo = new Button();
        paneCenter = new Pane();

        txtColor.setStrokeWidth(0.33);
        txtColor.setStroke(Color.BLACK);

        paneCenter.setMinSize(170,100);
        paneCenter.setLayoutX(60);
        paneCenter.setLayoutY(65);
        paneCenter.setStyle("-fx-background-color : " + colors[5]);

        txtColor.setLayoutX(75);
        txtColor.setTextAlignment(TextAlignment.CENTER);
        txtColor.setLayoutY(55);
        txtColor.setScaleX(2);
        txtColor.setScaleY(2);
        txtColor.setFill(Color.WHITE);

        txtScore.setLayoutX(120);
        txtScore.setTextAlignment(TextAlignment.CENTER);
        txtScore.setLayoutY(40);
        txtScore.setScaleX(2);
        txtScore.setScaleY(2);

        btnYes.setLayoutX(80);
        btnYes.setLayoutY(200);
        btnYes.setScaleX(2);
        btnYes.setScaleY(2);
        btnYes.setText("Yes");
        btnYes.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                pressed(true);
            }
        });
        btnYes.setStyle("-fx-background-color: linear-gradient(#00ff54, #00be1d);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");

        btnNo.setLayoutX(180);
        btnNo.setLayoutY(200);
        btnNo.setScaleX(2);
        btnNo.setScaleY(2);
        btnNo.setText("No");
        btnNo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                pressed(false);
            }
        });
        btnNo.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0;\n" +
                "    -fx-text-fill: white;");

        paneCenter.getChildren().add(txtColor);

        root.getChildren().add(btnYes);
        root.getChildren().add(btnNo);
        root.getChildren().add(txtScore);
        root.getChildren().add(paneCenter);
        primaryStage.setScene(scene);
        primaryStage.show();
        set();
    }

    public void set(){
        thisColor = rand.nextInt(6);
        thisText = rand.nextInt(6);
        paneCenter.setStyle("-fx-background-color:" + colors[thisColor]);
        txtColor.setText(colorTexts[thisText]);
    }

    public void pressed(boolean yes){
        if(yes && thisColor == thisText){
            score++;
        }
        if(!yes && thisColor != thisText){
            score++;
        }
        txtScore.setText("Score : " + score);
        set();
    }
}
