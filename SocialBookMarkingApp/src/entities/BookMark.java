package entities;

import constants.ApprovalStatus;

public abstract class BookMark {
    private long id;
    private String title;
    private String profileUrl;
    private String kidFriendlyStatus = ApprovalStatus.PENDING.toString();
    private User bookmarkBy;
    private User shareBy;

    public String getKidFriendlyStatus() {
        return kidFriendlyStatus;
    }

    public void setKidFriendlyStatus(String kidFriendlyStatus) {
        this.kidFriendlyStatus = kidFriendlyStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public User getBookmarkBy() {
        return bookmarkBy;
    }

    public void setBookmarkBy(User bookmarkBy) {
        this.bookmarkBy = bookmarkBy;
    }

    public User getShareBy() {
        return shareBy;
    }

    public void setShareBy(User shareBy) {
        this.shareBy = shareBy;
    }

    public abstract boolean isKidFriendlyEligible();
}
