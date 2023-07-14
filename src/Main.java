
public class Main {
    public static void main(String[] args) {
        SudokuBoard sudokuBoard = SudokuBoard.builder(SudokuSizes.SMALL);
        SudokuGenerator.generate(sudokuBoard);
        System.out.println(sudokuBoard);
    };
}