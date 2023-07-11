import java.util.*;

public class SudokuGenerator {

    public static void generate(SudokuBoard sudokuBoard) {
        fillBoard(
                GenerateSequence.generateSudoku(sudokuBoard.getSize(),
                        sudokuBoard.getSquareSize().size),
                sudokuBoard);
        sudokuBoard.createStartingCondition();
    }

    public static void fillBoard(int[][] body, SudokuBoard board) {
        List<Integer> squareBody = new ArrayList<>();
        int counter = 0;
        int rowMy;
        int collMy;
        for (int squareVert = 0; squareVert < board.getSquareSize().size; squareVert++) {
            for (int squareHor = 0; squareHor < board.getSquareSize().size; squareHor++) {
                for (int row = 0; row < board.getSquareSize().size; row++) {
                    for (int col = 0; col < board.getSquareSize().size; col++) {
                        rowMy = row + squareVert * board.getSquareSize().size;
                        collMy = col + squareHor * board.getSquareSize().size;
                        squareBody.add(body[rowMy][collMy]);
                    }
                }
                board.getSudokuBody().get(counter).fillSquare(squareBody);
                counter++;
                squareBody.clear();
            }
        }
    }

//    public static void fillBoard(int[][] body, SudokuBoard board) {
//        List<Integer> squareBody = new ArrayList<>();
//        int counter = 0;
//        for (int squareVert = 0; squareVert < board.getSquareSize().size; squareVert++) {
//            for (int squareHor = 0; squareHor < board.getSquareSize().size; squareHor++) {
//                for (int row = 0; row < board.getSquareSize().size; row++) {
//                    for (int col = 0; col < board.getSquareSize().size; col++) {
//                        int rowMy = row + squareVert * board.getSquareSize().size;
//                        int collMy = col + squareHor * board.getSquareSize().size;
//                        squareBody.add(body[rowMy][collMy]);
//                    }
//                }
//                board.getSudokuBody().get(counter).fillSquare(squareBody);
//                counter++;
//                squareBody.clear();
//            }
//        }
//    }

}
