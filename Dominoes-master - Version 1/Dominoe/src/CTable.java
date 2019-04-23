//main dev: Josue Cadenas
//last update: 4/20/3019

import java.util.*;

public class CTable {

    //CTable methods
    public static boolean flip() {
        Random randomNum = new Random();
        int result = randomNum.nextInt(2);
        return result != 0;
    }

    public static void showTable(Domino[] table) {
        System.out.print("\n*************************************************************************************************************************************************\n");
        System.out.println("                                                                   TABLE");
        for (Domino table1 : table) {
            if (table1 != null) {
                System.out.print("|" + table1 + "|");
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("<-------SUPER DOMINOES BROTHERS 3------->" + "\nFirst we will flip a coin to see which player goes first.");
        Domino[] table = new Domino[60];
        int left = 29;
        int right = 31;
        int unit = 30;
        //create_dominoes
        CDominoes dominoes = new CDominoes();
        CPlayer player1 = new CPlayer("player 1");
        CPlayer player2 = new CPlayer("player 2");
        CPlayer[] turnOrder = new CPlayer[]{player1, player2};
        int playerTurn = 0;
        //draw_dominoes
        for (int i = 0; i < 10; i++) {
            player1.addDomino(dominoes.draw());
            player2.addDomino(dominoes.draw());
        }
        //who_first        
        boolean oneWins = false;
        boolean twoWins = false;
        if (flip()) {
            System.out.println("player 1 has won the coin toss and goes first!");
            oneWins = true;
        } else {
            System.out.println("player 2 has won the coin toss and goes first!");
            twoWins = true;
        }
        //first_piece
        Domino currentPiece;
        Scanner userInput = new Scanner(System.in);
        if (oneWins) {
            playerTurn = 1;
            player1.showHand();
            System.out.print("Now player 1 pick the position of the dominoe piece you want to place first...");
            table[30] = player1.pickDomino(userInput.nextInt());
            currentPiece = table[30]; 
            showTable(table);
        } else {
            playerTurn = 0;
            player2.showHand();
            System.out.print("Now player 2 pick the position of the dominoe piece you want to place first...");
            table[30] = player2.pickDomino(userInput.nextInt());
            showTable(table);

        }
        currentPiece = table[30];

        //game loop    
        boolean winner = false;
        boolean p1Pass = false;
        boolean p2Pass = false;
        CPlayer currentPlayer = turnOrder[playerTurn];
        while (!winner) {
            //winner check
            if (p1Pass && p2Pass) {
                System.out.println("\nplayers both passed consecutively. No contest!");
                break;
            } else if (player1.getHand().isEmpty()) {
                System.out.println("Player 1 wins!");
                System.out.println("Player 2 loses with " + player2.getHand().size() + " dominos left");
                player2.showHand();
                winner = true;
                break;
            } else if (player2.getHand().isEmpty()) {
                System.out.println("Player 2 wins!");
                System.out.println("Player 1 loses with " + player1.getHand().size() + " dominos left");
                player1.showHand();
                winner = true;
                break;
            }
        
            System.out.print("\nNow " + turnOrder[playerTurn].getName() + " Would you like to:" 
                + "\n [play] a piece or [draw] a new random piece from the pile" );
            
            /**
             *
             * @author Hanifa Barry
             * @date   04/22/2019
             * 
            */

            boolean keepLooking = true;
            while (keepLooking) {   
                currentPlayer.showHand();
                int option = 1;
               
                try {
                     System.out.println("\nEnter 1 to play and 2 to draw ");
                     option = userInput.nextInt();
                    }
                catch(InputMismatchException e) {
                        System.out.println("Please enter the number 1 or 2 to select a valid option");
                        userInput.nextLine();
                        System.out.println("\nEnter 1 to play and 2 to draw ");
                        option = userInput.nextInt();
                        }
                // player chooses to place a piece
                if ( option == 1 && findPiece(currentPiece, currentPlayer.getHand())) {
                    // Which domino did you pick?
                    System.out.println("Pick the position of the dominoe piece you want to place");
                    int position = userInput.nextInt();
                    
                    // left or right? Pick your side!
                    System.out.println("Where would you like to place the selected domino?\nEnter L for left or R for right:");
                    String side = (userInput.next()).toUpperCase();
                    
                    // Does this domino need to be flipped? 
                    System.out.println("Would you like to flip the chosen domino? Enter Y for yes or N for no");
                    String flipIt = (userInput.next()).toUpperCase();
                   
                    // place the piece on the left side 
                    switch(side) {
                        case "L":
                        // no flipping
                        if (flipIt.equals("N")) {
                          table[left] = currentPlayer.pickDomino(position);
                          left--; 
                          break;
                        }
                        // flip the piece
                        else{
                            table[left] = currentPlayer.pickDomino(position);
                            table[left] = (table[left].flipDomino());
                            left--;
                            break;
                        }
                    
                        case "R":
                            // no flipping
                            if (flipIt.equals("N")) {
                                table[right] = currentPlayer.pickDomino(position);
                                right++;  
                                break;
                            }
                            // flip the piece
                             else{
                                table[right] = currentPlayer.pickDomino(position);
                                table[right] = (table[right].flipDomino());
                                right++;
                                break;
                            }
                        }
                    
                    keepLooking = false;
                    showTable(table);
                    System.out.println();
                    
                }
            
                // Cannot play, thus player draws a piece
                else if (option == 2) {
                    //Domino myPiece = dominoes.draw();
                    if (!(dominoes.getPile()).isEmpty()) {
                        currentPlayer.addDomino(dominoes.draw());                    
                    }
                    else {
                        System.out.println("no more domino to draw, pass! On to the next player...");
                        keepLooking = false; 
                        winner = false;
                        // who passes? 
                        if ((currentPlayer.getName()).equals("player 1")) {
                            p1Pass = true;
                        }
                        else {
                            p2Pass = true;
                        }
                    }
                }
            }
            // switch to the next player
            if (playerTurn == 0){
                playerTurn = 1;
            }
            else {
                playerTurn = 0;
            }
            currentPlayer = turnOrder[playerTurn];
        }
    }
    
   
    
    public static boolean findPiece(Domino piece, ArrayList<Domino> aHand) {
        boolean foundPiece = false;
        for (Domino aDomino : aHand) {
            Domino flipped = aDomino.flipDomino();
            if (piece.getLeft() == aDomino.getLeft() || piece.getRight() == aDomino.getRight()) {
                foundPiece = true ; 
            }
            else if (piece.getLeft() == flipped.getLeft() || piece.getRight() == flipped.getRight()) {
                foundPiece = true;
            }
        }
        return foundPiece;
    }
}
