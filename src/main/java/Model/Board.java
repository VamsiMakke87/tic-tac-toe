package Model;

public class Board {

    char board[][];
    int size;

    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
    }


    public char[][] getBoard() {
        return board;
    }
}
