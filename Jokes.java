import java.util.Scanner;
import java.io.*;

class Jokes {

	static String jokesArray[] = new String[10]; 
	static int jokeCount = 0;
	static int randomNum = 0;
	static Scanner filesc;
	
	static public void nextJoke(){
		if (jokeCount == 0) {
			loadJokes();
		}			
		System.out.println("Joke: " + jokesArray[jokeCount-1]);
		jokeCount = jokeCount-1;
	}
	
	static public void loadJokes() {
		
		try {
			// get jokes from file
			filesc = new Scanner (new File("jokes.txt"));
			
			while (filesc.hasNextLine()) {                                    
				jokesArray[jokeCount] = (filesc.nextLine()); 
				jokeCount++;	
			}
			// shuffle the jokes
			for (int i=0; i<jokeCount; i++) {
				
				String temp = jokesArray[i];
				randomNum = (int)(Math.random()*jokesArray.length-i) + i;
				
				jokesArray[i] = jokesArray[randomNum];
				jokesArray[randomNum] = temp;
			}		
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
	
	
	
}