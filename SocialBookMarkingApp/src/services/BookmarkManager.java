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

    public Weblink createWebLink(int year, String url, String host){
        return new Weblink(year,url,host);
    }
    public BookMark[][] getBookmarks(){
        return BookmarkDao.getBookmarks();
    }


    public void saveUserBookmark(User user, BookMark bookMark) {
        UserBookmark userBookmark = new UserBookmark(user,bookMark);
        BookmarkDao.saveUserBookmark(userBookmark);
    }
}
