package First;

import java.util.Arrays;
import java.util.Map;

class TicTacToe {
    private int[][] game;
    private int size;
    private int longestSequence = 1;
    private boolean containsNull = false;
    private boolean containsCross = false;
    private boolean lsWasChanged = false;
    //private int currentLength = 1;
    private Map<String, Integer> referenceTable = Map.of("Cross", 1,
            "cross", 1,
            "x", 1,
            "X", 1,
            "Null", 2,
            "o", 2,
            "O", 2,
            "0", 2,
            "null", 2);

    TicTacToe() {
        size = 5;
        game = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = 0;
            }
        }
    }

    @Override
    public String toString() {
        return (String.format(Arrays.deepToString(game)
                .replace("],", "\n").replace(",", "\t| ")
                .replaceAll("[\\[\\]]", " ").replaceAll("0", " ")
                .replaceAll("1", "X").replaceAll("2", "O")));
    }
    /*void print() {
        System.out.println(Arrays.deepToString(game)
                .replace("],", "\n").replace(",", "\t| ")
                .replaceAll("[\\[\\]]", " "));
        System.out.println("\n");
}*/

    public void cleanAll() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = 0;
            }
        }
    }

    public void add(String flag, int xCoordinate, int yCoordinate) {
        if (referenceTable.get(flag) == 1) {
            containsCross = true;
        } else {
            containsNull = true;
        }

        game[yCoordinate - 1][xCoordinate - 1] = referenceTable.get(flag);

    }

    public void clean(int xCoordinate, int yCoordinate) {
        game[yCoordinate - 1][xCoordinate - 1] = 0;
    }

    public int[] longest(String flag) {  //Возвращает координаты начала, конца и длину последовательности символов
        longestSequence = 1;
        int[] check = {0, 0, 0, 0};
        int[] result = new int[0];
        int[] res;
        if (referenceTable.get(flag) == 1) {
            if (!containsCross) return result;
        } else if (!containsNull) return result;
        int[] singleElement = new int[4];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (referenceTable.get(flag) == game[i][j]) {
                    res = Arrays.copyOf(scan(i, j), 4);
                    if (!Arrays.equals(check, res)) {
                        if (lsWasChanged) {
                            result = Arrays.copyOf(res, 5);
                            result[4] = longestSequence;
                        }
                    } else {
                        singleElement = new int[]{j + 1, i + 1, j + 1, i + 1, 1};
                    }
                }
            }
        }
        if (result.length != 0) return result;
        else return singleElement;
    }

    private int[] scan(int x, int y) {
        lsWasChanged = false;
        int[] result = new int[4];
        int currentLength = 1;
        for (int i1 = x + 1; i1 < size; i1++) { //horizontal
            if (game[i1][y] == game[i1 - 1][y]) {
                currentLength++;
                if (currentLength > longestSequence) {
                    longestSequence = currentLength;
                    lsWasChanged = true;
                    result[0] = y + 1;
                    result[1] = x + 1;
                    result[2] = y + 1;
                    result[3] = i1 + 1;
                }
            } else {
                currentLength = 1;
                break;

            }

        }
        currentLength = 1;
        for (int i1 = y + 1; i1 < size; i1++) { //vertical
            if (game[x][i1] == game[x][i1 - 1]) {
                currentLength++;
                if (currentLength > longestSequence) {
                    longestSequence = currentLength;
                    lsWasChanged = true;
                    result[0] = y + 1;
                    result[1] = x + 1;
                    result[2] = i1 + 1;
                    result[3] = x + 1;
                }
            } else {
                currentLength = 1;
                break;

            }
        }
        currentLength = 1;
        for (int i1 = x + 1, j1 = y + 1; i1 < size && j1 < size; j1++, i1++) { //diagonal_1
            if (game[i1][j1] == game[i1 - 1][j1 - 1]) {
                currentLength++;
                if (currentLength > longestSequence) {
                    longestSequence = currentLength;
                    lsWasChanged = true;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = i1 + 1;
                    result[3] = j1 + 1;
                }
            } else {
                currentLength = 1;
                break;

            }
        }
        currentLength = 1;
        for (int i1 = x - 1, j1 = y + 1; i1 >= 0 && j1 < size; j1++, i1--) { //diagonal_2
            if (game[i1][j1] == game[i1 + 1][j1 - 1]) {
                currentLength++;
                if (currentLength > longestSequence) {
                    longestSequence = currentLength;
                    lsWasChanged = true;
                    result[0] = x + 1;
                    result[1] = y + 1;
                    result[2] = i1 + 1;
                    result[3] = j1 + 1;
                }
            } else {
                currentLength = 1;
                break;

            }
        }

        return result;
    }

}
