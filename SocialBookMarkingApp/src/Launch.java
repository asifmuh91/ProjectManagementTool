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
            View.browse(user,bookMarks);
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

    }
}
