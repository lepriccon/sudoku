import java.util.*;

public class SudokuSquare {
    private final int size;
    private Integer[] body;

    SudokuSquare(SudokuSizes sudokuSize) {
        this.size = sudokuSize.size;
        this.body = new Integer[size * size];
        //this.squareBody = new int[size][size];
        //this.body = Arrays.asList(new Integer[size * size]);
    }

    private SudokuSquare(int size) {
        this.size = size;
        this.body = new Integer[size * size];
        //this.squareBody = new int[size][size];
        //this.body = Arrays.asList(new Integer[size * size]);
    }

    public Integer getOne(int row, int column) {
        return body[(row * size) + column];
    }

    public List<Integer> getRow(int rowNumber) {
        int pointer = rowNumber * size;
        Integer[] row = Arrays.copyOfRange(body, pointer, pointer + size);
        return Arrays.asList(row);
    }

//    public List<Integer> getRow(int row) {
//        return Arrays.asList(body);
//    }

    public List<Integer> getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            column.add(body[i * size + columnNumber]);
        }
        return column;
    }

//    public List<Integer> getColumn(int column) {
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            result.add(body[i][column]);
//        }
//        return result;
//    }

    public SudokuSquare hideSomeNumbers() {
        Random rand = new Random();
        SudokuSquare result = new SudokuSquare(this.size);
        int numbersToHide = rand.nextInt(size, size * 2);
        Set<Integer> randomIndexes = new HashSet<>();
        getRandomIndexes(randomIndexes, numbersToHide, rand);
        for (Integer index : randomIndexes){
            body[index] = 0;
        }
        return result;
    }

    private void getRandomIndexes(Set<Integer> indexes, int setSize, Random random){
        while (indexes.size() < setSize) {
            if (!indexes.add(random.nextInt(size*2))){
                getRandomIndexes(indexes, setSize, random);
            }
        }
    }

//    public void fillSquare(List<Integer> numbers) {
//        this.body = new ArrayList<>(numbers);
//        int i = 0;
//    }

    public void fillSquare(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            body[i] = numbers.get(i);
        }
    }
}
