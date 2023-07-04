import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSquare {
    private final int size;
    private boolean isFull;
    //private final int[][] squareBody;
    private List<Integer> body;

    SudokuSquare(SudokuSizes parameter) {
        this.isFull = false;
        this.size = parameter.size;
        //this.squareBody = new int[size][size];
        this.body = Arrays.asList(new Integer[size * size]);
    }

    public Integer getOne(int row, int column) {
        return body.get((row * size) + column);
    }

    public List<Integer> getRow(int rowNumber) {
        int pointer = rowNumber * size;
        List<Integer> row = body.subList(pointer, pointer + size);
        return row;
    }

    public List<Integer> getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            column.add(body.get(i * size + columnNumber));
        }
        return column;
    }

    public void fillSquare(List<Integer> numbers) {
        this.body = new ArrayList<>(numbers);
        int i = 0;
    }

}
