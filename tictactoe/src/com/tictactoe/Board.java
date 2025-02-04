package com.tictactoe;

public class Board {
    private static Board instance;
    private String[][] grid;

    private Board(int size) {
        grid = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public static Board getInstance(int size) {
        if (instance == null) {
            instance = new Board(size);
        }
        return instance;
    }

    public int getSize() {
        return grid.length;
    }

    public void display() {
        for (String[] row : grid) {
            for (String cell : row) {
                System.out.print("|" + cell);
            }
            System.out.println("|");
        }
    }

    public boolean makeMove(int row, int col, Player player) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid.length || !grid[row][col].equals(" ")) {
            return false;
        }
        grid[row][col] = player.getSymbol();
        return true;
    }

    public boolean checkWin(String symbol) {
        int size = grid.length;

        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (checkLine(symbol, grid[i]) || checkLine(symbol, getColumn(i))) {
                return true;
            }
        }

        // Check diagonals
        return checkLine(symbol, getMainDiagonal()) || checkLine(symbol, getAntiDiagonal());
    }

    public boolean isFull() {
        for (String[] row : grid) {
            for (String cell : row) {
                if (cell.equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLine(String symbol, String[] line) {
        for (String cell : line) {
            if (!cell.equals(symbol)) {
                return false;
            }
        }
        return true;
    }

    private String[] getColumn(int col) {
        int size = grid.length;
        String[] column = new String[size];
        for (int i = 0; i < size; i++) {
            column[i] = grid[i][col];
        }
        return column;
    }

    private String[] getMainDiagonal() {
        int size = grid.length;
        String[] diagonal = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = grid[i][i];
        }
        return diagonal;
    }

    private String[] getAntiDiagonal() {
        int size = grid.length;
        String[] diagonal = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = grid[i][size - 1 - i];
        }
        return diagonal;
    }
}
