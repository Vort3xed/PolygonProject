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
import javafx.scene.paint.Paint;
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

    Circle c1 = new Circle(x,y,10);
    Circle c2 = new Circle(x,y,10);
    Circle c3 = new Circle(x,y,10);
    Circle c4 = new Circle(x,y,10);
    Circle c5 = new Circle(x,y,10);
    Circle c6 = new Circle(x,y,10);
    Circle c7 = new Circle(x,y,10);
    Circle c8 = new Circle(x,y,10);
    Circle c9 = new Circle(x,y,10);
    Circle c10 = new Circle(x,y,10);
    Circle c11 = new Circle(x,y,10);
    Circle c12 = new Circle(x,y,10);


    Label identifier = new Label("Specific Coordinates: ");
    Button submit = new Button("Submit");
    Button clear = new Button("Clear");
    Button startCalculation = new Button("Calculate");

    TextField c1Field = new TextField();
    TextField c2Field = new TextField();
    TextField c3Field = new TextField();
    TextField c4Field = new TextField();
    TextField c5Field = new TextField();
    TextField c6Field = new TextField();
    TextField c7Field = new TextField();
    TextField c8Field = new TextField();
    TextField c9Field = new TextField();
    TextField c10Field = new TextField();
    TextField c11Field = new TextField();
    TextField c12Field = new TextField();

    Line c1c2 = new Line();
    Line c2c3 = new Line();
    Line c3c4 = new Line();
    Line c4c5 = new Line();
    Line c5c6 = new Line();
    Line c6c7 = new Line();
    Line c7c8 = new Line();
    Line c8c9 = new Line();
    Line c9c10 = new Line();
    Line c10c11 = new Line();
    Line c11c12 = new Line();
    Line c12c1 = new Line();

    //top g
    Group g = new Group();


    public static void main(String[] args) {
        //gotta make this mf wake up right?
        Application.launch(args);
    }

    public void start(Stage stage){
        //top g
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

        {
            c1Field.setPromptText("Point 1");
            c1Field.setFocusTraversable(false);
            c1Field.setLayoutX(450);
            c1Field.setLayoutY(35);
            c1Field.getText();

            c2Field.setPromptText("Point 2");
            c2Field.setFocusTraversable(false);
            c2Field.setLayoutX(450);
            c2Field.setLayoutY(65);
            c2Field.getText();

            c3Field.setPromptText("Point 3");
            c3Field.setFocusTraversable(false);
            c3Field.setLayoutX(450);
            c3Field.setLayoutY(95);
            c3Field.getText();

            c4Field.setPromptText("Point 4");
            c4Field.setFocusTraversable(false);
            c4Field.setLayoutX(450);
            c4Field.setLayoutY(125);
            c4Field.getText();

            c5Field.setPromptText("Point 5");
            c5Field.setFocusTraversable(false);
            c5Field.setLayoutX(450);
            c5Field.setLayoutY(155);
            c5Field.getText();

            c6Field.setPromptText("Point 6");
            c6Field.setFocusTraversable(false);
            c6Field.setLayoutX(450);
            c6Field.setLayoutY(185);
            c6Field.getText();

            //column 2

            c7Field.setPromptText("Point 7");
            c7Field.setFocusTraversable(false);
            c7Field.setLayoutX(610);
            c7Field.setLayoutY(35);
            c7Field.getText();

            c8Field.setPromptText("Point 8");
            c8Field.setFocusTraversable(false);
            c8Field.setLayoutX(610);
            c8Field.setLayoutY(65);
            c8Field.getText();

            c9Field.setPromptText("Point 9");
            c9Field.setFocusTraversable(false);
            c9Field.setLayoutX(610);
            c9Field.setLayoutY(95);
            c9Field.getText();

            c10Field.setPromptText("Point 10");
            c10Field.setFocusTraversable(false);
            c10Field.setLayoutX(610);
            c10Field.setLayoutY(125);
            c10Field.getText();

            c11Field.setPromptText("Point 11");
            c11Field.setFocusTraversable(false);
            c11Field.setLayoutX(610);
            c11Field.setLayoutY(155);
            c11Field.getText();

            c12Field.setPromptText("Point 12");
            c12Field.setFocusTraversable(false);
            c12Field.setLayoutX(610);
            c12Field.setLayoutY(185);
            c12Field.getText();
        }


        submit.setLayoutX(450);
        submit.setLayoutY(215);
        clear.setLayoutX(510);
        clear.setLayoutY(215);
        startCalculation.setLayoutX(650);
        startCalculation.setLayoutY(215);


        //appending all nodes to group


        submit.setOnAction(this::handleSubmitAction);
        clear.setOnAction(this::handleClearAction);
        startCalculation.setOnAction(this::handleCalculations);


        g.getChildren().addAll(
                startCalculation,areaLabel,DistanceRtG,DistanceGtB,DistanceBtR,identifier,
                submit,clear,c1Field,c2Field,c3Field,c4Field,c5Field,c6Field,c7Field,c8Field,c9Field,
                c10Field,c11Field,c12Field);
    }

    public void handleSubmitAction(ActionEvent event){

        try{
            if (!c1Field.getText().isEmpty() && !c2Field.getText().isEmpty() && !c3Field.getText().isEmpty()
            && !c4Field.getText().isEmpty() && !c5Field.getText().isEmpty() && !c6Field.getText().isEmpty()
            && !c7Field.getText().isEmpty() && !c8Field.getText().isEmpty() && !c9Field.getText().isEmpty()
            && !c10Field.getText().isEmpty() && !c11Field.getText().isEmpty() && !c12Field.getText().isEmpty()) {

                identifier.setText("Specific Coordinates: (Parsed)");
                c1.setLayoutX(Double.parseDouble(c1Field.getText()));

                c2.setLayoutX(Double.parseDouble(c2Field.getText()));

                c3.setLayoutX(Double.parseDouble(c3Field.getText()));

                /*
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
                */
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
        }
    }
    public void handleClearAction(ActionEvent event){
        c1Field.clear();
        c2Field.clear();
        c3Field.clear();
        c4Field.clear();
        c5Field.clear();
        c6Field.clear();
        c7Field.clear();
        c8Field.clear();
        c9Field.clear();
        c10Field.clear();
        c11Field.clear();
        c12Field.clear();

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
            case 1:
                //creates temp variable using mouse click coordinates
                final double c1x = x;
                final double c1y = y;
                //appends temp coordinates to circle
                c1.setLayoutX(c1x);
                c1.setLayoutY(c1y);
                g.getChildren().add(c1);
                break;
            case 3:
                final double c2x = x;
                final double c2y = y;
                c2.setLayoutX(c2x);
                c2.setLayoutY(c2y);
                g.getChildren().add(c2);
                break;
            case 5:
                final double c3x = x;
                final double c3y = y;
                c3.setLayoutX(c3x);
                c3.setLayoutY(c3y);
                g.getChildren().add(c3);
                break;
            case 7:
                final double c4x = x;
                final double c4y = y;
                c4.setLayoutX(c4x);
                c4.setLayoutY(c4y);
                g.getChildren().add(c4);
                break;
            case 9:
                final double c5x = x;
                final double c5y = y;
                c5.setLayoutX(c5x);
                c5.setLayoutY(c5y);
                g.getChildren().add(c5);
                break;
            case 11:
                final double c6x = x;
                final double c6y = y;
                c6.setLayoutX(c6x);
                c6.setLayoutY(c6y);
                g.getChildren().add(c6);
                break;
            case 13:
                final double c7x = x;
                final double c7y = y;
                c7.setLayoutX(c7x);
                c7.setLayoutY(c7y);
                g.getChildren().add(c7);
                break;
            case 15:
                final double c8x = x;
                final double c8y = y;
                c8.setLayoutX(c8x);
                c8.setLayoutY(c8y);
                g.getChildren().add(c8);
                break;
            case 17:
                final double c9x = x;
                final double c9y = y;
                c9.setLayoutX(c9x);
                c9.setLayoutY(c9y);
                g.getChildren().add(c9);
                break;
            case 19:
                final double c10x = x;
                final double c10y = y;
                c10.setLayoutX(c10x);
                c10.setLayoutY(c10y);
                g.getChildren().add(c10);
                break;
            case 21:
                final double c11x = x;
                final double c11y = y;
                c11.setLayoutX(c11x);
                c11.setLayoutY(c11y);
                g.getChildren().add(c11);
                break;
            case 23:
                final double c12x = x;
                final double c12y = y;
                c12.setLayoutX(c12x);
                c12.setLayoutY(c12y);
                g.getChildren().add(c12);
                break;
        }
    }

    public void handleCalculations(ActionEvent event){
        double area = 0;
        areaLabel.setText("Total Area: " + area + "cm²");

        //calculating vector magnitudes using distance formula
        double rtg = 0.0264583333 * Math.sqrt(Math.pow((c1.getLayoutX()-c2.getLayoutX()),2)+Math.pow(c1.getLayoutY()-c2.getLayoutY(),2));
        DistanceRtG.setText("Distance Red to Green: " + rtg + "cm");

        double gtb = 0.0264583333 * Math.sqrt(Math.pow((c2.getLayoutX()-c3.getLayoutX()),2)+Math.pow(c2.getLayoutY()-c3.getLayoutY(),2));
        DistanceGtB.setText("Distance Green to Blue: " + gtb + "cm");

        double btr = 0.0264583333 * Math.sqrt(Math.pow((c3.getLayoutX()-c1.getLayoutX()),2)+Math.pow(c3.getLayoutY()-c1.getLayoutY(),2));
        DistanceBtR.setText("Distance Blue to Red: " + btr + "cm");

        /*
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
         */


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
         System.out.println("type: "+type+" source: "+source+" target: "+target+" location: "+x+","+y);

    }
}
