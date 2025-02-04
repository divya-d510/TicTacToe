package com.tictactoe;

public class PlayerFactory {
    public static Player createPlayer(String name, String type, String symbol) {
        if ("bot".equalsIgnoreCase(type)) {
            return new Bot(name, symbol);
        } else {
            return new HumanPlayer(name, symbol);
        }
    }
}
