abstract class Player {
	private int numCards = 0;
	protected int hand[] = new int[52];
	protected int miniHand[] = new int[13];
	private String name;
	private int books = 0;
	
	
	public Player(String name) {
		this.name = name;
	}
	
	public void takecard(int card) {
		hand[numCards] = card;
		miniHand[card%13] += 1;
		
		System.out.println(numCards + "-----");
		for (int o=0; o<13; o++) {
			System.out.print(miniHand[o]);
		}
		
		numCards++;
		checkForSet(card);
	}
	
	
	// allows for program to ask how many of a card it has
	public int getMiniHandCards(int card) {
		return (miniHand[card]);
	}
	
	private void checkForSet(int card) {
		card = card%13;
		
		if (miniHand[card] == 4) {
			System.out.println(name + " got a set of " + Deck.convertCardNum(card) + "'s");
			// removes the set from the hand
			for (int j = 0; j<4; j++) {
				for (int i = 0; i<numCards; i++) {
					if (card == hand[i]%13) {		
						
						numCards = numCards-1;
						hand[i] = hand[numCards];
						hand[numCards] = 0;
						break
						; 
					}
				}
			}
			miniHand[card] = 0;
			
			
			Jokes.nextJoke();
			books++;
		}
	}
	
	// searches hand for that card, removes it from the hand, and then returns it
	public int giveCard(int card) {
		int temp = 0;
		
		for (int i = 0; i<numCards; i++) {
			if (card == hand[i]%13) {
				temp = hand[i];
				
				// removes card from hand
				numCards = numCards-1;
				hand[i] = hand[numCards];
				hand[numCards] = 0;
				miniHand[card] = miniHand[card]-1; 
				
				System.out.println(name + " gave a " + Deck.convertID(temp));
				return temp;
			}
		}
		return -1;
	}
	
	public int getNumCards() {
		return numCards;
	}
	
	public String getName() {
		return name;
	}

	public int getBooks() {
		return books;
	}
	
	public abstract void showhand();
	
	public abstract int ask();
	
}