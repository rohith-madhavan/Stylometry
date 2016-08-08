package metric;

import com.sun.media.sound.InvalidFormatException;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by vedsharma on 08-Aug-16.
 */

public class Metric {
    Book bookOne;
    HashMap<String,Integer> words;
    ArrayList<String> sentence;
    ArrayList<String> paragraph;

    public Metric() {
        bookOne = new Book();
    }

    public void populateWords() {
    }

    public void populateSentence() {

    }

    public void populateParagraph() {

    }

    public int getNoOfWords(String content) {
        return 0;
    }

    public int getNoOfLetters(String content) {
        return 0;
    }

    public int getNoOfSentences(String content) {
        return 0;
    }

    public HashMap<String, Integer> topNWords(int n) {
        return null;
    }

//    public static void SentenceDetect() throws InvalidFormatException,
//            IOException {
//        String paragraph = "Hi. How are you? This is Mike.";
//
//        // always start with a model, a model is learned from training data
//        InputStream is = new FileInputStream("en-sent.bin");
//        SentenceModel model = new SentenceModel(is);
//        SentenceDetectorME sdetector = new SentenceDetectorME(model);
//
//        String sentences[] = sdetector.sentDetect(paragraph);
//
//        System.out.println(sentences[0]);
//        System.out.println(sentences[1]);
//        is.close();
//    }
}
