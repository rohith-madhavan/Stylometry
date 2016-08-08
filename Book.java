package metric;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by vedsharma on 08-Aug-16.
 */

public class Book {
    private String bookContent;

    public Book(String path) {
        try {
            bookContent = new Scanner(new File(path)).useDelimiter("\\Z").next();
        }
        catch (FileNotFoundException e) {
            bookContent="";
        }
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }
}
