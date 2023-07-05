import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateSequence {

    private static final int EMPTY_CELL = 0;


    public static int[][] generateSudoku(int size, int sqSize) {
        int[][] sudokuBoard = new int[size][size];
        fillSudoku(sudokuBoard, size, sqSize);
        return sudokuBoard;
    }

    public static void fillSudoku(int[][] sudokuBoard, int size, int sqSize) {
        fillBlock(sudokuBoard, 0, 0, size, sqSize);
    }

    public static boolean fillBlock(int[][] sudokuBoard, int row, int col, int size, int sqSize) {
        if (col >= size) {
            col = 0;
            row++;
            if (row >= size) {
                return true;
            }
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        for (int number : numbers) {
            if (isValidMove(sudokuBoard, row, col, number, size, sqSize)) {
                sudokuBoard[row][col] = number;
                if (fillBlock(sudokuBoard, row, col + 1, size, sqSize)) {
                    return true;
                }
                sudokuBoard[row][col] = EMPTY_CELL;
            }
        }

        return false;
    }

    public static boolean isValidMove(int[][] sudokuBoard, int row, int col, int number, int boardSize, int sqSize) {
        for (int i = 0; i < boardSize; i++) {
            if (sudokuBoard[row][i] == number || sudokuBoard[i][col] == number) {
                return false;
            }
        }

        int blockRow = row - row % sqSize;
        int blockCol = col - col % sqSize;

        for (int i = blockRow; i < blockRow + sqSize; i++) {
            for (int j = blockCol; j < blockCol + sqSize; j++) {
                if (sudokuBoard[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

}