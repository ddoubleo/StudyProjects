import java.util.Arrays;

class ticTacToe {
    private char[][] game;
    private int size;
    private int longestSequence = 1;
    private boolean containsNull = false;
    private boolean containsCross = false;
    private boolean lsWasChanged = false;

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
        if (flag) {
            game[yCoordinate - 1][xCoordinate - 1] = '✕';
            containsCross = true;
        } else {
            game[yCoordinate - 1][xCoordinate - 1] = 'O';
            containsNull = true;
        }
    }

    void clear(int xCoordinate, int yCoordinate) {
        game[yCoordinate - 1][xCoordinate - 1] = '-';
    }

    int[] longestCross() { //Возвращает массив с координатами начала, конца и длиной последовательности; пустой массив - таких элементов нет
        longestSequence = 1;
        int[] check = {0, 0, 0, 0};
        int[] result = new int[0];
        int[] res = new int[0];
        if (!containsCross) return result;
        int[] singleCross = new int[4];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (game[i][j] == '✕') {
                    res = Arrays.copyOf(scan(i, j), 4);
                    if (!Arrays.equals(check, res)) {
                        if (lsWasChanged) {
                            result = Arrays.copyOf(res, 5);
                            result[4] = longestSequence;
                        }
                    } else {
                        singleCross = new int[]{j, i, j, i, 1};
                    }
                }
            }
        }
        if (result.length != 0) return result;
        else return singleCross;
    }


    int[] longestNull() { //Возвращает массив с координатами начала, конца и длиной последовательности; пустой массив - таких элементов нет
        longestSequence = 1;
        int[] check = {0, 0, 0, 0};
        int[] result = new int[0];
        int[] res = new int[0];
        if (!containsNull) return result;
        int[] singleNull = new int[4];
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (game[i][j] == 'O') {
                    res = Arrays.copyOf(scan(i, j), 4);
                    if (!Arrays.equals(check, res)) {
                        if (lsWasChanged) {
                            result = Arrays.copyOf(res, 5);
                            result[4] = longestSequence;
                        }
                    } else {
                        singleNull = new int[]{j, i, j, i, 1};
                    }
                }
            }
        }
        if (result.length != 0) return result;
        else return singleNull;
    }

    private int[] scan(int x, int y) {
        lsWasChanged = false;
        int[] result = new int[4];
        int count = 1;
        for (int i1 = x + 1; i1 < size; i1++) { //horizontal
            if (game[i1][y] == game[i1 - 1][y]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    lsWasChanged = true;
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
                    lsWasChanged = true;
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
        for (int i1 = x + 1, j1 = y + 1; i1 < size && j1 < size; j1++, i1++) { //diagonal_1
            if (game[i1][j1] == game[i1 - 1][j1 - 1]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    lsWasChanged = true;
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
        for (int i1 = x - 1, j1 = y + 1; i1 > 0 && j1 < size; j1++, i1--) { //diagonal_2
            if (game[i1][j1] == game[i1 + 1][j1 - 1]) {
                count++;
                if (count > longestSequence) {
                    longestSequence = count;
                    lsWasChanged = true;
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
