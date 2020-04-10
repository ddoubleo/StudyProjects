package First;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import java.util.Arrays;

class TicTacToeTest {
    First.TicTacToe testGame = new TicTacToe();

    @Test
    void testLongest1(){
        testGame.add("Cross", 1, 1);
        testGame.add("Cross", 2, 2);
        testGame.add("Null", 1, 3);
        testGame.add("Cross", 3, 3);
        int[] second = new int[]{1,1,3,3,3};
        int[] third = new int[]{1,3,1,3,1};
        System.out.println(testGame);
        assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));
        assertEquals(Arrays.toString(third),Arrays.toString(testGame.longest("Null")));
    }
    @Test
    void testLongest2(){
        testGame.cleanAll();
        testGame.add("x", 5, 5);
        testGame.add("x", 4, 5);
        testGame.add("x", 2, 5);
        testGame.add("o", 2, 2);
        testGame.add("o", 1, 1);
        testGame.add("o", 3, 3);
        testGame.add("o", 4, 4);
        System.out.println(testGame);
        int[] second = new int[]{4,5,5,5,2};
        int[] third = new int[]{1,1,4,4,4};
        assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));
        assertEquals(Arrays.toString(third),Arrays.toString(testGame.longest("Null")));


    }
    @Test
    void testLongest3(){
        testGame.cleanAll();
        testGame.add("X",5,1);
        testGame.add("X",5,2);
        testGame.add("x",5,3);
        int[] second = new int[]{5,1,5,3,3};
        assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));

    }
}


