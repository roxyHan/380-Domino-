/*
 */

/**
 *
 * @author Hanifa
 * 
 */
public class Domino {
    
    private int left, right;
    private boolean isFlipped;
    
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
     * Displays information about the piece of domino
     * 
     */
    public String toString() {
        String display = "";
        display += "(" + getLeft() + ", " + getRight() + ")" + " " ;         
        return display;
    }
    
}
