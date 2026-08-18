package com.learn.book_manager.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SmsNotificationService implements NotificationService{
    static int instanceNumber = 0;

    public SmsNotificationService() {
        instanceNumber++;
        System.out.printf("\nNEW SMS Bean Created! instance number = %d\n",instanceNumber);
    }

    @Override
    public void sendNotification(String notification) {
        System.out.printf("\nSMS SENT : %s\n",notification);
    }
}
