package com.tictactoe;

public class BotMoveStrategy implements MoveStrategy {
    @Override
    public void makeMove(Board board, Player player) {
        boolean moveMade = false;

        while (!moveMade) {
            int row = (int) (Math.random() * board.getSize());
            int col = (int) (Math.random() * board.getSize());
            moveMade = board.makeMove(row, col, player);
        }

        System.out.println("Bot played at a random position.");
    }
}
