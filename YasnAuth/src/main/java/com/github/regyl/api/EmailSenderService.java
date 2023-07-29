package com.github.regyl.api;

public interface EmailSenderService {

    void send(String to, String subject, String text);
}
