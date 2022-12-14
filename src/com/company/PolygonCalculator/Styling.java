package com.company.PolygonCalculator;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Styling {
    public static void drawVectors(Line name, double startX, double startY, double endX, double endY){
        name.setStartX(startX);
        name.setStartY(startY);
        name.setEndX(endX);
        name.setEndY(endY);
    }
    public static void styleButtons(Button name, double posX, double posY, String cssStyle){
        name.setLayoutX(posX);
        name.setLayoutY(posY);
        name.setStyle(cssStyle);
    }
    public static void styleButtons(Button name, double posX, double posY){
        name.setLayoutX(posX);
        name.setLayoutY(posY);
    }
    public static void styleButtons(Button name, String text, String cssStyle){
        name.setText(text);
        name.setStyle(cssStyle);
    }
    public static void styleCircles(Circle name, double posX, double posY){
        name.setLayoutX(posX);
        name.setLayoutY(posY);
    }
    public static void styleLineIdentifiers(Label name, double posX, double posY, Paint color){
        name.setLayoutX(posX);
        name.setLayoutY(posY);
        name.setTextFill(color);
    }
    public static void styleLabels(Label name, Font font, double posX, double posY){
        name.setFont(font);
        name.setLayoutX(posX);
        name.setLayoutY(posY);
    }
    public static void styleTextBoxes(TextField textFieldBoxes, String promptText, boolean traverse, double posX, double posY){
        textFieldBoxes.setPromptText(promptText);
        textFieldBoxes.setFocusTraversable(traverse);
        textFieldBoxes.setLayoutX(posX);
        textFieldBoxes.setLayoutY(posY);
    }
    public static void styleStage(Stage stage, Scene scene, String title, Boolean resizability){
        stage.setScene(scene);
        stage.setResizable(resizability);
        stage.setTitle(title);
    }
}
