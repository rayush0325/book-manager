package com.learn.book_manager.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{

    @Override
    public void sendNotification(String notification) {
        System.out.printf("\nEMAIL SENT : %s\n",notification);
    }
}
