package entities;

public class UserBookmark {
    private User user;
    private BookMark bookMark;

    public UserBookmark(User user, BookMark bookMark) {
        this.user = user;
        this.bookMark = bookMark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookMark getBookMark() {
        return bookMark;
    }

    public void setBookMark(BookMark bookMark) {
        this.bookMark = bookMark;
    }

    @Override
    public String toString() {
        return "UserBookmark{" +
                "user=" + user +
                ", bookMark=" + bookMark +
                '}';
    }
}
