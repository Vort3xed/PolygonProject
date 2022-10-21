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

public class Main extends Application {

    //mouse click coordinates
    double x;
    double y;

    //Labels for triangle info
    Label areaLabel = new Label("Total Area: ");
    Label pointsLeftLabel = new Label("12 Points Remaining");

    Label DistanceL1 = new Label("Line 1 Distance: ");
    Label DistanceL2 = new Label("Line 2 Distance: ");
    Label DistanceL3 = new Label("Line 3 Distance: ");
    Label DistanceL4 = new Label("Line 4 Distance: ");
    Label DistanceL5 = new Label("Line 5 Distance: ");
    Label DistanceL6 = new Label("Line 6 Distance: ");
    Label DistanceL7 = new Label("Line 7 Distance: ");
    Label DistanceL8 = new Label("Line 8 Distance: ");
    Label DistanceL9 = new Label("Line 9 Distance: ");
    Label DistanceL10 = new Label("Line 10 Distance: ");
    Label DistanceL11 = new Label("Line 11 Distance: ");
    Label DistanceL12 = new Label("Line 12 Distance: ");

    //generated circles with coordinates and radius
    int r = 5;
    Circle c1 = new Circle(x, y, r);
    Circle c2 = new Circle(x, y, r);
    Circle c3 = new Circle(x, y, r);
    Circle c4 = new Circle(x, y, r);
    Circle c5 = new Circle(x, y, r);
    Circle c6 = new Circle(x, y, r);
    Circle c7 = new Circle(x, y, r);
    Circle c8 = new Circle(x, y, r);
    Circle c9 = new Circle(x, y, r);
    Circle c10 = new Circle(x, y, r);
    Circle c11 = new Circle(x, y, r);
    Circle c12 = new Circle(x, y, r);

    //created buttons
    Label identifier = new Label("Specific Coordinates: ");
    Button submit = new Button("Submit");
    Button clear = new Button("Clear");
    Button startCalculation = new Button("Calculate");
    Button toggleSnap = new Button("Snap Off");
    Button factoryReset = new Button("Reset All");

    //created 12 text fields for manual coordinate input
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

    //created lines to connect all plotted points
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

    //identifying vectors with labels
    Label L1Identity = new Label("L1");
    Label L2Identity = new Label("L2");
    Label L3Identity = new Label("L3");
    Label L4Identity = new Label("L4");
    Label L5Identity = new Label("L5");
    Label L6Identity = new Label("L6");
    Label L7Identity = new Label("L7");
    Label L8Identity = new Label("L8");
    Label L9Identity = new Label("L9");
    Label L10Identity = new Label("L10");
    Label L11Identity = new Label("L11");
    Label L12Identity = new Label("L12");

    //initialized arrays
    Label[] distanceLabels = new Label[12];
    TextField[] textBoxes = new TextField[12];
    Line[] lines = new Line[12];
    Circle[] circles = new Circle[12];
    Label[] lineIdentifiers = new Label[12];

    //top g
    Group g = new Group();

    //assistance classes


    //launch
    public static void main(String[] args) {
        //gotta make this mf wake up right?
        Application.launch(args);
    }

