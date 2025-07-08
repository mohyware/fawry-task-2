package com.fawry.QuantumBookstore.model;

import com.fawry.QuantumBookstore.service.MailService;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author,
            String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    public double buy(int quantity, String email, String address, MailService mailService)
            throws Exception {
        if (quantity != 1) {
            throw new Exception("Quantum book store: EBooks can only be bought one at a time");
        }
        mailService.send(email, title);
        return price;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        throw new UnsupportedOperationException("Use buy with MailService for EBook");
    }

    public String getFileType() {
        return fileType;
    }
}
