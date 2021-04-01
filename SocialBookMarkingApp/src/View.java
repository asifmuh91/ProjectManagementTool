import Partner.Shareable;
import constants.ApprovalStatus;
import constants.UserType;
import controllers.BookmarkController;
import datastore.DataStore;
import entities.BookMark;
import entities.User;

public class View {
    public static void browse(User user, BookMark[][] bookMarks){
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        int bookmarkCount = 0;

        for(BookMark[] bookMarkList:bookMarks){
            for(BookMark bookMark:bookMarkList){
                boolean isBookmarked = getBookmarkDecision(bookMark);
                if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    if (isBookmarked) {
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookMark);
                        System.out.println("new Item bookmarked " + bookMark);
                    }
                }
                if(user.getUserType().equalsIgnoreCase(UserType.EDITOR.toString()) || user.getUserType().equalsIgnoreCase(UserType.CHIEF_EDITOR.toString()) ){
                    if(bookMark.isKidFriendlyEligible() && bookMark.getKidFriendlyStatus().equalsIgnoreCase(ApprovalStatus.PENDING.toString())){
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookMark);
                        if(!kidFriendlyStatus.equalsIgnoreCase(ApprovalStatus.PENDING.toString())){
                            BookmarkController.getInstance().setKindFriendlyStatus(user,kidFriendlyStatus,bookMark);
                        }
                    }
                    if(bookMark.getKidFriendlyStatus().equalsIgnoreCase(ApprovalStatus.APPROVED.toString())
                     && bookMark instanceof Shareable)
                    {
                        boolean isShared =getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user, bookMark);
                        }
                    }
                }
            }
        }
    }

    //TODO: below methods similar user input
    private static boolean getShareDecision() {
        return Math.random() < 0.5;
    }

    private static String getKidFriendlyStatusDecision(BookMark bookMark) {
        return Math.random() < 0.4 ? ApprovalStatus.APPROVED.toString() :
                (Math.random() >=0.4 && Math.random() <0.8 ? ApprovalStatus.REJECTED.toString():ApprovalStatus.PENDING.toString());
    }

    private static boolean getBookmarkDecision(BookMark bookMark) {
        return Math.random() < 0.5;
    }
}
