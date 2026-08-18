package com.learn.book_manager.service;

import com.learn.book_manager.model.Book;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class BookService {
    private NotificationService notificationService;
    Map<Integer, Book> map = new HashMap<>();

    @Autowired
    public BookService(@Qualifier("smsNotificationService") NotificationService notificationService){
        System.out.printf("\nBookService Constructor Called!\n");
        this.notificationService = notificationService;
    }

    @PostConstruct
    private void bookInit(){
        System.out.printf("""
                📚 BookService is ready!
                curent book count : %d
                Loading inventory from file...
                """, map.size());
        notificationService.sendNotification("BookService has been initialized!");
    }

    public void addBook(Book book){
        System.out.printf("\nadding book : %s\n", book.getTitle());
        map.put(book.getId(), book);
        notificationService.sendNotification("New book added: "+book.getTitle());
    }

    public void getAllBooks(){

    }

    public int getBookCount(){
        return map.size();
    }



    @PreDestroy
    private void destroyBook(){
        System.out.printf("""
                📚 BookService is shutting down!
                current book count = %d
                Saving inventory to file...
                """, map.size());
    }


}
