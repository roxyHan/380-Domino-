
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanifa Barry
 * @date    04/16/2019
 * 
 */
public class CDominoes {

    private ArrayList<Domino> dominoes_pile = new ArrayList<>();
    
    /**
     * Constructor for the boneyard
     */
    public CDominoes() {
        this.dominoes_pile = fillPile(dominoes_pile) ;
    }

    /**
     * @param   pile    an empty ArrayList of Domino 
     * 
     * @return a filled ArrayList of dominoes
     */
    private ArrayList<Domino> fillPile(ArrayList<Domino> pile) {
        int max = 6;
        for (int left = 0; left <= max; left++) {
            for (int right = left; right >= 0; right--) {
                Domino currentPiece = new Domino(left, right);
                pile.add(currentPiece);
            }
        }
        return pile;
    }
    
    /**
     * @return the pile of dominoes
     */
    public ArrayList<Domino> getPile() {
        return dominoes_pile;
    }
    
    /**
     * 
     *
     * @return a domino given left and right metrics 
     */    
    public Domino draw() {
        Collections.shuffle(dominoes_pile);
        Domino aDomino = dominoes_pile.get(0);
        dominoes_pile.remove(aDomino);
        return aDomino;       
    }
    
    
    /**
     * Displays information about the pile of dominoes
     */
    public void display() {
        int previousLeft = 0;
        for (Domino piece : dominoes_pile) {
            if (piece.getLeft() == previousLeft ) {
                System.out.print(piece.toString());
            }
            else {
                System.out.print("\n" + piece.toString());
                previousLeft = piece.getLeft();    
            }
        }
    }


}
