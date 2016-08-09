package metric;

import java.util.*;

public class Author {
	String name;
	ArrayList<Book> books;

	int numWordsPerSentence;

	HashMap<String, Integer> wordFrequency = new HashMap<String, Integer>();
	HashMap<String, HashMap<String,Integer>> bigramFrequency = new HashMap<String, HashMap<String,Integer>>();
	HashMap<String, HashMap<String, Integer>> trigramFrequency = new HashMap<String, HashMap<String, Integer>>();
	HashMap<String,Integer> beginWord = new HashMap<String,Integer>();
	HashMap<String,Integer> endWord = new HashMap<String,Integer>();


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

	public void populateWordFrequency() {

		for(Book b : books) {
			for(String s: b.words) {
				if(wordFrequency.containsKey(s))
					(wordFrequency).put(s,wordFrequency.get(s)+1);
				else
					wordFrequency.put(s,1);
			}
		}

	}

	public void populateBeginWord(){
		for(Book b:books){
			for(String s:b.sentences){
				String[] words = s.split(" ");
				if(beginWord.containsKey(words[0]))
					beginWord.put(words[0],beginWord.get(words[0])+1);
				else
					beginWord.put(words[0],1);
			}
		}
	}
	
	public void populateEndWord(){
		for(Book b:books){
			for(String s:b.sentences){
				String[] words = s.split(" ");
				int last = words.length-1;
				if(endWord.containsKey(words[last]))
					endWord.put(words[last], endWord.get(words[last])+1);
					else
						endWord.put(words[last],1);
			}
		}
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

	public String generateRandomWord(HashMap<String, Integer> miniList) {
		Random random = new Random();
		List<String> keys = new ArrayList<String>(miniList.keySet());
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

	public String generateFrequentWord(HashMap<String, Integer> x) {
		List<String> keys = new ArrayList<String>(x.keySet());
		double totalFreq = 0.0d;
		for (String s : keys){
			totalFreq += x.get(s);
		}
		int randomIndex = -1;
		double random = Math.random() * totalFreq;
		for (int i = 0; i < keys.size(); ++i){
			random -= x.get(keys.get(i));
			if (random <= 0.0d){
				randomIndex = i;
				break;
			}
		}
		return keys.get(randomIndex);
	}

	public String generateBigramWord(String prevWord) {
		if(bigramFrequency.get(prevWord) != null) {
			HashMap<String,Integer> listWords = bigramFrequency.get(prevWord);

			return generateFrequentWord(listWords);

		}
		else
			return "";
	}

	public String generateRandomSentence() {
		String s = generateFrequentWord(beginWord);
		for(int i = 1; i < numWordsPerSentence - 1; ++i) {
			s += " " + generateFrequentWord();
		}
		s += " " + generateFrequentWord(endWord);
		return s+".";
	}

	public String generateBigramSentence() {
		String s = generateFrequentWord(beginWord);

		String prevWord = s;

		for(int i = 1; i < numWordsPerSentence - 1; ++i) {
			prevWord = generateBigramWord(prevWord);
			s += " " + prevWord;
		}
		s += " " + generateFrequentWord(endWord);
		return s+".";

	}


	public void testBigrams() {
		//		String r = generateRandomWord();
		String r = "the";
		System.out.println("The word is: " + r);

		HashMap<String, Integer> x = bigramFrequency.get(r);
		for(String s: x.keySet()) {
			System.out.println(s + "," + x.get(s));
		}
		System.out.println("---------------");
		System.out.println(generateBigramWord(r));
	}


}