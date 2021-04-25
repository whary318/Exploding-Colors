/*
 * @author Wael M. Alghamdi
 * @version 1.0 04/12/18
 */
package modules;

import java.util.HashSet;

public class Board {

    int minNumOfMatches, rows, cols;
    Tile[][] boardTiles;
    HashSet<Tile> tileMatches;

    public Board (int boardSize_rows, int boardSize_Columns, int minNumOfMatches) {
        rows = boardSize_rows;
        cols = boardSize_Columns;
        boardTiles = new Tile[boardSize_rows][boardSize_Columns];
        this.minNumOfMatches = minNumOfMatches;
        while(!isMatchAvailable())
            createBoard();
    }

    private void createBoard() {
        for (int i = 0; i < rows; i++)
            for (int a = 0; a < cols; a++)
                boardTiles[i][a] = new Tile(i, a);
    }
    private boolean isMatchAvailable() {
        //4 is for the 4 colors we have
        for (int i = 0; i < 4; i++) {
            tileMatches = new HashSet<>();
            locateNeighbors(1, 1, i, tileMatches);
            if (tileMatches.size() >= minNumOfMatches)
                return true;
        }
        return false;
    }

    public boolean checkClickedTile(Tile clickedTile) {
        tileMatches = new HashSet<>();
        locateNeighbors(clickedTile.getRow(),clickedTile.getColumn(),clickedTile.getColor(), tileMatches);
        if (tileMatches.size() >= minNumOfMatches){
            deleteTiles();
            pushTilesDown();
            createNewTiles();
            return true;
        }
        return false;
    }
    private void createNewTiles() {
        for (int i = 0; i < rows; i++)
            for (int a = 0; a < cols; a++)
                if(boardTiles[i][a] == null)
                    boardTiles[i][a] = new Tile(i, a);
    }
    private void pushTilesDown() {
        for (int a = 0; a < cols; a++)
            for (int i = 0; i < rows - 1; i++)
                if(boardTiles[i][a] == null) {
                    boardTiles[i][a] = boardTiles[i + 1][a];
                    boardTiles[i + 1][a] = null;
                }
    }
    private void deleteTiles() {
        for (int i = 0; i < rows; i++)
            for (int a = 0; a < cols; a++)
                if(tileMatches.contains(boardTiles[i][a]))
                    boardTiles[i][a] = null;
    }

    public void locateNeighbors(int row, int col, int color, HashSet<Tile> matches) {

        Tile b = boardTiles[row][col];
        if (matches.contains(b))
            return;
        else
            matches.add(b);

        // check NORTH
        if (isNorthMatch (row, col, color)) {
            locateNeighbors(row + 1, col, color, matches);
        }
        // check SOUTH
        if (isSouthMatch (row, col, color)) {
            locateNeighbors(row - 1, col, color, matches);
        }
        // check EAST
        if (isEastMatch (row, col, color)) {
            locateNeighbors(row, col + 1, color, matches);
        }// check WEST
        if (isWestMatch (row, col, color)) {
            locateNeighbors(row, col - 1, color, matches);
        }
    }
    private boolean isNorthMatch (int row, int col, int color) {
        if (row >= 0
                && row <= rows - 2
                && boardTiles[row + 1][col] != null
                && boardTiles[row + 1][col].getColor() == color)
            return true;
        else
            return false;
    }
    private boolean isSouthMatch (int row, int col, int color) {
        if (row >= 1
                && row <= rows - 1
                && boardTiles[row - 1][col] != null
                && boardTiles[row - 1][col].getColor() == color)
            return true;
        else
            return false;
    }
    private boolean isEastMatch (int row, int col, int color) {
        if (col >= 0
                && col <= cols - 2
                && boardTiles[row][col + 1] != null
                && boardTiles[row][col + 1].getColor() == color)
            return true;
        else
            return false;
    }
    private boolean isWestMatch (int row, int col, int color) {
        if (col >= 1
                && row <= cols - 1
                && boardTiles[row][col - 1] != null
                && boardTiles[row][col - 1].getColor() == color)
            return true;
        else
            return false;
    }

}
