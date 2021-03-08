package com.intern.demo;

import com.intern.demo.entities.Book;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Capitalization {

    private static String capitalize (String input) {
        //TODO Add logic to capitalize String Input
        //TODO Input = "I want to lEARN JAVA"
        //TODO Output = "I Want To Learn Java"
        input = input.toLowerCase();
        char[] inputChars = input.toCharArray();
        boolean isCapital = true;
        for(int i=0; i<input.length();i++){

            if(isCapital) {
                inputChars[i] = Character.toUpperCase(inputChars[i]);
                isCapital = false;
            }
            else if(inputChars[i] == ' '){
                isCapital = true;
            }
        }
        return String.valueOf(inputChars);
    }

    public static Map<String, List<String>> convertToMap (List<Book> books) {
        // TODO Add logic to capitalize Author and Title Of Books to Map with Key: Author, Value: List of Title Grouped By Author
        // TODO INPUT: List<Book>
        // TODO OUTPUT: Map<String, List<String>>

        Map<String, List<String>> bookMap = new HashMap<>();
        List<String> bookList;
        for(Book book:books){
            book.setAuthor(capitalize(book.getAuthor()));
            book.setTitle(capitalize(book.getTitle()));
            if(bookMap.get(book.getAuthor()) == null){
                bookList = new ArrayList<>();
                bookList.add(book.getTitle());
                bookMap.put(book.getAuthor(), bookList);
            }
            else{
                bookMap.get(book.getAuthor()).add(book.getTitle());
            }
        }
        return bookMap;
    }
}