    //initializing program
    public void start(Stage stage) {
        //scene styling and initialization
        Scene scene = new Scene(g, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Polygon Calculator");
        scene.setFill(createGridPattern());
        stage.setResizable(true);
        stage.show();

        //associating e to function using mouse click event
        EventHandler<MouseEvent> handler = this::handleEvent;


        //attaching click handlers for stage and scene
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);

        //make da arrays cuh
        initializeArrays();


        //styling area label
        areaLabel.setFont(Font.font(null, FontWeight.BOLD, 20));
        areaLabel.setLayoutX(10);
        areaLabel.setLayoutY(15);

        //angle label styling
        identifier.setFont(Font.font(18));
        identifier.setLayoutX(450);
        identifier.setLayoutY(5);

        pointsLeftLabel.setFont(Font.font(15));
        pointsLeftLabel.setLayoutX(450);
        pointsLeftLabel.setLayoutY(240);

        //distance label styling
        for (int i = 0; i < 12; i++) {
            distanceLabels[i].setFont(Font.font(20));
            distanceLabels[i].setLayoutX(10);
            distanceLabels[i].setLayoutY((20 * i) + 35);
        }


        //style every textbox
        for (int i = 0; i < 6; i++) {
            textBoxes[i].setPromptText("Point " + (i + 1) + "X, Point " + (i + 1) + "Y");
            textBoxes[i].setFocusTraversable(false);
            textBoxes[i].setLayoutX(450);
            textBoxes[i].setLayoutY((i * 30) + 35);
        }
        int yLayoutMultiplier = 0;
        for (int i = 6; i < 12; i++) {
            textBoxes[i].setPromptText("Point " + (i + 1) + "X, Point " + (i + 1) + "Y");
            textBoxes[i].setFocusTraversable(false);
            textBoxes[i].setLayoutX(610);
            textBoxes[i].setLayoutY((yLayoutMultiplier * 30) + 35);
            yLayoutMultiplier++;
        }

        //setting positions of buttons
        Styling.styleButtons(submit,450,215);
        Styling.styleButtons(clear,510,215);
        Styling.styleButtons(startCalculation,627,215);
        Styling.styleButtons(toggleSnap,695,215,"-fx-background-color: #ff0000");
        Styling.styleButtons(factoryReset,560,215);

        //appending buttons to click listener adapter functions
        submit.setOnAction(this::handleSubmitAction);
        clear.setOnAction(this::handleClearAction);
        startCalculation.setOnAction(this::handleCalculations);
        toggleSnap.setOnAction(this::handleToggleSnap);
        factoryReset.setOnAction(this::handleResetAction);

        //appending all nodes to group
        g.getChildren().addAll(
                startCalculation, areaLabel, pointsLeftLabel, DistanceL1, DistanceL2, DistanceL3, DistanceL4, DistanceL5,
                DistanceL6, DistanceL7, DistanceL8, DistanceL9, DistanceL10, DistanceL11, DistanceL12, identifier,
                submit, clear, toggleSnap, factoryReset, c1Field, c2Field, c3Field, c4Field, c5Field, c6Field, c7Field, c8Field, c9Field,
                c10Field, c11Field, c12Field);
        //, c1c2, c2c3, c3c4, c4c5, c5c6, c6c7, c7c8, c8c9, c9c10, c10c11, c11c12, c12c1
    }

    //appending all nodes to an array so that nodes can be initialized iteratively
    public void initializeArrays() {
        textBoxes[0] = c1Field;
        textBoxes[1] = c2Field;
        textBoxes[2] = c3Field;
        textBoxes[3] = c4Field;
        textBoxes[4] = c5Field;
        textBoxes[5] = c6Field;
        textBoxes[6] = c7Field;
        textBoxes[7] = c8Field;
        textBoxes[8] = c9Field;
        textBoxes[9] = c10Field;
        textBoxes[10] = c11Field;
        textBoxes[11] = c12Field;

        circles[0] = c1;
        circles[1] = c2;
        circles[2] = c3;
        circles[3] = c4;
        circles[4] = c5;
        circles[5] = c6;
        circles[6] = c7;
        circles[7] = c8;
        circles[8] = c9;
        circles[9] = c10;
        circles[10] = c11;
        circles[11] = c12;

        lines[0] = c1c2;
        lines[1] = c2c3;
        lines[2] = c3c4;
        lines[3] = c4c5;
        lines[4] = c5c6;
        lines[5] = c6c7;
        lines[6] = c7c8;
        lines[7] = c8c9;
        lines[8] = c9c10;
        lines[9] = c10c11;
        lines[10] = c11c12;
        lines[11] = c12c1;

        distanceLabels[0] = DistanceL1;
        distanceLabels[1] = DistanceL2;
        distanceLabels[2] = DistanceL3;
        distanceLabels[3] = DistanceL4;
        distanceLabels[4] = DistanceL5;
        distanceLabels[5] = DistanceL6;
        distanceLabels[6] = DistanceL7;
        distanceLabels[7] = DistanceL8;
        distanceLabels[8] = DistanceL9;
        distanceLabels[9] = DistanceL10;
        distanceLabels[10] = DistanceL11;
        distanceLabels[11] = DistanceL12;

        lineIdentifiers[0] = L1Identity;
        lineIdentifiers[1] = L2Identity;
        lineIdentifiers[2] = L3Identity;
        lineIdentifiers[3] = L4Identity;
        lineIdentifiers[4] = L5Identity;
        lineIdentifiers[5] = L6Identity;
        lineIdentifiers[6] = L7Identity;
        lineIdentifiers[7] = L8Identity;
        lineIdentifiers[8] = L9Identity;
        lineIdentifiers[9] = L10Identity;
        lineIdentifiers[10] = L11Identity;
        lineIdentifiers[11] = L12Identity;
    }

