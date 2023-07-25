import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player : " + player + " Enter row and col (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
                System.out.println("Invalid Move: Try Again !!");
            } else if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player) || isDraw(board);
                if (gameOver) {
                    printBoard(board);
                    if (haveWon(board,player)) {
                        System.out.println("Player " + player + " is the Winner!!");
                    } else if(isDraw(board)) {
                        System.out.println("It's a Draw!");
                    }
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move: Cell is already occupied. Try Again!");
            }
        }

        sc.close();
    }

    static void printBoard(char board[][]) {
        System.out.println();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                
                System.out.print(board[row][col]);
                if(col!=2){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean haveWon(char board[][], char player) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isDraw(char board[][]) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == ' ') {
                    return false; // If there is an empty cell, the board is not full
                }
            }
        }
        return true; // All cells are occupied, board is full
    }
}
