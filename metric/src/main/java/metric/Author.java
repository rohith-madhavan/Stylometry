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
	}

	public void addBook(Book book) throws Exception {
		books.add(book);
	}

	
	public void populateWordFrequency() {

		for(Book b : books) {
			for(String s: b.words) {
				if(wordFrequency.containsKey(s))
					(wordFrequency).put(s,wordFrequency.get(s)+1);
				else
					wordFrequency.put(s,1);
			}
		}
		System.out.println("Done");
	}
	
	public void getWordsperSentence(){
		int totalNoOfWords = 0;
		int avgNoOfWords = 0;

		for(Book b:books){
			totalNoOfWords = 0;
			ArrayList<String> sentences = b.sentences;
			for (String sentence : sentences) {
				totalNoOfWords += sentence.split(" ").length;
			}
			avgNoOfWords += totalNoOfWords / sentences.size();
		}
		numWordsPerSentence =  avgNoOfWords/books.size();
	}

	public void populateBigrams() {
		
		for(Book b:books) {
			for(String s: b.sentences) {
				String[] words = s.split(" ");
				for(int i = 1; i < words.length; ++i) {
					if(bigramFrequency.containsKey(words[i-1])) {
						HashMap<String, Integer> x = bigramFrequency.get(words[i-1]);
						if(x.containsKey(words[i])) {
							x.put(words[i], x.get(words[i])+1);
						}
						else {
							x.put(words[i], 1);
						}
					}
					else {
						HashMap<String, Integer> x = new HashMap<String, Integer>();
						x.put(words[i], 1);
						bigramFrequency.put(words[i-1], x);
					}
				}
			}
		}
		
	}


	public String generateRandomWord() {
		Random random = new Random();
	    List<String> keys = new ArrayList<String>(wordFrequency.keySet());
	    String  randomKey = keys.get(random.nextInt(keys.size()));
	    return randomKey;
	}

	public String generateFrequentWord() {
		List<String> keys = new ArrayList<String>(wordFrequency.keySet());
		double totalFreq = 0.0d;
		for (String s : keys){
			totalFreq += wordFrequency.get(s);
		}
		int randomIndex = -1;
		double random = Math.random() * totalFreq;
		for (int i = 0; i < keys.size(); ++i){
			random -= wordFrequency.get(keys.get(i));
			if (random <= 0.0d){
				randomIndex = i;
				break;
			}
		}
		return keys.get(randomIndex);
	}

	public String generateBigramWord(String prevWord) {
		return "";
	}
	
	public String generateRandomSentence() {
		String s = "";
		for(int i = 0; i < numWordsPerSentence; ++i) {
			s += " " + generateRandomWord();
		}
		return s+".";
	}

}