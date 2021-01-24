import controllers.BookmarkController;
import datastore.DataStore;
import entities.BookMark;
import entities.User;

public class View {
    public static void bookmark(User user, BookMark[][] bookMarks){
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        for(int i=0; i < DataStore.USER_BOOKMARK_LIMIT;i++){
            int typeOffSet = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffSet = (int)(Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
            BookMark bookMark = bookMarks[typeOffSet][bookmarkOffSet];
            BookmarkController.getInstance().saveUserBookmark(user,bookMark);
            System.out.println(bookMark);
        }
    }
}
