package com.intern.demo;


import com.intern.demo.entities.Book;
import com.intern.demo.entities.ImportedBook;
import com.intern.demo.entities.LocalBook;
//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.MockitoAnnotations.initMocks;

public class CapitalizationTest {

    @InjectMocks
    private Capitalization capitalization;

    @Before
    public void setUp(){
        initMocks(this);
    }
//
//    @After
//    public void tearDown(){
//
//    }

    @Test
    public void convertToMapTest() {
        //TODO COMPLETE THIS
        List<Book> books = new ArrayList<>();
        Book book1 = new ImportedBook("Author 1", "tHiS iS a BoOk", "Translator 1");
        books.add(book1);

        Book book2 = new ImportedBook("Author 2", "abcdefghijklmnopqrstuvwxyz", "Translator 1");
        books.add(book2);

        Book book3 = new LocalBook("Author 1", "ABCDE FGHIJ KLMNO PQRST UVWXYZ 1234567890", "Store 1");
        books.add(book3);

        Map<String, List<String>> bookList = Capitalization.convertToMap(books);

        System.out.println(bookList.get(book1.getAuthor()));
        assertEquals(bookList.get(book1.getAuthor()),
                Arrays.asList(
                        "This Is A Book",
                        "Abcde Fghij Klmno Pqrst Uvwxyz 1234567890"
                )
        );
        System.out.println(bookList.get(book2.getAuthor()));
        assertEquals(bookList.get(book2.getAuthor()),
                Arrays.asList(
                        "Abcdefghijklmnopqrstuvwxyz"
                )
        );
    }
}
