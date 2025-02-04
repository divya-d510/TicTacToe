package com.tictactoe;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, String symbol) {
        super(name, symbol, new HumanMoveStrategy());
    }
}
