package com.learn.book_manager;

import com.learn.book_manager.model.Book;
import com.learn.book_manager.service.BookService;
import com.learn.book_manager.service.SmsNotificationService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class BookRunner {
    private BookService bookService;
    public BookRunner(BookService bookService) {
        this.bookService = bookService;
        System.out.printf("\nBookRunner Constructor Called! \n");
    }

    @PostConstruct
    private void initBookRunner(){
        System.out.printf("\n@PostConstruct: Running demonstration...\n");
        System.out.printf("\nFetching SMS bean from context...\n");
        SmsNotificationService smsNotificationService = new SmsNotificationService();
        System.out.printf("\nFetching SMS bean again...\n");
        SmsNotificationService smsNotificationService1 = new SmsNotificationService();

        System.out.printf("\nAre the two SMS beans the same object? %b\n",
                smsNotificationService1 == smsNotificationService
                );
        bookService.addBook(new Book(3, "Animal Farm"));
        System.out.printf("\nCurrent book count: %d\n", bookService.getBookCount());
    }
}
