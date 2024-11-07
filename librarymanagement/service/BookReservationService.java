/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.librarymanagement.service;

import com.librarymanagement.dao.BookReservationDAO;
import com.librarymanagement.model.Book;

import java.util.List;

public class BookReservationService {
    private BookReservationDAO bookReservationDAO;

    public BookReservationService() {
        this.bookReservationDAO = new BookReservationDAO();
    }

    public List<Book> getAvailableBooks() {
        return bookReservationDAO.getAvailableBooks();
    }

    public boolean isBookAvailable(String bookName) {
        return !bookReservationDAO.isBookReserved(bookName);
    }

    public boolean reserveBook(String bookName) {
        List<Book> books = bookReservationDAO.getAvailableBooks();
        for (Book book : books) {
            if (book.getTitle().equals(bookName)) {
                bookReservationDAO.reserveBook(book);
                return true;
            }
        }
        return false;
    }
}
