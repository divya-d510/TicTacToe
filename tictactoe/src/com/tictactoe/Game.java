package com.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Player> players;
    private Board board;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size (e.g., 3 for 3x3): ");
        int gridSize = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();

        board = Board.getInstance(gridSize);
        players = new ArrayList<>();

        for (int i = 1; i <= gridSize - 1; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.next();
            players.add(PlayerFactory.createPlayer(name, "human", "P" + i));
        }

        for (int i = players.size() + 1; i <= gridSize; i++) {
            players.add(PlayerFactory.createPlayer("Bot " + i, "bot", "P" + i));
        }

        playGame(scanner);
    }

    private void playGame(Scanner scanner) {
        boolean isGameOver = false;
        int currentPlayerIndex = 0;

        while (!isGameOver) {
            board.display();
            Player currentPlayer = players.get(currentPlayerIndex);

            System.out.println(currentPlayer.getName() + "'s turn:");
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {
                board.display();
                System.out.println(currentPlayer.getName() + " wins!");
                isGameOver = true;
            } else if (board.isFull()) {
                board.display();
                System.out.println("It's a draw!");
                isGameOver = true;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}
