package metric;

public class Test {

	public static void main(String[] args) {
		String dir = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\books\\";

		try {
			Book hamlet = new Book("Hamlet", "Shakesphere", dir+"Hamlet.txt");
			Book othello = new Book("Othello", "Shakesphere", dir+"Othello.txt");
			Author Shakesphere = new Author("Shakesphere");
			Shakesphere.addBook(hamlet);
			Shakesphere.addBook(othello);
			Shakesphere.populateWordFrequency();
			System.out.println(Shakesphere.generateRandomWord());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}