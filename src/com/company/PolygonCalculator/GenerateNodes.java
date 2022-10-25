package com.company.PolygonCalculator;

import com.company.PolygonCalculator.Main;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GenerateNodes {
    static Label DistanceL1 = new Label("Line 1 Distance: ");
    static Label DistanceL2 = new Label("Line 2 Distance: ");
    static Label DistanceL3 = new Label("Line 3 Distance: ");
    static Label DistanceL4 = new Label("Line 4 Distance: ");
    static Label DistanceL5 = new Label("Line 5 Distance: ");
    static Label DistanceL6 = new Label("Line 6 Distance: ");
    static Label DistanceL7 = new Label("Line 7 Distance: ");
    static Label DistanceL8 = new Label("Line 8 Distance: ");
    static Label DistanceL9 = new Label("Line 9 Distance: ");
    static Label DistanceL10 = new Label("Line 10 Distance: ");
    static Label DistanceL11 = new Label("Line 11 Distance: ");
    static Label DistanceL12 = new Label("Line 12 Distance: ");

    static Label L1Identity = new Label("L1");
    static Label L2Identity = new Label("L2");
    static Label L3Identity = new Label("L3");
    static Label L4Identity = new Label("L4");
    static Label L5Identity = new Label("L5");
    static Label L6Identity = new Label("L6");
    static Label L7Identity = new Label("L7");
    static Label L8Identity = new Label("L8");
    static Label L9Identity = new Label("L9");
    static Label L10Identity = new Label("L10");
    static Label L11Identity = new Label("L11");
    static Label L12Identity = new Label("L12");

    static Line c1c2 = new Line();
    static Line c2c3 = new Line();
    static Line c3c4 = new Line();
    static Line c4c5 = new Line();
    static Line c5c6 = new Line();
    static Line c6c7 = new Line();
    static Line c7c8 = new Line();
    static Line c8c9 = new Line();
    static Line c9c10 = new Line();
    static Line c10c11 = new Line();
    static Line c11c12 = new Line();
    static Line c12c1 = new Line();

    static TextField c1Field = new TextField();
    static TextField c2Field = new TextField();
    static TextField c3Field = new TextField();
    static TextField c4Field = new TextField();
    static TextField c5Field = new TextField();
    static TextField c6Field = new TextField();
    static TextField c7Field = new TextField();
    static TextField c8Field = new TextField();
    static TextField c9Field = new TextField();
    static TextField c10Field = new TextField();
    static TextField c11Field = new TextField();
    static TextField c12Field = new TextField();

    static int r = 5;
    static Circle c1 = new Circle(Main.x, Main.y, r);
    static Circle c2 = new Circle(Main.x, Main.y, r);
    static Circle c3 = new Circle(Main.x, Main.y, r);
    static Circle c4 = new Circle(Main.x, Main.y, r);
    static Circle c5 = new Circle(Main.x, Main.y, r);
    static Circle c6 = new Circle(Main.x, Main.y, r);
    static Circle c7 = new Circle(Main.x, Main.y, r);
    static Circle c8 = new Circle(Main.x, Main.y, r);
    static Circle c9 = new Circle(Main.x, Main.y, r);
    static Circle c10 = new Circle(Main.x, Main.y, r);
    static Circle c11 = new Circle(Main.x, Main.y, r);
    static Circle c12 = new Circle(Main.x, Main.y, r);

    //Labels for triangle info
    static Label areaLabel = new Label("Total Area: ");
    static Label pointsLeftLabel = new Label("12 Points Remaining");
    static Label identifier = new Label("Specific Coordinates: ");
    static Button submit = new Button("Submit");
    static Button clear = new Button("Clear");
    static Button startCalculation = new Button("Calculate");
    static Button toggleSnap = new Button("Snap Off");
    static Button factoryReset = new Button("Reset All");
}
