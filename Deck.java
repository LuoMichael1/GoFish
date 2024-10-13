class Deck {
	
	private static String cardName;
	private static char suit;
	
	private int spot = 0;
	private String full_deck = "";
	private int cardsleft = 52;
	private int deck[] = new int[52];
	
	static public final int UNIQUECARDNUMS = 13;
		
	public Deck() {
		// gives the deck ints representing every card
		for (int i=0; i<cardsleft; i++)
			deck[i] = i; 
	}
	
	// takes int representing a card and returns the card as a string	
	public static String convertID(int cardID) {
		// finds the suit
		suit = (char)(cardID/13 + 3);

		return ("[" + convertCardNum(cardID) + suit + "]");
	}		
	
	
	public static String convertCardNum(int cardID) {
		// convert card int value into string
		String cardName;
		if (cardID%13 == 0)
			cardName = "A";
		else if (cardID%13 == 10)
			cardName = "J";
		else if (cardID%13 == 11)
			cardName = "Q";
		else if (cardID%13 == 12)
			cardName = "K";
		else
			cardName = ""+(cardID%13 + 1);
		
		return (cardName);
	}
	
	public static int convertCardNum(String cardID) {
		// convert card string value back into int
		int cardName;

		if (cardID.equals("A"))
			cardName = 0;
		else if (cardID.equals("J"))
			cardName = 10;
		else if (cardID.equals("Q"))
			cardName = 11;
		else if (cardID.equals("K"))
			cardName = 12;
		else
			cardName = (Integer.parseInt(cardID))-1;
		
		return (cardName);
	}
	
	
	public void shuffle() {
		// first removes every card
		for (int k=0; k<cardsleft; k++)
			deck[k] = 0; 
			
		// loop for every card that needs to be shuffled
		for (int i=0; i<cardsleft; i++) {
			
			// finds an empty spot in the array and puts a card there
			for (int j=0; j<1; j=j){
				spot = (int)(Math.random()*52);
				if (deck[spot] == 0) {
					deck[spot] = i;
					j++;
				}
			}
		}
	}
	
	public int getCardsLeft() {
		return cardsleft;
	}
	
	public int give() {
		cardsleft = cardsleft-1;
		return deck[cardsleft];
	}
	
	public String toString() {
		full_deck="";
		for (int i=0; i<cardsleft; i++) {
			full_deck += convertID(deck[i]);
		}
		return full_deck;
	}		
}