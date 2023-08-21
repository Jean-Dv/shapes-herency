package application;

import domain.*;

public class FigureFactory {
    public Figure getFigure(String shape) {
        Figure figure = null;
        switch (shape) {
            case "circle" -> {
                figure = new Circle();
            }
            case "triangle" -> {
                figure = new Triangle();
            }
            case "square" -> {
                figure = new Square();
            }
            case "pentagon" -> {
                figure = new Pentagon();
            }
            default -> {
                return null;
            }
        }
        return figure;
    }
}
