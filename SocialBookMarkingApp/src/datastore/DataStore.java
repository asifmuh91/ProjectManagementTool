package datastore;

import constants.BookGenre;
import constants.Gender;
import constants.MovieGenre;
import constants.UserType;
import entities.BookMark;
import entities.User;
import entities.UserBookmark;
import services.BookmarkManager;
import services.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataStore {
    public static final int TOTAL_NUMBER_OF_USERS = 5;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int USER_BOOKMARK_LIMIT = 5;
    private static int bookmarkIndex = 0;

    private static User[] users = new User[TOTAL_NUMBER_OF_USERS];
    private static BookMark[][] bookMarks = new BookMark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_NUMBER_OF_USERS*USER_BOOKMARK_LIMIT];

    public static void loadData(){
        loadUsers();
        loadWeblinks();
        loadMovies();
        loadBooks();
    }

    public static User[] getUsers(){
        return users;
    }

    public static BookMark[][] getBookMarks(){
        return bookMarks;
    }

    public static UserBookmark[] getUserBookmarks(){
        return userBookmarks;
    }

    private static void loadUsers(){
        users[0] = UserService.getInstance().createUser(1,"asifabbasi84@hotmail.com","killer","asif","abbasi", Gender.MALE.toString(), UserType.CHIEF_EDITOR.toString());
        users[1] = UserService.getInstance().createUser(2,"amylouise@hotmail.com","killer","amy","louise", Gender.FEMALE.toString(), UserType.USER.toString());
        users[2] = UserService.getInstance().createUser(3,"alex@hotmail.com","killer","alex","pickles", Gender.MALE.toString(), UserType.USER.toString());
        users[3] = UserService.getInstance().createUser(1,"beela@hotmail.com","killer","bella","khan", Gender.MALE.toString(), UserType.CHIEF_EDITOR.toString());
        users[4] = UserService.getInstance().createUser(1,"nabil@hotmail.com","killer","nabil","anis", Gender.MALE.toString(), UserType.CHIEF_EDITOR.toString());

    }
    private static void loadWeblinks(){
        bookMarks[0][0]= BookmarkManager.getInstance().createWebLink(2000,"intranet.db.com","db.com");
        bookMarks[0][1]= BookmarkManager.getInstance().createWebLink(2001,"facebook.com","fb.com");
        bookMarks[0][2]= BookmarkManager.getInstance().createWebLink(2020,"facebook.com","fb.com");
        bookMarks[0][3]= BookmarkManager.getInstance().createWebLink(2005,"facebook.com","fb.com");
        bookMarks[0][4]= BookmarkManager.getInstance().createWebLink(2008,"facebook.com","fb.com");
    }
    private static void loadMovies(){
        bookMarks[1][0] = BookmarkManager.getInstance().createMovie(2002,new String[]{"me"}, new String[]{"me"},MovieGenre.COMEDY.toString(),9.9);
        bookMarks[1][1] = BookmarkManager.getInstance().createMovie(2002,new String[]{"me"}, new String[]{"me"},MovieGenre.COMEDY.toString(),9.9);
        bookMarks[1][2] = BookmarkManager.getInstance().createMovie(2002,new String[]{"me"}, new String[]{"me"},MovieGenre.COMEDY.toString(),9.9);
        bookMarks[1][3] = BookmarkManager.getInstance().createMovie(2002,new String[]{"me"}, new String[]{"me"},MovieGenre.COMEDY.toString(),9.9);
        bookMarks[1][4] = BookmarkManager.getInstance().createMovie(2002,new String[]{"me"}, new String[]{"me"},MovieGenre.COMEDY.toString(),9.9);

    }
    private static void loadBooks(){
        bookMarks[2][0]=BookmarkManager.getInstance().createBook((new SimpleDateFormat("dd-MM-yyyy").format(new Date())),"dreamtech",new String[]{"Army","Asif"}, BookGenre.BIOGRAPHY.toString(),9.8);
        bookMarks[2][1]=BookmarkManager.getInstance().createBook((new SimpleDateFormat("dd-MM-yyyy").format(new Date())),"dreamtech",new String[]{"Army","Asif"}, BookGenre.ART.toString(),9.8);
        bookMarks[2][2]=BookmarkManager.getInstance().createBook((new SimpleDateFormat("dd-MM-yyyy").format(new Date())),"dreamtech",new String[]{"Army","Asif"}, BookGenre.ART.toString(),9.8);
        bookMarks[2][3]=BookmarkManager.getInstance().createBook((new SimpleDateFormat("dd-MM-yyyy").format(new Date())),"dreamtech",new String[]{"Army","Asif"}, BookGenre.ART.toString(),9.8);
        bookMarks[2][4]=BookmarkManager.getInstance().createBook((new SimpleDateFormat("dd-MM-yyyy").format(new Date())),"dreamtech",new String[]{"Army","Asif"}, BookGenre.ART.toString(),9.8);


    }

    public static void addUserBookmark(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;
    }
}
