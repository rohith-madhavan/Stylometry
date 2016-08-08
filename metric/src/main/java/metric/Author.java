package metric;

import java.util.*;

public class Author {
	String name;
	ArrayList<Book> books;

	int numWordsPerSentence;

	HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
	HashMap<String, HashMap<String,Integer>> bigramFrequency = new HashMap<String, HashMap<String,Integer>>();


	public Author() {
		books = new ArrayList<>();
	}

	public Author(String name) {
		this.name = name;
		books = new ArrayList<Book>();
		this.populateWordFrequency();
	}

	public void addBook(Book book) throws Exception {
		books.add(book);
	}

	
	public void populateWordFrequency() {
		for(Book b : books) {
        	for(String s: b.words){
           if(wordFrequency.containsKey(s))
        				(wordFrequency).put(s,wordFrequency.get(s)+1);
           else
           			wordFrequency.put(s,1);
         }
	}
		System.out.println("populated");
	}

	public void populateBigrams() {

	}


	public String generateRandomWord() {
		Random random = new Random();
	    List<String> keys = new ArrayList<String>(wordFrequency.keySet());
	    String  randomKey = keys.get(random.nextInt(keys.size()));
	    return randomKey;
	}

	public String generateFrequentWord() {
		
		return "";
	}

	public String generateBigramWord(String prevWord) {
		return "";
	}

}