import java.util.*;

public class SudokuBoard {

    private final int size;
    private SudokuSizes squareSize;
    private List<SudokuSquare> body;

    private SudokuBoard(SudokuSizes sizes) {
        int currentSize = sizes.size;
        this.squareSize = sizes;
        this.size = currentSize * currentSize;
        this.body = fillSudokuBody(sizes);
    }

    public static SudokuBoard builder(SudokuSizes sudokuSizes) {
        return new SudokuBoard(sudokuSizes);
    }

    private List<SudokuSquare> fillSudokuBody(SudokuSizes size) {
        List<SudokuSquare> squares = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            squares.add(new SudokuSquare(size));
        }
        return squares;
    }

    public List<Integer> getRow(int rowNumber) {
        List<Integer> row = new ArrayList<>();
        int[] sqAndRow = getIndexRowInSquare(rowNumber);
        for (int square = 0; square < squareSize.size; square++) {
            row.addAll(body.get(squareSize.size * sqAndRow[0] + square).getRow(sqAndRow[1]));
        }
        return row;
    }

    private int[] getIndexRowInSquare(int pointer) {
        if (pointer < 0 || pointer > size) {
            throw new IllegalArgumentException();
        }
        return new int[]{pointer / squareSize.size, pointer % squareSize.size};
    }

    public List<Integer> getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        int[] sqAndColumn = getIndexRowInSquare(columnNumber);
        for (int square = sqAndColumn[0]; square < squareSize.size*squareSize.size; square +=squareSize.size) {
            column.addAll(body.get(square).getColumn(sqAndColumn[1]));
        }
        return column;
    }

    public int getSize() {
        return size;
    }

    public SudokuSizes getSquareSize() {
        return squareSize;
    }

    public List<SudokuSquare> getSudokuBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        String currentRow;
        for (int row = 0; row < size; row++) {
            currentRow = getRow(row).toString();
            stringBuffer.append(currentRow.replace("null", "0"));
            stringBuffer.append("\n");
        }
        return "SudokuField{\n" + stringBuffer;
    }
}
