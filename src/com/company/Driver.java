package com.company;

import enums.GameState;
import models.Player;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        Board board = new Board();
        board.setSize(3); // can take i/p from user
        game.setBoard(board);

        for (int rep =1;rep<=2;rep++){
            Player player = new Player();
            System.out.println("Enter Player Name");
            String name = sc.nextLine();
            System.out.println("Enter Player's Choice");
            String piece = sc.nextLine();
            player.setName(name);
            player.setChoice(piece);

            if(game.setPlayerBuilder(player))
                System.out.println("Player Details Added Successfully");
            else
                System.out.println("Piece is already taken");
        }

        System.out.println("Enter Moves");
        while (true){
            int row = sc.nextInt();
            int col = sc.nextInt();
            boolean validMove = game.move(row,col);
            if (!validMove)
                continue;
            GameState state = game.state();
            if (state==GameState.DRAW || state==GameState.WON)
                break;
        }
    }
}
