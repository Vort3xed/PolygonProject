package com.company.PolygonCalculator;

//import wastelands
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application{

    //mouse click coordinates
    double x;
    double y;

    //Labels for triangle info
    Label areaLabel = new Label("Total Area: ");

    Label DistanceRtG = new Label("Distance Red to Green: ");
    Label DistanceGtB = new Label("Distance Green to Blue: ");
    Label DistanceBtR = new Label("Distance Blue to Red: ");


    //triangle edge tracing lines

    Label identifier = new Label("Specific Coordinates: ");
    Button submit = new Button("Submit");
    Button clear = new Button("Clear");

    TextField c1Field = new TextField();
    TextField c2Field = new TextField();
    TextField c3Field = new TextField();
    TextField c1FieldY = new TextField();
    TextField c2FieldY = new TextField();
    TextField c3FieldY = new TextField();


    public static void main(String[] args) {
        //gotta make this mf wake up right?
        Application.launch(args);
    }

    public void start(Stage stage){
        //top g
        Group g = new Group();
        com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();

        //scene styling and initialization
        Scene scene = new Scene(g, 800, 500);
        stage.setScene(scene);
        stage.setTitle("Triangle Area Calculator");
        scene.setFill(createGridPattern());
        stage.setResizable(true);
        stage.show();

        //associating e to lambda function using mouse click event
        EventHandler<MouseEvent> handler = e -> handleEvent(e);


        //attaching click handlers for stage and scene
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);


        //styling area label
        areaLabel.setFont(Font.font(null, FontWeight.BOLD,20));
        areaLabel.setLayoutX(10);
        areaLabel.setLayoutY(15);

        //distance label styling
        DistanceRtG.setFont(Font.font(20));
        DistanceRtG.setLayoutX(10);
        DistanceRtG.setLayoutY(35);

        DistanceGtB.setFont(Font.font(20));
        DistanceGtB.setLayoutX(10);
        DistanceGtB.setLayoutY(55);

        DistanceBtR.setFont(Font.font(20));
        DistanceBtR.setLayoutX(10);
        DistanceBtR.setLayoutY(75);

        //angle label styling

        identifier.setFont(Font.font(18));
        identifier.setLayoutX(450);
        identifier.setLayoutY(5);

        c1Field.setPromptText("Red Circle X");
        c1Field.setFocusTraversable(false);
        c1Field.setLayoutX(450);
        c1Field.setLayoutY(35);
        c1Field.getText();

        c2Field.setPromptText("Green Circle X");
        c2Field.setFocusTraversable(false);
        c2Field.setLayoutX(450);
        c2Field.setLayoutY(65);
        c2Field.getText();

        c3Field.setPromptText("Blue Circle X");
        c3Field.setFocusTraversable(false);
        c3Field.setLayoutX(450);
        c3Field.setLayoutY(95);
        c3Field.getText();

        c1FieldY.setPromptText("Red Circle Y");
        c1FieldY.setFocusTraversable(false);
        c1FieldY.setLayoutX(610);
        c1FieldY.setLayoutY(35);
        c1FieldY.getText();

        c2FieldY.setPromptText("Green Circle Y");
        c2FieldY.setFocusTraversable(false);
        c2FieldY.setLayoutX(610);
        c2FieldY.setLayoutY(65);
        c2FieldY.getText();

        c3FieldY.setPromptText("Blue Circle Y");
        c3FieldY.setFocusTraversable(false);
        c3FieldY.setLayoutX(610);
        c3FieldY.setLayoutY(95);
        c3FieldY.getText();

        submit.setLayoutX(450);
        submit.setLayoutY(130);
        clear.setLayoutX(510);
        clear.setLayoutY(130);


        //appending all nodes to group
        g.getChildren().addAll(
                areaLabel,DistanceRtG,DistanceGtB,DistanceBtR,identifier,
                submit,clear,c1Field,c2Field,c3Field,c1FieldY,c2FieldY,c3FieldY);


        submit.setOnAction(this::handleSubmitAction);
        clear.setOnAction(this::handleClearAction);
    }

    public void handleSubmitAction(ActionEvent event){
        /*try{
            if (!c1Field.getText().isEmpty() && !c2Field.getText().isEmpty() && !c3Field.getText().isEmpty()) {

                identifier.setText("Specific Coordinates: (Parsed)");
                c1.setLayoutX(Double.parseDouble(c1Field.getText()));

                c2.setLayoutX(Double.parseDouble(c2Field.getText()));

                c3.setLayoutX(Double.parseDouble(c3Field.getText()));

                redToGreen.setStartX(c1.getLayoutX());
                redToGreen.setStartY(c1.getLayoutY());
                redToGreen.setEndX(c2.getLayoutX());
                redToGreen.setEndY(c2.getLayoutY());

                greenToBlue.setStartX(c2.getLayoutX());
                greenToBlue.setStartY(c2.getLayoutY());
                greenToBlue.setEndX(c3.getLayoutX());
                greenToBlue.setEndY(c3.getLayoutY());

                blueToRed.setStartX(c3.getLayoutX());
                blueToRed.setStartY(c3.getLayoutY());
                blueToRed.setEndX(c1.getLayoutX());
                blueToRed.setEndY(c1.getLayoutY());

                handleCalculations(c1, c2, c3);
            } else {
                identifier.setText("Specific Coordinates: (Parse Failed)");
                c1.setLayoutX(c1.getLayoutX());
                c1.setLayoutY(c1.getLayoutY());

                c2.setLayoutX(c2.getLayoutX());
                c2.setLayoutY(c2.getLayoutY());

                c3.setLayoutX(c3.getLayoutX());
                c3.setLayoutY(c3.getLayoutY());
            }
        } catch (Exception p){
            identifier.setText("Specific Coordinates: (Non-Float Values!)");
        }*/
    }
    public void handleClearAction(ActionEvent event){
        c1Field.clear();
        c2Field.clear();
        c3Field.clear();
        c1FieldY.clear();
        c2FieldY.clear();
        c3FieldY.clear();
        identifier.setText("Specific Coordinates: ");
    }

    public ImagePattern createGridPattern() {

        //square 1 generation
        double w = 20;
        double h = 20;

        //object generation for canvas and graphics
        Canvas canvas = new Canvas(w, h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //square styling and replication across the whole screen
        gc.setStroke(Color.LIGHTGRAY);
        gc.setFill(Color.LIGHTGRAY.deriveColor(1, 1, 1, 0.2));
        gc.fillRect(0, 0, w, h);
        gc.strokeRect(0, 0, w, h);

        //image generation
        Image image = canvas.snapshot(new SnapshotParameters(), null);
        ImagePattern pattern = new ImagePattern(image, 0, 0, w, h, false);

        return pattern;

    }


    //setting public click counter to identify if points have been plotted
    int click = 0;
    public void handleEvent(MouseEvent e) {
        print(e);
        click++;

        //switch that makes sure every point is plotted once and locked into position
        switch (click){
            /*case 1:
                //creates temp variable using mouse click coordinates
                final double c1x = x;
                final double c1y = y;
                //appends temp coordinates to circle
                c1.setLayoutX(c1x);
                c1.setLayoutY(c1y);
                break;
            case 3:
                final double c2x = x;
                final double c2y = y;
                c2.setLayoutX(c2x);
                c2.setLayoutY(c2y);
                break;
            case 5:
                final double c3x = x;
                final double c3y = y;
                c3.setLayoutX(c3x);
                c3.setLayoutY(c3y);

                //sets initial and terminal point for all vectors
                //this is placed in the switch case to ensure that the vectors are drawn after all points are plotted
                redToGreen.setStartX(c1.getLayoutX());
                redToGreen.setStartY(c1.getLayoutY());
                redToGreen.setEndX(c2.getLayoutX());
                redToGreen.setEndY(c2.getLayoutY());

                greenToBlue.setStartX(c2.getLayoutX());
                greenToBlue.setStartY(c2.getLayoutY());
                greenToBlue.setEndX(c3.getLayoutX());
                greenToBlue.setEndY(c3.getLayoutY());

                blueToRed.setStartX(c3.getLayoutX());
                blueToRed.setStartY(c3.getLayoutY());
                blueToRed.setEndX(c1.getLayoutX());
                blueToRed.setEndY(c1.getLayoutY());
            case 7:
                click = -1;
                break;*/
        }
    }

    public void handleCalculations(Circle c1, Circle c2, Circle c3){
        double[][] mainMatrix = new double[3][3];

        //appending coordinates and appropriate values to a matrix
        mainMatrix[0][0] = 0.0264583333 *c1.getLayoutX();
        mainMatrix[0][1] = 0.0264583333 *c1.getLayoutY();
        mainMatrix[0][2] = 1;
        mainMatrix[1][0] = 0.0264583333 *c2.getLayoutX();
        mainMatrix[1][1] = 0.0264583333 *c2.getLayoutY();
        mainMatrix[1][2] = 1;
        mainMatrix[2][0] = 0.0264583333 *c3.getLayoutX();
        mainMatrix[2][1] = 0.0264583333 *c3.getLayoutY();
        mainMatrix[2][2] = 1;

        //uses matrix indexes to calculate matrix determinant using the rule of sarrus
        double determinant =
                mainMatrix[0][0]*mainMatrix[1][1]*mainMatrix[2][2] + mainMatrix[0][1]*mainMatrix[1][2]*mainMatrix[2][0] +
                        mainMatrix[0][2]*mainMatrix[1][0]*mainMatrix[2][1] - mainMatrix[0][2]*mainMatrix[1][1]*mainMatrix[2][0] -
                        mainMatrix[0][0]*mainMatrix[1][2]*mainMatrix[2][1] - mainMatrix[0][1]*mainMatrix[1][0]*mainMatrix[2][2];

        //turns the determinant and turns it into final triangle area
        double area = Math.abs(determinant) * 0.5;
        areaLabel.setText("Total Area: " + area + "cm²");

        //calculating vector magnitudes using distance formula
        double rtg = 0.0264583333 * Math.sqrt(Math.pow((c1.getLayoutX()-c2.getLayoutX()),2)+Math.pow(c1.getLayoutY()-c2.getLayoutY(),2));
        DistanceRtG.setText("Distance Red to Green: " + rtg + "cm");

        double gtb = 0.0264583333 * Math.sqrt(Math.pow((c2.getLayoutX()-c3.getLayoutX()),2)+Math.pow(c2.getLayoutY()-c3.getLayoutY(),2));
        DistanceGtB.setText("Distance Green to Blue: " + gtb + "cm");

        double btr = 0.0264583333 * Math.sqrt(Math.pow((c3.getLayoutX()-c1.getLayoutX()),2)+Math.pow(c3.getLayoutY()-c1.getLayoutY(),2));
        DistanceBtR.setText("Distance Blue to Red: " + btr + "cm");


    }


    public void print(MouseEvent e) {
        //extracts information from mouse click (identified as "e")
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();

        //gets coordinate of the mouse click relative to the event source
        x = e.getX();
        y = e.getY();
        //System.out.println("Type=" + type + ", Target=" + target + ", Source=" + source + ", location(" + x + ", " + y + ")");

        //runs handleCalculations with every plot point as a parameter
        
        /*
        handleCalculations(c1,c2,c3);
        */
         System.out.println();

    }
}
