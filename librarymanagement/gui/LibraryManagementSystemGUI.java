/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.librarymanagement.gui;

import com.librarymanagement.model.Book;
import com.librarymanagement.service.BookReservationService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystemGUI {
    private static BookReservationService reservationService = new BookReservationService();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Library Management System - Book Reservation");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel instructionLabel = new JLabel("Select Book to Reserve:");
        JComboBox<Book> bookComboBox = new JComboBox<>();
        for (Book book : reservationService.getAvailableBooks()) {
            bookComboBox.addItem(book);
        }
        
        JTextField memberNameField = new JTextField();
        JButton reserveButton = new JButton("Reserve Book");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book selectedBook = (Book) bookComboBox.getSelectedItem();
                String memberName = memberNameField.getText();
                if (reservationService.isBookAvailable(selectedBook.getTitle())) {
                    if (reservationService.reserveBook(selectedBook.getTitle())) {
                        outputArea.setText("The book \"" + selectedBook.getTitle() + "\" has been reserved successfully for " + memberName + ".");
                    }
                } else {
                    outputArea.setText("The book \"" + selectedBook.getTitle() + "\" is not available for reservation.");
                }
            }
        });

        frame.add(instructionLabel);
        frame.add(bookComboBox);
        frame.add(new JLabel("Enter Member Name:"));
        frame.add(memberNameField);
        frame.add(reserveButton);
        frame.add(outputArea);
        frame.setVisible(true);
    }
}
