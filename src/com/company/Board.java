package com.company;

import enums.GameState;

public class Board {
    private int size;

    Board(){
        size = 3;
    }

    public int getSize(){
        return size;
    }
    // for future use if we need to change the size of board
    public void setSize(int size){
        this.size = size;
        this.ar = new String[size+1][size+1];
        for(int i=0;i<=size;i++){
            for(int j=0;j<=size;j++)
                this.ar[i][j]="-";
        }
    }

    private String[][] ar;

    public String[][] getAr(){
        return ar;
    }

    public void setAr(int row,int col,String piece){
        this.ar[row][col] = piece;
    }

    public void print(){
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                System.out.print(ar[i][j]);
            }
            System.out.println();
        }
    }

    public GameState gameState(){
        if(winnerInRow()==GameState.WON)
            return GameState.WON;
        if (winnerInCol()==GameState.WON)
            return GameState.WON;
        if (winnerInFirstDiagonal()==GameState.WON)
            return GameState.WON;
        if (winnerInSecondDiagonal()==GameState.WON)
            return GameState.WON;
        if (gameDraw()==GameState.DRAW)
            return GameState.DRAW;
        return GameState.PROGRESS;
    }

    private GameState winnerInRow(){
        for (int row=1;row<=size;row++){
            String current = ar[row][1];
            boolean winnerFound = true;
            for (int col=1;col<=size;col++){
                if(!current.equals(ar[row][col]) || ar[row][col].equals("-")){
                    winnerFound = false;
                    break;
                }
            }

            if (winnerFound)
                return GameState.WON;
        }
        return GameState.PROGRESS;
    }

    private GameState winnerInCol(){
        for (int col=1;col<=size;col++){
            String current = ar[1][col];
            boolean winnerFound = true;
            for (int row=1;row<=size;row++){
                if(!current.equals(ar[row][col]) || ar[row][col].equals("-")){
                    winnerFound = false;
                    break;
                }
            }
            if (winnerFound)
                return GameState.WON;
        }
        return GameState.PROGRESS;
    }

    private GameState winnerInFirstDiagonal() {
        String current = ar[1][1];
        if (this.ar[1][1].equals("-"))
            return GameState.PROGRESS;
        for (int i=1;i<=size;i++){
            if(!current.equals(ar[i][i]) || ar[i][i].equals("-")){
                return GameState.PROGRESS;
            }
        }
        return GameState.WON;
    }

    private GameState winnerInSecondDiagonal() {
        String current = ar[1][size];
        if (this.ar[1][size].equals("-"))
            return GameState.PROGRESS;
        for (int i=1,j=size;i<=size && j>=i;i++,j--){
            if(!current.equals(ar[i][j]) || ar[i][j].equals("-"))
                return GameState.PROGRESS;
        }
        return GameState.WON;
    }

    private GameState gameDraw() {
        for (int i=1;i<=size;i++){
            for (int j=1;j<=size;j++){
                if (this.ar[i][j].equals("-"))
                    return GameState.PROGRESS;
            }
        }
        return GameState.DRAW;
    }
}
