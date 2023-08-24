package application;

import domain.*;

/**
 * The FigureFactory class provides the call of
 * constructors to interact with the user.
 *
 * @author camilaF20 (Camila Figueredo)
 * @author Jean-Dv (Jean Valencia)
 */
public class FigureFactory {

    /**
     * Method to get the Figure
     *
     * @param shape
     * @return The instance of the figure, otherwise null.
     */
    public Figure getFigure(String shape) {
        Figure figure = null;
        switch (shape) {
            case "circle":{
                return figure = new Circle();
            }
            case "triangle": {
                return figure = new Triangle();
            }
            case "square": {
                return figure = new Square();
            }
            case "pentagon": {
                return figure = new Pentagon();
            }
            default: {
                return null;
            }
        }
    }
}
