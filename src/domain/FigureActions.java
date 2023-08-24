package domain;

/**
 * This interface is to be implemented in the figure
 * class with certain necessary methods.
 *
 * @author camilaF20 (Camila Figueredo)
 * @author Jean-Dv (Jean Valencia)
 */
public interface FigureActions {
    /**
     * Draw the figure
     */
    void draw();

    /**
     * Erase the figure
     */
    void erase();

    /**
     * Change the size to the new size. Size must be >= 0
     *
     * @param size new figure size
     */
    void changeSize(int size);

    /**
     * Change the size to the new size. Size must be >= 0.
     *
     * @param newWidth new figure width size
     * @param newHeight new figure height size
     */
    void changeSize(int newWidth, int newHeight);
}
