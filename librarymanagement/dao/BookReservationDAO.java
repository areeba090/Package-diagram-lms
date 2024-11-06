/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.librarymanagement.dao;

import com.librarymanagement.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookReservationDAO {
    private List<Book> availableBooks;
    private List<Book> reservedBooks;

    public BookReservationDAO() {
        availableBooks = new ArrayList<>();
        reservedBooks = new ArrayList<>();
        loadAvailableBooks();
    }

    private void loadAvailableBooks() {
        availableBooks.add(new Book("Urdu"));
        availableBooks.add(new Book("Physics"));
        availableBooks.add(new Book("Chemistry"));
        availableBooks.add(new Book("Mathematics"));
        availableBooks.add(new Book("English"));
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public boolean isBookReserved(String bookName) {
        return reservedBooks.stream().anyMatch(book -> book.getTitle().equals(bookName));
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }
}
