/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.librarymanagement.model;

import java.time.LocalDate;

public class Reservation {
    private Book book;
    private String memberName;
    private LocalDate reservationDate;

    public Reservation(Book book, String memberName) {
        this.book = book;
        this.memberName = memberName;
        this.reservationDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public String getMemberName() {
        return memberName;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "book=" + book +
                ", memberName='" + memberName + '\'' +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
