package com.example.foodcollector.service;

import com.example.foodcollector.domain.MailType;
import com.example.foodcollector.domain.user.User;

import java.util.Map;
import java.util.Properties;

public interface MailService {
    void sendMail(User user, MailType type, Properties params);
}
