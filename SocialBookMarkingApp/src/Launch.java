import datastore.DataStore;
import entities.BookMark;
import entities.User;
import services.BookmarkManager;
import services.UserService;

public class Launch {
    private static User[] users;
    private static BookMark[][] bookMarks;

    private static void startBookmarking(){
        System.out.println("\n2. Bookmarking...");
        for(User user: users){
            View.bookmark(user,bookMarks);
        }
    }

    public static void main(String [] args){
        loaddata();
        startBookmarking();

    }
    public static void loaddata(){
        System.out.println("Loading Data");
        DataStore.loadData();
        users = UserService.getInstance().getUsers();
        bookMarks = BookmarkManager.getInstance().getBookmarks();
        System.out.println("printing user data...");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("printing bookmark data..");
        for(BookMark[] bookmarkList:bookMarks){
            for(BookMark bookMark:bookmarkList){
                System.out.println(bookMark);
            }
        }

    }
}
