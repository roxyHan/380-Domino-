/*
 */

/**
 *
 * @author Hanifa Barry
 * @date   04/16/2019
 * 
 */
public class Domino {
    
    private int left, right;
    
    /**
     * Builds a domino object
     * 
     * @param left
     * @param right 
     */
    public Domino(int left,int right) {
        this.left = left;
        this.right = right;
    }
    
    /**
     * @return left side of the domino
     */
    public int getLeft() {
        return this.left;
    }
    
    /**
     * @return right side of the domino
     */
    public int getRight() {
        return this.right;
    }
    
    /**
     * 
     * @param aDomino
     * @return Domino   flippedDomino
     */
    public Domino flipDomino() {
        Domino flippedDomino = new Domino(this.right, this.left);
        return flippedDomino;
    }
    
    /**
     * Displays information about the piece of domino
     * 
     * @return String   information about the domino
     */
    public String toString() {
        String display = "";
        display += "(" + getLeft() + ", " + getRight() + ")" + " " ;         
        return display;
    }
    
}
