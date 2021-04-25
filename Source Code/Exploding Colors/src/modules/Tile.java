/*
 * @author Wael M. Alghamdi
 * @version 1.0 04/12/18
 */
package modules;

public class Tile {

    private int column, row, color, type;

    public Tile (int row, int column) {
        this.column = column;
        this.row = row;
        color = randColor(4);
        type = randType(60, 70);
    }

    //red = 1, green = 2, purple = 3, black = 4
    public int randColor (int numOfColors) {
        int colorNum;
        colorNum = (int) (Math.random() * numOfColors + 1);
        return colorNum;
    }

    // normal = 1, bomb = 2 with a chance given
    private int randType (int chanceOfBombRangeFrom, int ChanceOfBombRangeTo) {
        int temp;
        temp = (int) (Math.random() * 100);
        if ((temp <= chanceOfBombRangeFrom) && (temp >= ChanceOfBombRangeTo) )
            return 2;
        else
            return 1;

    }

    //Getters
    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getColor() {
        return color;
    }

    public int getType() {
        return type;
    }

}
