package com.fawry.QuantumBookstore.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.fawry.QuantumBookstore.model.Book;
import com.fawry.QuantumBookstore.model.EBook;
import com.fawry.QuantumBookstore.model.PaperBook;

public class QuantumBooksSystem {
    private List<Book> books = new ArrayList<>();
    private final MailService mailService;
    private final ShippingService shippingService;

    public QuantumBooksSystem() {
        this.mailService = new MailService();
        this.shippingService = new ShippingService();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Quantum book store: Added book '" + book.getTitle() + "' (ISBN: "
                + book.getIsbn() + ")");
    }

    public List<Book> removeOutdatedBooks(int currentYear, int maxAge) {
        List<Book> removed = new ArrayList<>();
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.isOutdated(currentYear, maxAge)) {
                removed.add(b);
                it.remove();
                System.out.println(
                        "Quantum book store: Removed outdated book '" + b.getTitle() + "'");
            }
        }
        return removed;
    }

    public double buyBook(String isbn, int quantity, String email, String address)
            throws Exception {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                double paid;
                if (b instanceof PaperBook) {
                    paid = ((PaperBook) b).buy(quantity, email, address, shippingService);
                } else if (b instanceof EBook) {
                    paid = ((EBook) b).buy(quantity, email, address, mailService);
                } else {
                    paid = b.buy(quantity, email, address);
                }
                System.out.println(
                        "Quantum book store: Book bought: '" + b.getTitle() + "', paid: " + paid);
                return paid;
            }
        }
        throw new Exception("Quantum book store: Book with ISBN " + isbn + " not found");
    }

    public List<Book> getBooks() {
        return books;
    }
}
