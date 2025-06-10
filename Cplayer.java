//Computer player
//import java.util.Scanner;

class Cplayer extends Player {
	
	//private String name;

	public Cplayer() { 
		super("Super Computer 2000");
	}
	
	public void showhand() {
		
		// hand is visible for debugging
		if (GoFish.debuggingmode) {
			for (int i=0; i<getNumCards(); i++) {
				System.out.print(Deck.convertID(hand[i]));
			} }
		else {
			for (int i=0; i<getNumCards(); i++) {
				System.out.print("[?]");
			} }
	}
	
	public int ask() {
		// chose a random card from the hand to ask for
		int temp = (hand[(int)(Math.random()*getNumCards())])%13;
		System.out.println("\n" + getName() + " asked for " + Deck.convertCardNum(temp));
		return temp;
	}
	

	
}