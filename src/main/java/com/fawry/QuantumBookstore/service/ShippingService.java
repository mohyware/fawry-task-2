package com.fawry.QuantumBookstore.service;

public class ShippingService {
    public void send(String address, String bookTitle, int quantity) {
        System.out.println("Quantum book store: Shipping " + quantity + " copy(ies) of '"
                + bookTitle + "' to address: " + address);
    }
}
