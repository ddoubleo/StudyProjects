package First;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TicTacToe game2 = new TicTacToe();
        /*game2.print();
        game2.add("Cross", 1, 1);
        game2.add("Cross", 2, 2);
        game2.add("Null", 1, 3);
        game2.add("Cross", 3, 3);
        game2.print();
        //first.longestCross();
        System.out.println(Arrays.toString(game2.longest("Cross")));
        //System.out.println(Arrays.toString(game2.longest("Null")));
    }*/
        game2.add("x", 5, 5);
        game2.add("x", 4, 5);
        game2.add("x", 2, 5);
        game2.add("o", 2, 2);
        game2.add("o", 1, 1);
        game2.add("o", 3, 3);
        game2.add("o", 4, 4);
        System.out.println(game2);
        System.out.println(Arrays.toString(game2.longest("Cross")));
        System.out.println(Arrays.toString(game2.longest("Null")));
    }
}
