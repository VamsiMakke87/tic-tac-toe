import Model.Board;
import Model.PieceType;
import Model.PlayingPiece;
import Model.PlayingPieceFactory;

import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        Deque<PlayingPiece> dq = new ArrayDeque<>();
        Set<String> availablePlayingPiece = new HashSet<>();
        availablePlayingPiece.add("X");
        availablePlayingPiece.add("O");

        int numberOfPlayers;

        while (true) {
            System.out.println("Enter number of players:");
            numberOfPlayers = sc.nextInt();
            if (numberOfPlayers > availablePlayingPiece.size()) {
                System.out.println("Max " + availablePlayingPiece.size() + " players");
            } else {
                break;
            }
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter player " + i + " name");
            String name = sc.next().toUpperCase();
            String playingPiece;
            while (true) {
                System.out.println("Enter Playing Piece: " + availablePlayingPiece);
                playingPiece = sc.next();

                if (availablePlayingPiece.contains(playingPiece)) {
                    availablePlayingPiece.remove(playingPiece);
                    break;
                }
                System.out.println("Please choose from available set of playing piece");

            }
            PlayingPiece p = PlayingPieceFactory.getPlayingPiece(playingPiece, name);


            dq.add(p);
        }


        Board boardObj = new Board(3);
        char[][] board = boardObj.getBoard();
        printBoard(board);

        System.out.println(play(board, dq));

    }

    private static String play(char[][] board, Deque<PlayingPiece> dq) {


        int size = board.length;
        int turns = size * size;

        while (turns-- != 0) {

            PlayingPiece currPlayer = dq.removeFirst();
            try {
                System.out.println(currPlayer.name + "'s turn");
                System.out.println("Enter where do you want to put " + currPlayer.pieceType);
                int i = sc.nextInt();
                int j = sc.nextInt();

                if (validMove(board, i, j, currPlayer.pieceType)) {
                    printBoard(board);
                    if (checkWinner(board)) return currPlayer.name + " won";
                    dq.addLast(currPlayer);
                } else {
                    System.out.println("Place already taken! Please try again");
                    dq.addFirst(currPlayer);
                }
            } catch (Exception e) {
                dq.addFirst(currPlayer);
                System.out.println("Input must be between 0 and " + (board.length - 1));
            }

        }

        return "Tie";
    }

    private static boolean tie(char[][] board) {
        int size = board.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '\0') return false;
            }
        }

        return true;
    }

    private static boolean checkWinner(char[][] board) {
        int size = board.length;
        outer:
        for (int i = 0; i < size; i++) {
            char curr = board[i][0];
            if (curr == '\0') continue;
            for (int j = 0; j < size; j++) {
                if (curr != board[i][j]) continue outer;
            }
            return true;
        }


        outer:
        for (int i = 0; i < size; i++) {
            char curr = board[0][i];
            if (curr == '\0') continue;
            for (int j = 0; j < size; j++) {
                if (curr != board[j][i]) continue outer;
            }
            return true;
        }

        char curr = board[0][0];
        boolean winner = false;
        for (int i = 0; i < size && curr != '\0'; i++) {
            if (curr != board[i][i]) {
                winner = false;
                break;
            }
            winner = true;
        }

        curr = board[0][size - 1];
        if (winner) return true;

        for (int i = 0; i < size && curr != '\0'; i++) {
            if (curr != board[i][size - i - 1]) {
                winner = false;
                break;
            }
            winner = true;
        }
        return winner;
    }

    private static boolean validMove(char[][] board, int i, int j, PieceType playingPiece) {

        if (board[i][j] != '\0') return false;
        board[i][j] = playingPiece.toString().charAt(0);
        return true;

    }


    public static void printBoard(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] != '\0' ? board[i][j] : " ");
                if (j != size - 1) System.out.print(" |");
                else System.out.println();
            }
            if (i != size - 1)
                System.out.println("__ __ __");
        }

    }

}
