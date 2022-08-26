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

    //labels
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


    //top g
    Group g = new Group();


    public static void main(String[] args) {
        //gotta make this mf wake up right?
        Application.launch(args);
    }

    public void start(Stage stage){
        //top g

        //scene styling and initialization
        Scene scene = new Scene(g, 800, 600);
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
        DistanceL1.setFont(Font.font(20));
        DistanceL1.setLayoutX(10);
        DistanceL1.setLayoutY(35);

        DistanceL2.setFont(Font.font(20));
        DistanceL2.setLayoutX(10);
        DistanceL2.setLayoutY(55);

        DistanceL3.setFont(Font.font(20));
        DistanceL3.setLayoutX(10);
        DistanceL3.setLayoutY(75);

        DistanceL4.setFont(Font.font(20));
        DistanceL4.setLayoutX(10);
        DistanceL4.setLayoutY(95);

        DistanceL5.setFont(Font.font(20));
        DistanceL5.setLayoutX(10);
        DistanceL5.setLayoutY(115);

        DistanceL6.setFont(Font.font(20));
        DistanceL6.setLayoutX(10);
        DistanceL6.setLayoutY(135);

        DistanceL7.setFont(Font.font(20));
        DistanceL7.setLayoutX(10);
        DistanceL7.setLayoutY(155);

        DistanceL8.setFont(Font.font(20));
        DistanceL8.setLayoutX(10);
        DistanceL8.setLayoutY(175);

        DistanceL9.setFont(Font.font(20));
        DistanceL9.setLayoutX(10);
        DistanceL9.setLayoutY(195);

        DistanceL10.setFont(Font.font(20));
        DistanceL10.setLayoutX(10);
        DistanceL10.setLayoutY(215);

        DistanceL11.setFont(Font.font(20));
        DistanceL11.setLayoutX(10);
        DistanceL11.setLayoutY(235);

        DistanceL12.setFont(Font.font(20));
        DistanceL12.setLayoutX(10);
        DistanceL12.setLayoutY(255);

        //angle label styling

        identifier.setFont(Font.font(18));
        identifier.setLayoutX(450);
        identifier.setLayoutY(5);

        {
            c1Field.setPromptText("Point 1X, Point 1Y");
            c1Field.setFocusTraversable(false);
            c1Field.setLayoutX(450);
            c1Field.setLayoutY(35);
            c1Field.getText();

            c2Field.setPromptText("Point 2X, Point 2Y");
            c2Field.setFocusTraversable(false);
            c2Field.setLayoutX(450);
            c2Field.setLayoutY(65);
            c2Field.getText();

            c3Field.setPromptText("Point 3X, Point 3Y");
            c3Field.setFocusTraversable(false);
            c3Field.setLayoutX(450);
            c3Field.setLayoutY(95);
            c3Field.getText();

            c4Field.setPromptText("Point 4X, Point 4Y");
            c4Field.setFocusTraversable(false);
            c4Field.setLayoutX(450);
            c4Field.setLayoutY(125);
            c4Field.getText();

            c5Field.setPromptText("Point 5X, Point 5Y");
            c5Field.setFocusTraversable(false);
            c5Field.setLayoutX(450);
            c5Field.setLayoutY(155);
            c5Field.getText();

            c6Field.setPromptText("Point 6X, Point 6Y");
            c6Field.setFocusTraversable(false);
            c6Field.setLayoutX(450);
            c6Field.setLayoutY(185);
            c6Field.getText();

            //column 2

            c7Field.setPromptText("Point 7X, Point 7Y");
            c7Field.setFocusTraversable(false);
            c7Field.setLayoutX(610);
            c7Field.setLayoutY(35);
            c7Field.getText();

            c8Field.setPromptText("Point 8X, Point 8Y");
            c8Field.setFocusTraversable(false);
            c8Field.setLayoutX(610);
            c8Field.setLayoutY(65);
            c8Field.getText();

            c9Field.setPromptText("Point 9X, Point 9Y");
            c9Field.setFocusTraversable(false);
            c9Field.setLayoutX(610);
            c9Field.setLayoutY(95);
            c9Field.getText();

            c10Field.setPromptText("Point 10X, Point 10Y");
            c10Field.setFocusTraversable(false);
            c10Field.setLayoutX(610);
            c10Field.setLayoutY(125);
            c10Field.getText();

            c11Field.setPromptText("Point 11X, Point 11Y");
            c11Field.setFocusTraversable(false);
            c11Field.setLayoutX(610);
            c11Field.setLayoutY(155);
            c11Field.getText();

            c12Field.setPromptText("Point 12X, Point 12Y");
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
                startCalculation,areaLabel,DistanceL1,DistanceL2,DistanceL3,DistanceL4,DistanceL5,
                DistanceL6,DistanceL7,DistanceL8,DistanceL9,DistanceL10,DistanceL11,DistanceL12,identifier,
                submit,clear,c1Field,c2Field,c3Field,c4Field,c5Field,c6Field,c7Field,c8Field,c9Field,
                c10Field,c11Field,c12Field,c1c2,c2c3,c3c4,c4c5,c5c6,c6c7,c7c8,c8c9,c9c10,c10c11,c11c12,c12c1);
    }

    boolean created = false;
    public void handleSubmitAction(ActionEvent event){

        try{
            if (!c1Field.getText().isEmpty() && !c2Field.getText().isEmpty() && !c3Field.getText().isEmpty()
            && !c4Field.getText().isEmpty() && !c5Field.getText().isEmpty() && !c6Field.getText().isEmpty()
            && !c7Field.getText().isEmpty() && !c8Field.getText().isEmpty() && !c9Field.getText().isEmpty()
            && !c10Field.getText().isEmpty() && !c11Field.getText().isEmpty() && !c12Field.getText().isEmpty()) {

                identifier.setText("Specific Coordinates: (Parsed)");

                String[] c1LOC = c1Field.getText().split(",");
                String[] c2LOC = c2Field.getText().split(",");
                String[] c3LOC = c3Field.getText().split(",");
                String[] c4LOC = c4Field.getText().split(",");
                String[] c5LOC = c5Field.getText().split(",");
                String[] c6LOC = c6Field.getText().split(",");
                String[] c7LOC = c7Field.getText().split(",");
                String[] c8LOC = c8Field.getText().split(",");
                String[] c9LOC = c9Field.getText().split(",");
                String[] c10LOC = c10Field.getText().split(",");
                String[] c11LOC = c11Field.getText().split(",");
                String[] c12LOC = c12Field.getText().split(",");

                //retrieves x and y coordinates from split array
                {
                    c1.setLayoutX(Double.parseDouble(c1LOC[0]));
                    c2.setLayoutX(Double.parseDouble(c2LOC[0]));
                    c3.setLayoutX(Double.parseDouble(c3LOC[0]));
                    c4.setLayoutX(Double.parseDouble(c4LOC[0]));
                    c5.setLayoutX(Double.parseDouble(c5LOC[0]));
                    c6.setLayoutX(Double.parseDouble(c6LOC[0]));
                    c7.setLayoutX(Double.parseDouble(c7LOC[0]));
                    c8.setLayoutX(Double.parseDouble(c8LOC[0]));
                    c9.setLayoutX(Double.parseDouble(c9LOC[0]));
                    c10.setLayoutX(Double.parseDouble(c10LOC[0]));
                    c11.setLayoutX(Double.parseDouble(c11LOC[0]));
                    c12.setLayoutX(Double.parseDouble(c12LOC[0]));

                    c1.setLayoutY(Double.parseDouble(c1LOC[1]));
                    c2.setLayoutY(Double.parseDouble(c2LOC[1]));
                    c3.setLayoutY(Double.parseDouble(c3LOC[1]));
                    c4.setLayoutY(Double.parseDouble(c4LOC[1]));
                    c5.setLayoutY(Double.parseDouble(c5LOC[1]));
                    c6.setLayoutY(Double.parseDouble(c6LOC[1]));
                    c7.setLayoutY(Double.parseDouble(c7LOC[1]));
                    c8.setLayoutY(Double.parseDouble(c8LOC[1]));
                    c9.setLayoutY(Double.parseDouble(c9LOC[1]));
                    c10.setLayoutY(Double.parseDouble(c10LOC[1]));
                    c11.setLayoutY(Double.parseDouble(c11LOC[1]));
                    c12.setLayoutY(Double.parseDouble(c12LOC[1]));
                }

                c1c2.setStartX(c1.getLayoutX());
                c1c2.setStartY(c1.getLayoutY());
                c1c2.setEndX(c2.getLayoutX());
                c1c2.setEndY(c2.getLayoutY());

                c2c3.setStartX(c2.getLayoutX());
                c2c3.setStartY(c2.getLayoutY());
                c2c3.setEndX(c3.getLayoutX());
                c2c3.setEndY(c3.getLayoutY());

                //vector plotting
                {
                    c3c4.setStartX(c3.getLayoutX());
                    c3c4.setStartY(c3.getLayoutY());
                    c3c4.setEndX(c4.getLayoutX());
                    c3c4.setEndY(c4.getLayoutY());

                    c4c5.setStartX(c4.getLayoutX());
                    c4c5.setStartY(c4.getLayoutY());
                    c4c5.setEndX(c5.getLayoutX());
                    c4c5.setEndY(c5.getLayoutY());

                    c5c6.setStartX(c5.getLayoutX());
                    c5c6.setStartY(c5.getLayoutY());
                    c5c6.setEndX(c6.getLayoutX());
                    c5c6.setEndY(c6.getLayoutY());

                    c6c7.setStartX(c6.getLayoutX());
                    c6c7.setStartY(c6.getLayoutY());
                    c6c7.setEndX(c7.getLayoutX());
                    c6c7.setEndY(c7.getLayoutY());

                    c7c8.setStartX(c7.getLayoutX());
                    c7c8.setStartY(c7.getLayoutY());
                    c7c8.setEndX(c8.getLayoutX());
                    c7c8.setEndY(c8.getLayoutY());

                    c8c9.setStartX(c8.getLayoutX());
                    c8c9.setStartY(c8.getLayoutY());
                    c8c9.setEndX(c9.getLayoutX());
                    c8c9.setEndY(c9.getLayoutY());

                    c9c10.setStartX(c9.getLayoutX());
                    c9c10.setStartY(c9.getLayoutY());
                    c9c10.setEndX(c10.getLayoutX());
                    c9c10.setEndY(c10.getLayoutY());

                    c10c11.setStartX(c10.getLayoutX());
                    c10c11.setStartY(c10.getLayoutY());
                    c10c11.setEndX(c11.getLayoutX());
                    c10c11.setEndY(c11.getLayoutY());

                    c11c12.setStartX(c11.getLayoutX());
                    c11c12.setStartY(c11.getLayoutY());
                    c11c12.setEndX(c12.getLayoutX());
                    c11c12.setEndY(c12.getLayoutY());

                    c12c1.setStartX(c12.getLayoutX());
                    c12c1.setStartY(c12.getLayoutY());
                    c12c1.setEndX(c1.getLayoutX());
                    c12c1.setEndY(c1.getLayoutY());
                }

                handleCalculations(event);

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
            identifier.setText("Specific Coordinates: (Error!)");

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
    public static double polygonArea(double X[], double Y[], int n) {
        // Initialize area
        double area = 0.0;

        // Calculate value of shoelace formula
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);

            // j is previous vertex to i
            j = i;
        }

        // Return absolute value
        return Math.abs(area / 2.0);
    }

    public void handleCalculations(ActionEvent event){

        
        
        double X[] = {c1.getLayoutX(),c2.getLayoutX(),c3.getLayoutX(),c4.getLayoutX(),c5.getLayoutX(),
                c6.getLayoutX(),c7.getLayoutX(),c8.getLayoutX(),c9.getLayoutX(),c10.getLayoutX(),c11.getLayoutX(),
                c12.getLayoutX()};

        double Y[] = {c1.getLayoutY(),c2.getLayoutY(),c3.getLayoutY(),c4.getLayoutY(),c5.getLayoutY(),
                c6.getLayoutY(),c7.getLayoutY(),c8.getLayoutY(),c9.getLayoutY(),c10.getLayoutY(),c11.getLayoutY(),
                c12.getLayoutY()};

        int n = 12;

        areaLabel.setText("Total Area: " +polygonArea(X,Y,n)*0.0264583333*0.0264583333+"cm²");


        //calculating vector magnitudes using distance formula
        double line1 = 0.0264583333 * Math.sqrt(Math.pow((c1.getLayoutX()-c2.getLayoutX()),2)+Math.pow(c1.getLayoutY()-c2.getLayoutY(),2));
        DistanceL1.setText("Line 1 Distance: " + line1 + "cm");

        double line2 = 0.0264583333 * Math.sqrt(Math.pow((c2.getLayoutX()-c3.getLayoutX()),2)+Math.pow(c2.getLayoutY()-c3.getLayoutY(),2));
        DistanceL2.setText("Line 2 Distance: " + line2 + "cm");

        double line3 = 0.0264583333 * Math.sqrt(Math.pow((c3.getLayoutX()-c4.getLayoutX()),2)+Math.pow(c3.getLayoutY()-c4.getLayoutY(),2));
        DistanceL3.setText("Line 3 Distance: " + line3 + "cm");

        double line4 = 0.0264583333 * Math.sqrt(Math.pow((c4.getLayoutX()-c5.getLayoutX()),2)+Math.pow(c4.getLayoutY()-c5.getLayoutY(),2));
        DistanceL4.setText("Line 4 Distance: " + line4 + "cm");

        double line5 = 0.0264583333 * Math.sqrt(Math.pow((c5.getLayoutX()-c6.getLayoutX()),2)+Math.pow(c5.getLayoutY()-c6.getLayoutY(),2));
        DistanceL5.setText("Line 5 Distance: " + line5 + "cm");

        double line6 = 0.0264583333 * Math.sqrt(Math.pow((c6.getLayoutX()-c7.getLayoutX()),2)+Math.pow(c6.getLayoutY()-c7.getLayoutY(),2));
        DistanceL6.setText("Line 6 Distance: " + line6 + "cm");

        double line7 = 0.0264583333 * Math.sqrt(Math.pow((c7.getLayoutX()-c8.getLayoutX()),2)+Math.pow(c7.getLayoutY()-c8.getLayoutY(),2));
        DistanceL7.setText("Line 7 Distance: " + line7 + "cm");

        double line8 = 0.0264583333 * Math.sqrt(Math.pow((c8.getLayoutX()-c9.getLayoutX()),2)+Math.pow(c8.getLayoutY()-c9.getLayoutY(),2));
        DistanceL8.setText("Line 8 Distance: " + line8 + "cm");

        double line9 = 0.0264583333 * Math.sqrt(Math.pow((c9.getLayoutX()-c10.getLayoutX()),2)+Math.pow(c9.getLayoutY()-c10.getLayoutY(),2));
        DistanceL9.setText("Line 9 Distance: " + line9 + "cm");

        double line10 = 0.0264583333 * Math.sqrt(Math.pow((c10.getLayoutX()-c11.getLayoutX()),2)+Math.pow(c10.getLayoutY()-c11.getLayoutY(),2));
        DistanceL10.setText("Line 10 Distance: " + line10 + "cm");

        double line11 = 0.0264583333 * Math.sqrt(Math.pow((c11.getLayoutX()-c12.getLayoutX()),2)+Math.pow(c11.getLayoutY()-c12.getLayoutY(),2));
        DistanceL11.setText("Line 11 Distance: " + line11 + "cm");

        double line12 = 0.0264583333 * Math.sqrt(Math.pow((c12.getLayoutX()-c1.getLayoutX()),2)+Math.pow(c12.getLayoutY()-c1.getLayoutY(),2));
        DistanceL12.setText("Line 12 Distance: " + line12 + "cm");

        if(created == false){
            g.getChildren().addAll(L1Identity,L2Identity,L3Identity,L4Identity,L5Identity,L6Identity,L7Identity,L8Identity,L9Identity,
                    L10Identity,L11Identity,L12Identity);
        }
        created = true;


        L1Identity.setLayoutX((c1.getLayoutX()+c2.getLayoutX())/2);
        L1Identity.setLayoutY((c1.getLayoutY()+c2.getLayoutY())/2);
        L1Identity.setTextFill(Color.RED);

        L2Identity.setLayoutX((c2.getLayoutX()+c3.getLayoutX())/2);
        L2Identity.setLayoutY((c2.getLayoutY()+c3.getLayoutY())/2);
        L2Identity.setTextFill(Color.RED);

        L3Identity.setLayoutX((c3.getLayoutX()+c4.getLayoutX())/2);
        L3Identity.setLayoutY((c3.getLayoutY()+c4.getLayoutY())/2);
        L3Identity.setTextFill(Color.RED);

        L4Identity.setLayoutX((c4.getLayoutX()+c5.getLayoutX())/2);
        L4Identity.setLayoutY((c4.getLayoutY()+c5.getLayoutY())/2);
        L4Identity.setTextFill(Color.RED);

        L5Identity.setLayoutX((c5.getLayoutX()+c6.getLayoutX())/2);
        L5Identity.setLayoutY((c5.getLayoutY()+c6.getLayoutY())/2);
        L5Identity.setTextFill(Color.RED);

        L6Identity.setLayoutX((c6.getLayoutX()+c7.getLayoutX())/2);
        L6Identity.setLayoutY((c6.getLayoutY()+c7.getLayoutY())/2);
        L6Identity.setTextFill(Color.RED);

        L7Identity.setLayoutX((c7.getLayoutX()+c8.getLayoutX())/2);
        L7Identity.setLayoutY((c7.getLayoutY()+c8.getLayoutY())/2);
        L7Identity.setTextFill(Color.RED);

        L8Identity.setLayoutX((c8.getLayoutX()+c9.getLayoutX())/2);
        L8Identity.setLayoutY((c8.getLayoutY()+c9.getLayoutY())/2);
        L8Identity.setTextFill(Color.RED);

        L9Identity.setLayoutX((c9.getLayoutX()+c10.getLayoutX())/2);
        L9Identity.setLayoutY((c9.getLayoutY()+c10.getLayoutY())/2);
        L9Identity.setTextFill(Color.RED);

        L10Identity.setLayoutX((c10.getLayoutX()+c11.getLayoutX())/2);
        L10Identity.setLayoutY((c10.getLayoutY()+c11.getLayoutY())/2);
        L10Identity.setTextFill(Color.RED);

        L11Identity.setLayoutX((c11.getLayoutX()+c12.getLayoutX())/2);
        L11Identity.setLayoutY((c11.getLayoutY()+c12.getLayoutY())/2);
        L11Identity.setTextFill(Color.RED);

        L12Identity.setLayoutX((c12.getLayoutX()+c1.getLayoutX())/2);
        L12Identity.setLayoutY((c12.getLayoutY()+c1.getLayoutY())/2);
        L12Identity.setTextFill(Color.RED);



        //vector plotting
        {
            c1c2.setStartX(c1.getLayoutX());
            c1c2.setStartY(c1.getLayoutY());
            c1c2.setEndX(c2.getLayoutX());
            c1c2.setEndY(c2.getLayoutY());

            c2c3.setStartX(c2.getLayoutX());
            c2c3.setStartY(c2.getLayoutY());
            c2c3.setEndX(c3.getLayoutX());
            c2c3.setEndY(c3.getLayoutY());

            c3c4.setStartX(c3.getLayoutX());
            c3c4.setStartY(c3.getLayoutY());
            c3c4.setEndX(c4.getLayoutX());
            c3c4.setEndY(c4.getLayoutY());

            c4c5.setStartX(c4.getLayoutX());
            c4c5.setStartY(c4.getLayoutY());
            c4c5.setEndX(c5.getLayoutX());
            c4c5.setEndY(c5.getLayoutY());

            c5c6.setStartX(c5.getLayoutX());
            c5c6.setStartY(c5.getLayoutY());
            c5c6.setEndX(c6.getLayoutX());
            c5c6.setEndY(c6.getLayoutY());

            c6c7.setStartX(c6.getLayoutX());
            c6c7.setStartY(c6.getLayoutY());
            c6c7.setEndX(c7.getLayoutX());
            c6c7.setEndY(c7.getLayoutY());

            c7c8.setStartX(c7.getLayoutX());
            c7c8.setStartY(c7.getLayoutY());
            c7c8.setEndX(c8.getLayoutX());
            c7c8.setEndY(c8.getLayoutY());

            c8c9.setStartX(c8.getLayoutX());
            c8c9.setStartY(c8.getLayoutY());
            c8c9.setEndX(c9.getLayoutX());
            c8c9.setEndY(c9.getLayoutY());

            c9c10.setStartX(c9.getLayoutX());
            c9c10.setStartY(c9.getLayoutY());
            c9c10.setEndX(c10.getLayoutX());
            c9c10.setEndY(c10.getLayoutY());

            c10c11.setStartX(c10.getLayoutX());
            c10c11.setStartY(c10.getLayoutY());
            c10c11.setEndX(c11.getLayoutX());
            c10c11.setEndY(c11.getLayoutY());

            c11c12.setStartX(c11.getLayoutX());
            c11c12.setStartY(c11.getLayoutY());
            c11c12.setEndX(c12.getLayoutX());
            c11c12.setEndY(c12.getLayoutY());

            c12c1.setStartX(c12.getLayoutX());
            c12c1.setStartY(c12.getLayoutY());
            c12c1.setEndX(c1.getLayoutX());
            c12c1.setEndY(c1.getLayoutY());
        }

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