    //function that iteratively draws vectors between plotted points
    public void drawLines() {
        for (int i = 0; i < 11; i++) {
            Styling.drawVectors(lines[i],circles[i].getLayoutX(),circles[i].getLayoutY(),
                    circles[i + 1].getLayoutX(),circles[i + 1].getLayoutY());
        }
        Styling.drawVectors(c12c1,c12.getLayoutX(),c12.getLayoutY(),c1.getLayoutX(),c1.getLayoutY());
    }

    //function for when submit button is clicked
    public void handleSubmitAction(ActionEvent event) {

        //check if any fields have characters to be retrieved
        try {
            if (!c1Field.getText().isEmpty() || !c2Field.getText().isEmpty() || !c3Field.getText().isEmpty()
                    && !c4Field.getText().isEmpty() || !c5Field.getText().isEmpty() || !c6Field.getText().isEmpty()
                    && !c7Field.getText().isEmpty() || !c8Field.getText().isEmpty() || !c9Field.getText().isEmpty()
                    && !c10Field.getText().isEmpty() || !c11Field.getText().isEmpty() || !c12Field.getText().isEmpty()) {

                identifier.setText("Specific Coordinates: (Parsed)");

                //iteratively
                for (int i = 0; i < 12; i++) {
                    if (!textBoxes[i].getText().isEmpty()) {
                        String[] temp = textBoxes[i].getText().split(",");
                        Styling.styleCircles(circles[i],Double.parseDouble(temp[0]),Double.parseDouble(temp[1]));
                    }
                }

                //draw vectors
                drawLines();
                handleCalculations(event);

            } else {
                //pushes all points back to their original point in the case of a failed parse
                identifier.setText("Specific Coordinates: (Parse Failed)");

                for (int i = 0; i < 12; i++) {
                    Styling.styleCircles(circles[i],circles[i].getLayoutX(),circles[i].getLayoutY());
                }

            }
        } catch (Exception p) {
            identifier.setText("Specific Coordinates: (Error!)");
        }
    }

    public void handleClearAction(ActionEvent event) {
        for (int i = 0; i < 12; i++) {
            textBoxes[i].clear();
        }
        identifier.setText("Specific Coordinates: ");
    }

    //function for creating grid
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

