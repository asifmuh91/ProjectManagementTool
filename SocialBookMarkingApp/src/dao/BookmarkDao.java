package dao;

import datastore.DataStore;
import entities.BookMark;
import entities.UserBookmark;

public class BookmarkDao {
    public static BookMark[][] getBookmarks(){
        return DataStore.getBookMarks();
    }

    public static void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.addUserBookmark(userBookmark);
    }
}
