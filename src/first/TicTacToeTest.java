package first;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import java.util.Arrays;

class TicTacToeTest {
    first.TicTacToe testGame = new TicTacToe(6);
    first.TicTacToe testGame2 = new TicTacToe(4);

    @Test
    void testLongest1(){
        testGame2.add("Cross", 1, 1);
        testGame2.add("Cross", 2, 2);
        testGame2.add("Null", 1, 3);
        testGame2.add("Cross", 3, 3);
        int[] second = new int[]{1,1,3,3,3};
        int[] third = new int[]{1,3,1,3,1};
        //System.out.println(testGame2);
        Assertions.assertEquals(Arrays.toString(second), Arrays.toString(testGame2.longest("Cross")));
        Assertions.assertEquals(Arrays.toString(third),Arrays.toString(testGame2.longest("Null")));
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
        //System.out.println(testGame);
        int[] second = new int[]{4,5,5,5,2};
        int[] third = new int[]{1,1,4,4,4};
        Assertions.assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));
        Assertions.assertEquals(Arrays.toString(third),Arrays.toString(testGame.longest("Null")));


    }
    @Test
    void testLongest3(){
        testGame.cleanAll();
        testGame.add("X",5,1);
        testGame.add("X",5,2);
        testGame.add("x",5,3);
        //System.out.println(testGame);
        int[] second = new int[]{5,1,5,3,3};
        Assertions.assertEquals(Arrays.toString(second), Arrays.toString(testGame.longest("Cross")));

    }
}


