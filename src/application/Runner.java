package application;

import domain.*;

import java.util.Scanner;

public class Runner {
    FigureFactory figureFactory = new FigureFactory();
    Scanner scanner = new Scanner(System.in);
    private static final String[] COLORS = {
            "red",
            "blue",
            "yellow",
            "green",
            "magenta",
            "white"
    };

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.mainMenu();
    }

    public void mainMenu() {
        String menu = """
                1. Circle
                2. Square
                3. Triangle
                4. Pentagon
                5. Exit
                """;
        Figure figure = null;
        boolean flag = true;
        do {
            System.out.print(menu);
            char option = scanner.nextLine().charAt(0);

            switch (option) {
                case '1' -> {
                    flag = false;
                    figure = figureFactory.getFigure("circle");
                }
                case '2' -> {
                    flag = false;
                    figure = figureFactory.getFigure("square");
                }
                case '3' -> {
                    flag = false;
                    figure = figureFactory.getFigure("triangle");
                }
                case '4' -> {
                    flag = false;
                    figure = figureFactory.getFigure("pentagon");
                }
                case '5' -> System.exit(0);
                default -> {
                    System.out.println("Option invalid");
                }
            }

        } while (flag);
        if (figure != null) {
            figure.makeVisible();
            manageFigure(figure);
        }

    }

    public void manageFigure(Figure figure) {
        String menu = """
                What action do you want to perform?
                1. Make it invisible.
                2. Make it visible.
                3. Move it to the right.
                4. Move it to the left.
                5. Move it to the up.
                6. Move it to the down.
                7. Change color.
                8. Change the size.
                9. Exit.
                """;
        boolean flag = true;
        do {
            System.out.println(menu);
            char option = scanner.nextLine().charAt(0);
            switch (option) {
                case '1' -> figure.makeInvisible();
                case '2' -> figure.makeVisible();
                case '3' -> figure.moveRight();
                case '4' -> figure.moveLeft();
                case '5' -> figure.moveUp();
                case '6' -> figure.moveDown();
                case '7' -> {
                    boolean flagColor = true;
                    do {
                        System.out.println(
                                "Enter the color you want to change to [red, blue, yellow, green, magenta, white]: ");
                        String color = scanner.nextLine();
                        for (String colorInList : COLORS) {
                            if (colorInList.equals(color)) {
                                flagColor = false;
                                figure.changeColor(color);
                            } else {
                                System.out.println(
                                        "Invalid option, must be [red, blue, yellow, green, magenta, white]");
                            }
                        }
                    } while (flagColor);

                }
                case '8' -> {
                    boolean flagSize = true;
                    do {
                        try {
                            if (figure.getClass().equals(Circle.class) ||
                                figure.getClass().equals(Square.class)) {
                                System.out.println("Enter the new size of the figure: ");
                                String size = scanner.nextLine();
                                figure.changeSize(Integer.parseInt(size));
                            } else if (figure.getClass().equals(Triangle.class) ||
                                       figure.getClass().equals(Pentagon.class)) {
                                System.out.println("Enter the new width of the figure: ");
                                String width = scanner.nextLine();
                                System.out.println("Enter the new height of the figure: ");
                                String height = scanner.nextLine();
                                figure.changeSize(Integer.parseInt(width), Integer.parseInt(height));
                            }
                            flagSize = false;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid option, must be a number.");
                        }
                    } while (flagSize);

                }
                case '9' -> {
                    figure.erase();
                    flag = false;
                    mainMenu();
                }
                default -> System.out.println("Invalid option, must be 1-9");
            }
        } while (flag);

    }
}
