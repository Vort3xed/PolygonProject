package com.company.PolygonCalculator;

public class CalculateArea {
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
}
