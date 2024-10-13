import java.util.Scanner;

class Hplayer extends Player {

	private Scanner sc = new Scanner(System.in);
	
	public Hplayer() { 
		super("Player");
	}
	
	public void showhand() {
		for (int i=0; i<getNumCards(); i++) {
		System.out.print(Deck.convertID(hand[i]));
		}
	}
	
	public int ask() {
		System.out.println("\n\nwhich card would you like to ask for");
		
		// shows the cards you can ask for
		for (int i=0; i<13; i++) {
			if (miniHand[i] != 0)
				System.out.print(Deck.convertCardNum(i)+" ");
		}
		// get user imput
		System.out.println("");
		String card = sc.nextLine();
		
		card = (card.trim()).toUpperCase();
		
		System.out.println("\n" + getName() + " asked for " + card);
		
		// returns card to ask the computer if it has the card
		return Deck.convertCardNum(card);
	
	}

	
}