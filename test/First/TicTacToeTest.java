package First;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import java.util.Arrays;

class TicTacToeTest {
    First.TicTacToe testGame = new TicTacToe();

    @Test
    void testLongest(){
        testGame.add("Cross", 1, 1);
        testGame.add("Cross", 2, 2);
        testGame.add("Null", 1, 3);
        testGame.add("Cross", 3, 3);
        int[] second = new int[]{1,1,3,3,3};
        int[] third = new int[]{1,3,1,3,1};
        assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));
        assertEquals(Arrays.toString(third),Arrays.toString(testGame.longest("Null")));
    }
}

