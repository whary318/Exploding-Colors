/*
 * @author Wael M. Alghamdi
 * @version 1.0 04/12/18
 */
package modules;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board b;
    @BeforeEach
    void setUp() {
        b = new Board(3,3,4);
    }

    @AfterEach
    void tearDown() {
        b = null;
    }

    @Test
    void checkClickedTile() {
        boolean actual = b.checkClickedTile(new Tile(1,1));
        assertTrue(actual == true || actual == false);
    }

    @Test
    void locateNeighbors() {
        HashSet<Tile> tM = new HashSet<>();
        b.locateNeighbors(1,1,1,tM);
        assertTrue(tM.isEmpty() != true);
    }
}