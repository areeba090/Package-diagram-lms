public class Reservation {
    private Book book;
    private Member member;
    private String reservationDate;

    public Reservation(Book book, Member member, String reservationDate) {
        this.book = book;
        this.member = member;
        this.reservationDate = reservationDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    @Override
    public String toString() {
        return "Reservation for: " + book.toString() + " by " + member.getName();
    }
}
