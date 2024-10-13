import java.util.Scanner;

class Cplayer extends Player {
	
	private String name;

	public Cplayer() { 
		super("Super Computer 2000");
	}
	
	public void showhand() {
		for (int i=0; i<getNumCards(); i++) {
		System.out.print(Deck.convertID(hand[i]));
		}
		
		//for (int i=0; i<getNumCards(); i++) {
		//	System.out.print("[?] ");
		//}
	}
	
	public int ask() {
		// chose a random card from the hand to ask for
		int temp = (hand[(int)(Math.random()*getNumCards())])%13;
		System.out.println("\n" + getName() + " asked for " + Deck.convertCardNum(temp));
		return temp;
	}
	

	
}