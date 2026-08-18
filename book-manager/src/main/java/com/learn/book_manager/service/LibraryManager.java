package com.learn.book_manager.service;

import com.learn.book_manager.model.Book;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryManager {
    private BookService bookService;

    @Autowired
    public LibraryManager(BookService bookService){
        System.out.printf("\nLibraryManager Constructor Called!\n");
        this.bookService = bookService;
    }
    @PostConstruct
    private void initLibrary(){
        System.out.printf("\nLibraryManager @PostConstruct: Ready to manage books!\n");
        addBooks();
    }

    private void addBooks() {
        bookService.addBook(new Book(1,"The Great Gatsby"));
        bookService.addBook(new Book(2, "1984"));
    }


}
