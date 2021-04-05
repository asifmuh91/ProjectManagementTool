package controllers;

import entities.BookMark;
import entities.User;
import services.BookmarkManager;

public class BookmarkController {
    private static volatile BookmarkController bookmarkController = null;
    private BookmarkController(){

    };

    public static BookmarkController getInstance(){
        if(bookmarkController==null){
            synchronized (BookmarkController.class){
                if(bookmarkController==null){
                    bookmarkController = new BookmarkController();
                }
            }
        }
        return bookmarkController;
    }

    public void saveUserBookmark(User user, BookMark bookMark){
        BookmarkManager.getInstance().saveUserBookmark(user,bookMark);
    }

    public void setKindFriendlyStatus(User user, String kidFriendlyStatus, BookMark bookMark) {
        BookmarkManager.getInstance().setKidFriendly(user,kidFriendlyStatus,bookMark);
    }

    public void share(User user, BookMark bookMark) {
        BookmarkManager.getInstance().share(user,bookMark);
    }
}
