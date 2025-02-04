package com.tictactoe;

import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {
    @Override
    public void makeMove(Board board, Player player) {
        Scanner scanner = new Scanner(System.in);
        boolean moveMade = false;

        while (!moveMade) {
            System.out.print("Enter row and column (0-indexed): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            moveMade = board.makeMove(row, col, player);
            if (!moveMade) {
                System.out.println("Invalid move. Try again.");
            }
        }
    }
}
