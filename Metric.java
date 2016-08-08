package metric;

import com.sun.media.sound.InvalidFormatException;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static java.lang.Character.isLetter;

/**
 * Created by vedsharma on 08-Aug-16.
 */

public class Metric {

	Book book;
	HashMap<String, Integer> words;
	ArrayList<String> sentences;
	ArrayList<String> paragraph;

	int avgNumWordsInSentences;
	int avgNumLettersInSentences;

	public Metric(Book b) {
		book = b;
		populateSentences();

	}

	public void populateWords(String sentence, Tokenizer tokenizer) {

		for (String word : tokenizer.tokenize(sentence)) {
			if(! ".,!?/\"\'\\&*()@#$%-".contains(word)) {
				if(words.containsKey(word)) {
					words.put(word,words.get(word)+1);
				}
				else {
					words.put(word,1);
				}
			}
		}

	}

	public void populateSentences() {

		String content = book.getBookContent();
        
        sentences = new ArrayList<String>();
        
        try {
            
            InputStream is = new FileInputStream("C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\en-sent.bin");
            InputStream i = new FileInputStream("C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\en-token.bin");

            SentenceModel model = new SentenceModel(is);
            SentenceDetectorME sdetector = new SentenceDetectorME(model);
            
            TokenizerModel modelT = new TokenizerModel(i);
            Tokenizer tokenizer = new TokenizerME(modelT);


            for (String s: sdetector.sentDetect(content)) {
                sentences.add(s);
                populateWords(s, tokenizer);
            }
            
            is.close();
            i.close();
        }
        catch(Exception e) {
        	System.out.println("\n");
        }

	}

	public int calcAvgWords() {
		String[] splitWords;
		int totalWords = 0;
		int totalSentences = sentences.size();

		for(String s: sentences) {
			splitWords = s.split(" ");
			totalWords += splitWords.length;
		}

		avgNumWordsInSentences = totalWords / totalSentences;

		return avgNumWordsInSentences;

	}
	
	public int calcAvgLetters() {
		
		int totalLetters = 0;
		int totalSentences = sentences.size();
		
		for(String s: sentences) {
			totalLetters += s.length();
		}
		
		avgNumLettersInSentences = totalLetters / totalSentences;
		
		return avgNumLettersInSentences;
	}

    public static void main(String[] args) {
    	String dir1 = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\Othello.txt";
    	String dir2 = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\Macbeth.txt";
    	String dir3 = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\Oliver Twist.txt";
    	String dir4 = "C:\\Users\\rmadhavan\\workspace\\metric\\src\\main\\java\\metric\\David Copperfield.txt";
        
    	Book othello = new Book(dir1);
    	Book macbeth = new Book(dir2);
    	
    	Book oliverTwist = new Book(dir3);
    	Book davidCopperfield = new Book(dir4);
        
    	Metric othMetrics = new Metric(othello);
        Metric macMetrics = new Metric(macbeth);
        
        Metric oliMetrics = new Metric(oliverTwist);
        Metric davMetrics = new Metric(davidCopperfield);
        
        System.out.println("Shakesphere");
        System.out.println(othMetrics.calcAvgWords());
        System.out.println(macMetrics.calcAvgWords());
        
        System.out.println(othMetrics.calcAvgLetters());
        System.out.println(macMetrics.calcAvgLetters());
        
        System.out.println("----------------------");
        System.out.println("Dickens");
        System.out.println(oliMetrics.calcAvgWords());
        System.out.println(davMetrics.calcAvgWords());
        
        System.out.println(oliMetrics.calcAvgLetters());
        System.out.println(davMetrics.calcAvgLetters());
        
        System.out.println("DONE");
        
    }

}
//
//class ValueComparator implements Comparator {
//    Map map;
//
//    public ValueComparator(Map map) {
//        this.map = map;
//    }
//
//    public int compare(Object keyA, Object keyB) {
//        Comparable valueA = (Comparable) map.get(keyA);
//        Comparable valueB = (Comparable) map.get(keyB);
//        return valueB.compareTo(valueA);
//    }
//}
