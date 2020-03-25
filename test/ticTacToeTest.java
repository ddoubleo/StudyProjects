import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.*;

import java.util.Arrays;

class ticTacToeTest {
    ticTacToe first = new ticTacToe();

    @Test
    void testLongest(){
        first.add(true, 1, 1);
        first.add(true, 2, 2);
        first.add(false, 1, 3);
        first.add(true, 3, 3);
        int[] second = new int[]{1,1,3,3,3};
        int[] third = new int[]{1,3,1,3,1};
        assertEquals(Arrays.toString(second), Arrays.toString(first.longestCross()));
        assertEquals(Arrays.toString(third),Arrays.toString(first.longestNull()));
    }
}

