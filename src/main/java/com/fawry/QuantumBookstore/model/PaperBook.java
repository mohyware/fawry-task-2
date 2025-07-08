package com.fawry.QuantumBookstore.model;

import com.fawry.QuantumBookstore.service.ShippingService;

public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    public double buy(int quantity, String email, String address, ShippingService shippingService)
            throws Exception {
        if (quantity > stock) {
            throw new Exception("Quantum book store: Not enough stock for ISBN " + isbn);
        }
        stock -= quantity;
        shippingService.send(address, title, quantity);
        return price * quantity;
    }

    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        throw new UnsupportedOperationException("Use buy with ShippingService for PaperBook");
    }

    public int getStock() {
        return stock;
    }
}
