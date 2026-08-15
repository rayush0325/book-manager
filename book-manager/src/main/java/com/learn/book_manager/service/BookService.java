package com.learn.book_manager.service;

import com.learn.book_manager.model.Book;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class BookService {
    private NotificationService notificationService;

    @Autowired
    public BookService(@Qualifier("smsNotificationService") NotificationService notificationService){
        System.out.printf("\nBookService Constructor Called!\n");
        this.notificationService = notificationService;
    }

    @PostConstruct
    private void bookInit(){
        System.out.printf("\nBookService @PostConstruct: Bean is ready!\n");
        notificationService.sendNotification("BookService has been initialized!");
    }

    public void addBook(String bookName){
        System.out.printf("\nadding book : %s\n", bookName);
        notificationService.sendNotification("New book added: "+bookName);
    }



    @PreDestroy
    private void destroyBook(){
        System.out.printf("\nBookService @PreDestroy: Cleaning up resources...\n");
    }


}
