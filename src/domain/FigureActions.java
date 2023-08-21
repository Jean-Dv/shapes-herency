package domain;

public interface FigureActions {
    void draw();
    void erase();
    void changeSize(int size);
    void changeSize(int newWidth, int newHeight);
}
