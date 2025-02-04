package com.tictactoe;

public class Bot extends Player {
    public Bot(String name, String symbol) {
        super(name, symbol, new BotMoveStrategy());
    }
}
