public class Main {
    public static void main(String[] args) {
        ticTacToe first = new ticTacToe();
        first.print();
        first.add(true, 1, 1);
        first.add(true, 2, 2);
        first.add(true, 2, 3);
        first.add(false, 1, 3);
        first.clear(2, 3);
        first.add(true, 3, 3);
        first.print();
        first.longestCross();

    }
}
