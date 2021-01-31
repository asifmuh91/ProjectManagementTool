package services;

import dao.BookmarkDao;
import entities.*;

import java.util.Date;

public class BookmarkManager {
    private BookmarkManager(){
    }
    private static volatile BookmarkManager bookmarkManager = null;

    public static BookmarkManager getInstance(){
        if(bookmarkManager==null){
            synchronized (BookmarkManager.class){
                if(bookmarkManager==null){
                    bookmarkManager = new BookmarkManager();
                }
            }
        }
        return bookmarkManager;
    }

    public Movie createMovie(int releaseYear, String[] cast, String[] directors, String genre, double imdbRating){
        return new Movie(releaseYear,cast,directors, genre,imdbRating);
    }

    public Book createBook(String publicationYear, String publisher, String[] authors, String genre, double amazonRating){
        return new Book(publicationYear, publisher, authors, genre, amazonRating);
    }

    public Weblink createWebLink(int year, String url, String host, String title){
        return new Weblink(year,url,host, title);
    }
    public BookMark[][] getBookmarks(){
        return BookmarkDao.getBookmarks();
    }


    public void saveUserBookmark(User user, BookMark bookMark) {
        UserBookmark userBookmark = new UserBookmark(user,bookMark);
        BookmarkDao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendly(User user, String kidFriendlyStatus, BookMark bookMark) {
        bookMark.setKidFriendlyStatus(kidFriendlyStatus);
        bookMark.setBookmarkBy(user);
        System.out.println("kid - friendly status : " + kidFriendlyStatus + "," + bookMark + "," + user);
    }

    public void share(User user, BookMark bookMark) {
        bookMark.setShareBy(user);
        System.out.println("Data to be shared :");
        if(bookMark instanceof Book) {
            System.out.println(((Book) bookMark).getItemData());
        }
        else {
            System.out.println(((Weblink) bookMark).getItemData());
        }
    }
}
