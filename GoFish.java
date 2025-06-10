// Nov 23, 2023
// Michael Luo
// Go Fish card game w/classes

class GoFish {
	
	// debugging mode - reveals the computer's and deck's cards
	public static boolean debuggingmode = false;

	// print
	public static void pr(String text){
		System.out.println(text);
	}
	
	
	public static void main (String [] args) {
		int STARTINGHANDSIZE = 7;
		int cardAsked = 0;
		int numCardAsked = 0;
		int temp = 0;
		boolean turnDone = false;
		
		//Set up game ----------------------------
		Player play1 = new Hplayer();
 		Player comp = new Cplayer();
		Deck deck = new Deck();
		
		int turn = 0;
		
		pr("---- Deck ----");
		System.out.println(deck);
		pr("\nShuffling\n");
		deck.shuffle();
		pr("---- Deck ----");
		System.out.println(deck);
		
		// deal everyone cards
		for (int i=0; i<STARTINGHANDSIZE; i++) {
			play1.takecard(deck.give());
			comp.takecard(deck.give());
		}
		
		// game loop -----------------------------
		while (deck.getCardsLeft() > 0 || play1.getNumCards() > 0 || comp.getNumCards() > 0) {
			turn++;
			pr("\n\n---- Round " + turn + " ----");
			
			// show hands ----------------
			pr("\n" + play1.getName() + "'s hand");
			play1.showhand();
			pr("\n\n" + comp.getName() + "'s hand");
			comp.showhand();
			
			
			// player's turn -----------------
			turnDone = false;
			while(!turnDone) {
			
			// checks if necessary to refill their hand from the deck
			if (play1.getNumCards() <= 0 && deck.getCardsLeft() >= STARTINGHANDSIZE) {
				for (int i=0; i<STARTINGHANDSIZE; i++) {
					play1.takecard(deck.give());
				}
			}
			else if (play1.getNumCards() <= 0) {
				for (int i=0; i<deck.getCardsLeft(); i++) {
					play1.takecard(deck.give());
				}
			}
			
			//asks for a card
				cardAsked = play1.ask();
				numCardAsked = comp.getMiniHandCards(cardAsked);
				
				if (numCardAsked == 0) {
					pr("Go Fish!");
					
					// if no cards are in deck
					if (deck.getCardsLeft() <= 0) {
						turnDone = true;
					}
					else {
						temp = deck.give();
						
						pr(play1.getName() + " got a " + Deck.convertID(temp));
						if (temp%13 != cardAsked)
							turnDone = true;
						play1.takecard(temp);
					}
				}
				else {
					for (int j=0; j<numCardAsked; j++) {
						play1.takecard(comp.giveCard(cardAsked));
					}
				}
			}
			
			// computer's turn ----------------
			turnDone = false;
			while(!turnDone) {
				
			// checks if the need to refill their hand from the deck
			if (comp.getNumCards() <= 0 && deck.getCardsLeft() >= STARTINGHANDSIZE) {
				for (int i=0; i<STARTINGHANDSIZE; i++) {
					comp.takecard(deck.give());
				}
			}
			else if (comp.getNumCards() <= 0) {
				for (int i=0; i<deck.getCardsLeft(); i++) {
					comp.takecard(deck.give());
				}
			}
			
			// ask for a card
				cardAsked = comp.ask();
				numCardAsked = play1.getMiniHandCards(cardAsked);
				
				if (numCardAsked== 0) {
					pr("Go Fish!");
					
					// if no cards are in deck
					if (deck.getCardsLeft() <= 0) {
						turnDone = true;
					}
					else {
						temp = deck.give();
						
						if (temp%13 == cardAsked)
							pr(comp.getName() + " got a " + Deck.convertID(temp));
						else {
							pr(comp.getName() + " got a [?]");
							turnDone = true;
						}
						comp.takecard(temp);
					}
				}
				else {
					for (int k=0; k<numCardAsked; k++) {
						comp.takecard(play1.giveCard(cardAsked));
					}
				}
			}
			
			
			
			pr("---- Deck ----");
			System.out.println(deck);
			
			
		}	
		
		// Say who won -----------------------------
		if (comp.getBooks() > play1.getBooks()){
			pr(comp.getName() + " Wins!");
			pr("Books: " + comp.getBooks());
		}
		else if (comp.getBooks() < play1.getBooks()) {
			pr(play1.getName() + " Wins!");
			pr("Books: " + play1.getBooks());
		}
		else 
			pr("Draw!");
		
		// -----------------------------------------
	}
}