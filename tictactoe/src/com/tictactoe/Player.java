package com.tictactoe;

public abstract class Player {
    private String name;
    private String symbol;
    private MoveStrategy moveStrategy;

    public Player(String name, String symbol, MoveStrategy moveStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void makeMove(Board board) {
        moveStrategy.makeMove(board, this);
    }
}
