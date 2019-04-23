//Main Developer for this section: Josue Cadenas
//last update: 4/13/3019

import java.util.*;

public class CPlayer {

    //elements
    private ArrayList<Domino> hand = new ArrayList<Domino>();
    private String name;
    //constructor
    CPlayer(String n) {
        name = n;
    }

    //methods
    public Domino pickDomino(int x) {
        Domino pickedDomino = hand.get(x - 1);
        hand.remove(x - 1);
        return pickedDomino;
    }

    public void showHand() {
        System.out.print("\n*************************************************************************************************************************************************\n");
        System.out.println("                                 " + name + "'s hand");
        
        int size = hand.size();
        System.out.print("position: ");
        for (int i = 1; i <= size; i++) {
            System.out.print( "   " + i + "   ");
        }
        System.out.print("\nYour hand: ");
        for(int i = 0; i < size; i++){
            System.out.print(hand.get(i));
        }
        System.out.print("\n*************************************************************************************************************************************************\n");
    }

    public ArrayList<Domino> getHand() {
        return hand;
    }
    public String getName(){
        return name;
    }

    public void addDomino(Domino x) {
        hand.add(x);
    }

}
