package com.example.bridgebidder;

public class Board {
    private final int broadNum;
    private final int dealer;
    private int [][] callProcess = new int[4][25];
    private int scores = 0;
    private int turn;
    private int round = 0;
    private final int value;
    private final String valueString;

    public Board(int broadNum) {
        this.broadNum = broadNum;
        this.dealer = Constants.dealerTable[this.broadNum];
        this.turn = this.dealer;
        this.value = Constants.valueTable[broadNum];
        this.valueString =
                this.value == 0 ? "None":
                this.value == 1 ? "NS":
                this.value == 2 ? "EW":
                "Both";
    }

    public void call(String call) {
        callProcess[4-this.round%4 == 4 ? 0 : 4-this.round%4][this.round/4] = Constants.getKeyByValue(call);
        round ++;
    }

    public String getValueString() {
        return valueString;
    }

    public int getScores() {
        return  scores;
    }

    public int getDealer() {
        return  dealer;
    }

    public int getTurn() {
        return this.turn;
    }

    public void undo() {
        if (round == 0) {
            callProcess[4-this.round%4 == 4 ? 0 : 4-this.round%4][this.round/4] = 0;
        } else {
            round --;
            callProcess[4-this.round%4 == 4 ? 0 : 4-this.round%4][this.round/4] = 0;
            this.turn = this.turn - 1 < 0 ? 3: this.turn - 1;
        }
    }

    public void nextTurn() {
        this.turn = this.turn + 1 > 3 ? 0: this.turn + 1;
    }

    public int[] getSProcess() {
        return callProcess[dealer - 2 >= 0 ? dealer-2: dealer+2];
    }
    public int[] getNProcess() {
        return callProcess[dealer];
    }
    public int[] getEProcess() {
        return callProcess[dealer - 1 >= 0 ? dealer-1: dealer+3];
    }
    public int[] getWProcess() {
        return callProcess[dealer - 3 >= 0 ? dealer-3: dealer+1];
    }
}
