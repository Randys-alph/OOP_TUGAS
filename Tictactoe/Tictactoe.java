package Tictactoe;

import java.util.Scanner;

public class Tictactoe {
    public static boolean gameEnd = false;
    public static Scanner scanner = new Scanner(System.in);
    public static char board[] = {
        '_', '_', '_',
        '_', '_', '_',
        '_', '_', '_'
    };
    
    public static int winingMoves[][] = {
        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Vertical
        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontal
        {0, 4, 8}, {2, 4, 6}             // Diagonal
    };

    public static int turn = 0; // 0 = Player 1 (O), 1 = Player 2 (X)

    public static void main(String[] args) {
        startGame();
    }
    
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j] + " ");
            }
            System.out.println();
        }
    }
    
    public static char getPlayerSign() {
        return turn == 0 ? 'O' : 'X';
    }
    
    public static boolean isTie() {
        for (char c : board) {
            if (c == '_') {
                return false; // Masih ada ruang kosong
            }
        }
        return true; // Semua slot terisi, berarti seri
    }
    
    public static boolean placeMove(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) return false;
        if (board[y * 3 + x] != '_') return false;

        board[y * 3 + x] = getPlayerSign();
        return true;
    }
    
    public static String getPlayerName() {
        return turn == 0 ? "Player 1" : "Player 2";
    }
    
    public static void play() {
        int x, y;
        boolean validMove;

        do {
            System.out.println(getPlayerName() + " move (x y): ");
            x = scanner.nextInt();
            y = scanner.nextInt();
            
            validMove = placeMove(x, y);
            if (!validMove) {
                System.out.println("Invalid move! Try again.");
            }
        } while (!validMove);

        printBoard();

        // Simpan pemain sebelum giliran berpindah
        char currentSign = getPlayerSign();

        // Cek kemenangan
        if (checkWin(currentSign)) {
            gameEnd = true;
            System.out.println(getPlayerName() + " WIN");
            return;
        }

        // Cek seri
        if (isTie()) {
            gameEnd = true;
            System.out.println("Game is Tie!");
            return;
        }

        // Ganti giliran setelah langkah valid
        turn = (turn == 0) ? 1 : 0;
    }
    
    public static boolean checkWin(char playerSign) {
        for (int i = 0; i < 8; i++) {
            if (board[winingMoves[i][0]] == playerSign &&
                board[winingMoves[i][1]] == playerSign &&
                board[winingMoves[i][2]] == playerSign) {
                return true;
            }
        }
        return false;
    }

    public static void startGame() {
        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();
        
        while (!gameEnd) {
            play();
        }
    }
}
