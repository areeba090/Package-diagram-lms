public class LibraryManagementSystemTest {
    public static void main(String[] args) {
        // Create Librarian (controller)
        Librarian librarian = new Librarian();

        // Create Book and Member objects
        Book book1 = new Book("Effective Java", "Joshua Bloch");
        Member member1 = new Member("M01", "John Doe");

        // Reserve a book
        String result = librarian.reserveBook(book1, member1, "2024-11-05");
        System.out.println(result);  // Output: Book reserved successfully for John Doe.

        // Attempt to reserve the same book again
        String result2 = librarian.reserveBook(book1, member1, "2024-11-05");
        System.out.println(result2); // Output: The book is already reserved.

        // Cancel the reservation
        String result3 = librarian.cancelReservation(book1, member1);
        System.out.println(result3); // Output: Reservation canceled successfully for John Doe.
    }
}