        return new ImagePattern(image, 0, 0, w, h, false);

    }

    boolean snapEnabled = false;

    public void handleToggleSnap(ActionEvent event) {
        snapEnabled = !snapEnabled;
        if (snapEnabled) {
            Styling.styleButtons(toggleSnap,"Snap On","-fx-background-color: #00ff00");
        } else {
            Styling.styleButtons(toggleSnap,"Snap Off","-fx-background-color: #ff0000");
        }
    }

    public double parseXSnapCoords() {
        return Math.round(x / 20) * 20;
    }

    public double parseYSnapCoords() {
        return Math.round(y / 20) * 20;
    }

    //setting public click counter to identify if points have been plotted
    int click = 0;
    int pointsRemaining = 12;

    boolean calculateAble = false;

    public void handleEvent(MouseEvent e) {
        print(e);
        click++;

        for (int i = 0; i < 12; i++) {
            if (click == ((2 * i) + 1)) {
                if (snapEnabled) {
                    Styling.styleCircles(circles[i],parseXSnapCoords(),parseYSnapCoords());
                    g.getChildren().add(circles[i]);
                } else {
                    Styling.styleCircles(circles[i],x,y);
                    g.getChildren().add(circles[i]);
                }
                pointsRemaining--;
                pointsLeftLabel.setText(pointsRemaining + " Points Remaining");
            }

        }
        if (pointsRemaining == 0) {
            calculateAble = true;
        }
    }

    //calculates area of polygon
    public static double polygonArea(double[] X, double[] Y, int n) {
        double area = 0.0;

        //calculate area using shoelace formula
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);

            //j is previous vertex to i
            j = i;
        }

        //return absolute value
        return Math.abs(area / 2.0);
    }

    boolean created = true;
    boolean resetAble = false;

    public void handleResetAction(ActionEvent event) {
        if (resetAble) {
            for (int i = 0; i < 12; i++) {


                g.getChildren().removeAll(circles[i],lineIdentifiers[i],lines[i]);
                distanceLabels[i].setText("Line " + i + " Distance: ");
            }
            created = true;

            areaLabel.setText("Total Area: ");
            pointsRemaining = 12;
            pointsLeftLabel.setText(pointsRemaining + " Points Remaining");
            click = 0;
            resetAble = false;
        }
    }

    //runs whenever calculate button is pressed
    public void handleCalculations(ActionEvent event) {
        //places all x and y points into a separate array for the area function to use
        double[] X = new double[12];
        double[] Y = new double[12];

        for (int i = 0; i < 12; i++) {
            X[i] = circles[i].getLayoutX();
            Y[i] = circles[i].getLayoutY();
        }

        //max amount of vertices and truncating factor
        int n = 12;
        int sigFigs = 10;

        if (calculateAble) {
        //prints area into app
        areaLabel.setText("Total Area: " + polygonArea(X, Y, n) * 0.0264583333 * 0.0264583333 + "cm²");

        //calculating vector magnitudes using distance formula
        for (int i = 0; i < 11; i++) {
            distanceLabels[i].setText("Line " + i + " Distance: " + String.format("%.0" +
                    sigFigs + "f", (0.0264583333 * Math.sqrt(Math.pow((circles[i].getLayoutX() - circles[i + 1].getLayoutX()), 2) +
                    Math.pow(circles[i].getLayoutY() - circles[i + 1].getLayoutY(), 2)))) + "cm");

        }
        double line12 = 0.0264583333 * Math.sqrt(Math.pow((c12.getLayoutX() - c1.getLayoutX()), 2) + Math.pow(c12.getLayoutY() - c1.getLayoutY(), 2));
        DistanceL12.setText("Line 12 Distance: " + String.format("%.0" + sigFigs + "f", line12) + "cm");

        //makes sure that nodes are appended to group only one time

            if (created) {
                for (int i = 0; i < 12; i++) {
                    g.getChildren().addAll(lines[i], lineIdentifiers[i]);
                }
                created = false;
            }

            resetAble = true;
            drawLines();
            appendLabels();
        }
        calculateAble = false;
    }

    public void appendLabels() {
        for (int i = 0; i < 11; i++) {
            Styling.styleLineIdentifiers(lineIdentifiers[i],(circles[i].getLayoutX() + circles[i + 1].getLayoutX()) / 2,
                    (circles[i].getLayoutY() + circles[i + 1].getLayoutY()) / 2,Color.RED);
        }

        //appending line labels to group and styling them

        Styling.styleLineIdentifiers(L12Identity,(c12.getLayoutX() + c1.getLayoutX()) / 2,
                (c12.getLayoutY() + c1.getLayoutY()) / 2,Color.RED);
    }

    //function for extracting mouse click coordinates and debugging
    public void print(MouseEvent e) {
        //extracts information from mouse click (identified as "e")
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();

        //gets coordinate of the mouse click relative to the event source
        x = e.getX();
        y = e.getY();

        //prints click information
        System.out.println("type: " + type + " source: " + source + " target: " + target + " location: " + x + "," + y);

    }
}
