package com.learn.book_manager.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService{

    @Override
    public void sendNotification(String notification) {
        System.out.printf("\nSMS SENT : %s\n",notification);
    }
}
