package com.github.regyl.unfriendlyjarvis.api;

/**
 * Email sender service.
 */
public interface EmailSenderService {
    
    /**
     * Send email.
     *
     * @param to        email address
     * @param subject   email subject
     * @param text      email text
     */
    void send(String to, String subject, String text);
}
