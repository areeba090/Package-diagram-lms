import java.util.ArrayList;
import java.util.List;

public class Librarian {
    private List<Reservation> reservations;

    public Librarian() {
        this.reservations = new ArrayList<>();
    }

    // Reserve a book
    public String reserveBook(Book book, Member member, String reservationDate) {
        if (book.isReserved()) {
            return "The book is already reserved.";
        }

        // Create a new reservation
        book.reserve();
        Reservation reservation = new Reservation(book, member, reservationDate);
        reservations.add(reservation);

        return "Book reserved successfully for " + member.getName() + ".";
    }

    // Cancel a reservation
    public String cancelReservation(Book book, Member member) {
        for (Reservation reservation : reservations) {
            if (reservation.getBook().equals(book) && reservation.getMember().equals(member)) {
                reservations.remove(reservation);
                book.unreserve();
                return "Reservation canceled successfully for " + member.getName() + ".";
            }
        }
        return "Reservation not found.";
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
