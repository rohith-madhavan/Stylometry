package metric;

public class Test {

	public static void main(String[] args) {
		String dir = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\books\\";

		try {
			Book hamlet = new Book("Hamlet", "Shakesphere", dir+"Hamlet.txt");
			Book othello = new Book("Othello", "Shakesphere", dir+"Othello.txt");
			
			Book davidCopperfield = new Book("David Copperfield", "Dickens", dir + "David Copperfield.txt");
			Book oliverTwist = new Book("Oliver Twist", "Dickens", dir + "Oliver Twist.txt");
			
			Book hp1 = new Book("Philosopher's Stone", "Rowling", dir + "Harry Potter - 1.txt");
			Book hp2 = new Book("Chamber of Secrets", "Rowling", dir + "Harry Potter - 2.txt");
			
			Author Shakesphere = new Author("Shakesphere");
			Author Dickens = new Author("Dickens");
			Author Rowling = new Author("Rowling");
			
			Shakesphere.addBook(hamlet);
			Shakesphere.addBook(othello);
			Shakesphere.populateWordFrequency();
			Shakesphere.populateBeginWord();
			Shakesphere.populateEndWord();
			Shakesphere.getWordsperSentence();
			Shakesphere.populateBigrams();
			
			Dickens.addBook(davidCopperfield);
			Dickens.addBook(oliverTwist);
			Dickens.populateWordFrequency();
			Dickens.populateBeginWord();
			Dickens.populateEndWord();
			Dickens.getWordsperSentence();
			Dickens.populateBigrams();
			
			Rowling.addBook(hp1);
			Rowling.addBook(hp2);
			Rowling.populateWordFrequency();
			Rowling.populateBeginWord();
			Rowling.populateEndWord();
			Rowling.getWordsperSentence();
			Rowling.populateBigrams();
			
			
			System.out.println("Shakesphere");
//			System.out.println(Shakesphere.generateRandomWord());
			for(int i = 0; i < 3; ++i) {
				System.out.println(Shakesphere.generateRandomSentence());
			}
			
			System.out.println("----------");
			for(int i = 0; i < 3; ++i) {
				System.out.println(Shakesphere.generateBigramSentence());
			}
			
			System.out.println("-------");
			System.out.println("Done");
			
			
			System.out.println("Dickens");
			for(int i = 0; i < 3; ++i) {
				System.out.println(Dickens.generateRandomSentence());
			}
			
			System.out.println("----------");
			for(int i = 0; i < 3; ++i) {
				System.out.println(Dickens.generateBigramSentence());
			}
			
			System.out.println("-------");
			System.out.println("Done");
			
			System.out.println("Rowling");
			for(int i = 0; i < 3; ++i) {
				System.out.println(Rowling.generateRandomSentence());
			}
			
			System.out.println("----------");
			for(int i = 0; i < 3; ++i) {
				System.out.println(Rowling.generateBigramSentence());
			}
			
			System.out.println("-------");
			System.out.println("Done");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}