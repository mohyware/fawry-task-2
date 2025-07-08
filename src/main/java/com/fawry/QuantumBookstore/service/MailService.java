package com.fawry.QuantumBookstore.service;

public class MailService {
    public void send(String email, String bookTitle) {
        System.out.println("Quantum book store: Sending '" + bookTitle + "' to email: " + email);
    }
}
