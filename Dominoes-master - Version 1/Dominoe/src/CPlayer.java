//Main Developer for this section: Josue Cadenas
//last update: 4/13/3019

import java.util.*;

public class Player {

    //elements
        //Dev note: Integer will be replaced with dominoe once dominoe object is amde
    ArrayList<Integer> hand = new ArrayList<Integer>();

    //constructor
    Player() {
    }

    //methods
    public void showHand() {
        System.out.println(hand);
    }      
    public ArrayList getHand() {
        return hand;
    }
    //Dev note: Temporary method to test printing methods, int will be replaced with Dominoe
    public void addNum(int x){
        hand.add(x);
    }
    //Dev note: Temporary method for testing, int will be replaced with Dominoe
    public void removeNum(int x){
        hand.remove(x + 1);    
    }
}
