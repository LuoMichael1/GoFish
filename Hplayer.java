import java.util.Scanner;

class Hplayer extends Player {

	private Scanner sc = new Scanner(System.in);
	private boolean isvalid = false;
	private String card = "";

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
				System.out.print("[" + Deck.convertCardNum(i) + "]");
		}

		while (!isvalid) {
			// get user imput
			System.out.println("");
			card = sc.nextLine();
			
			card = (card.trim()).toUpperCase();
			
			//check if the input is valid
			if (miniHand[Deck.convertCardNum(card)%13] > 0 ) {
				System.out.println("\n" + getName() + " asked for " + card);
				isvalid = true;
			}
			else {
				System.out.print("Invalid Card, try again");
			}
		}
		isvalid = false;
		// returns card to ask the computer if it has the card
		return Deck.convertCardNum(card);
	}
}