class ticTacToe {
    private char[][] game;
    private int size;
    private int longestSequence = 0;

    ticTacToe() {
        int size = 3;
        game = new char[size][size];
    }

    private void add(boolean flag, int xCoordinate, int yCoordinate) {
        if (flag) game[xCoordinate][yCoordinate] = '✕';
        else game[xCoordinate][yCoordinate] = 'O';
    }

    private void clear(int xCoordinate, int yCoordinate) {
        game[xCoordinate][yCoordinate] = 0;
    }

    private String longestCross() {
        int longestCross = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (game[i][0] == '✕') {
                for (int i1 = i + 1; i < size; i++) { //horizontal
                    if (game[i1][0] == game[i1 - 1][0]) count++;
                    if (count > longestCross) longestCross = count;
                }
                for (int j1 = 1; j1 < size; j1++) { //vertical
                    if (game[i][j1] == game[i][j1 - 1]) count++;
                    if (count > longestCross) longestCross = count;
                }

            } else continue;
        }
        return "123";
    }

    public String horizontal() {
    }
    public String vertical {}
    public String diagonal {}
}