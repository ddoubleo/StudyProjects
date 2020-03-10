import java.util.Arrays;

class ticTacToe {
    private char[][] game;
    private int size;
    private int longestSequence = 0;

    ticTacToe() {
        size = 5;
        game = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = '-';
            }
        }
    }

    void print() {
        System.out.println(Arrays.deepToString(game)
                .replace("],", "\n").replace(",", "\t| ")
                .replaceAll("[\\[\\]]", " "));
        System.out.println("\n");
    }

    void add(boolean flag, int xCoordinate, int yCoordinate) {
        if (flag) game[yCoordinate - 1][xCoordinate - 1] = '✕';
        else game[yCoordinate - 1][xCoordinate - 1] = 'O';
    }

    void clear(int xCoordinate, int yCoordinate) {
        game[yCoordinate - 1][xCoordinate - 1] = '-';
    }

    int[] longestCross() {
        int[] kostil = {0, 0, 0, 0};
        int[] result = new int[0];
        int[] res = new int[0];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (game[i][j] == '✕') res = scan(i, j);
                if (!Arrays.equals(kostil, res)) result = res;
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.print(longestSequence);
        return result;

    }

    private int[] longestNull() {
        int[] kostil = {0, 0, 0, 0};
        int[] result = new int[0];
        int[] res = new int[0];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (game[i][j] == 'O') res = scan(i, j);
                if (!Arrays.equals(kostil, res)) result = res;
            }
        }
        System.out.println(Arrays.toString(result));
        System.out.print(longestSequence);
        return result;

    }

    private int[] scan(int x, int y) {
        int[] result = new int[4];
        int count = 1;
        for (int i1 = x + 1; i1 < size; i1++) { //horizontal
            if (game[i1][y] == game[i1 - 1][y]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = i1 + 1;
                    result[3] = y + 1;
                }
            } else {
                count = 1;
                break;

            }

        }
        count = 1;
        for (int i1 = y + 1; i1 < size; i1++) { //vertical
            if (game[x][i1] == game[x][i1 - 1]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = x + 1;
                    result[3] = i1 + 1;
                }
            } else {
                count = 1;
                break;

            }
        }
        count = 1;
        for (int i1 = x + 1, j1 = y + 1; i1 < size && j1 < size; j1++, i1++) { //diagonal1
            if (game[i1][j1] == game[i1 - 1][j1 - 1]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = i1 + 1;
                    result[3] = j1 + 1;
                }
            } else {
                count = 1;
                break;

            }
        }
        count = 1;
        for (int i1 = x - 1, j1 = y + 1; i1 > 0 && j1 < size; j1++, i1--) { //diagonal2
            if (game[i1][j1] == game[i1 + 1][j1 - 1]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = i1 + 1;
                    result[3] = j1 + 1;
                }
            } else {
                count = 1;
                break;

            }
        }

        return result;
    }

}
