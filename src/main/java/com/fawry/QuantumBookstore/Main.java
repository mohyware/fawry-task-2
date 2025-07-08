package com.fawry.QuantumBookstore;

import com.fawry.QuantumBookstore.model.EBook;
import com.fawry.QuantumBookstore.model.PaperBook;
import com.fawry.QuantumBookstore.model.ShowcaseBook;
import com.fawry.QuantumBookstore.service.QuantumBooksSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Quantum Bookstore Demo ===\n");
        QuantumBooksSystem system = new QuantumBooksSystem();

        // Add books
        PaperBook paperBook = new PaperBook("111", "Java Basics", 2010, 100.0, "Alice Smith", 5);
        EBook eBook = new EBook("222", "Learn AI", 2018, 50.0, "Bob Jones", "PDF");
        ShowcaseBook showcaseBook =
                new ShowcaseBook("333", "Rare Book", 1990, 0.0, "White Ibrahim");
        system.addBook(paperBook);
        system.addBook(eBook);
        system.addBook(showcaseBook);

        // === Test Case 1: Normal Paper Book Purchase ===
        System.out.println("\n=== Test Case 1: Normal Paper Book Purchase ===");
        try {
            double paid = system.buyBook("111", 2, "mohyware@gmail.com", "cairo");
            System.out.println("Quantum book store: Paid amount: " + paid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === Test Case 2: Normal EBook Purchase ===
        System.out.println("\n=== Test Case 2: Normal EBook Purchase ===");
        try {
            double paid = system.buyBook("222", 1, "mohyware@gmail.com", "cairo");
            System.out.println("Quantum book store: Paid amount: " + paid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === Test Case 3: Showcase Book Purchase Error ===
        System.out.println("\n=== Test Case 3: Showcase Book Purchase Error ===");
        try {
            system.buyBook("333", 1, "mohyware@gmail.com", "cairo");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === Test Case 4: Out of Stock Error ===
        System.out.println("\n=== Test Case 4: Out of Stock Error ===");
        try {
            system.buyBook("111", 10, "mohyware@gmail.com", "cairo");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // === Test Case 5: Remove Outdated Book ===
        System.out.println("\n=== Test Case 5: Remove Outdated Book ===");
        system.removeOutdatedBooks(2024, 10);

        // === Test Case 6: Buy Removed/Outdated Book Error ===
        System.out.println("\n=== Test Case 6: Buy Removed/Outdated Book Error ===");
        try {
            system.buyBook("111", 1, "mohyware@gmail.com", "cairo");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
