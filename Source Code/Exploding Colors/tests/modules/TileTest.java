/*
 * @author Wael M. Alghamdi
 * @version 1.0 04/12/18
 */
package modules;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    Tile t;
    @BeforeEach
    void setUp() {
        t = new Tile(1,1);
    }

    @AfterEach
    void tearDown() {
        t = null;
    }


    @Test
    void test_randColor() {
        int actual = t.randColor(1);
        assertTrue(actual >=1 && actual <= 1);
    }
    @Test
    void test_randColor_upto3() {
        int actual = t.randColor(3);
        assertTrue(actual >=1 && actual <= 3);
    }
}