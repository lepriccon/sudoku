
public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = SudokuBoard.builder(SudokuSizes.LARGE);
        SudokuGenerator.fillArea(sudokuBoard);
        System.out.println(sudokuBoard);
    };
}