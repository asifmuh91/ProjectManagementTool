package entities;

import constants.ApprovalStatus;

public abstract class BookMark {
    private long id;
    private String title;
    private String profileUrl;
    private String kidFriendlyStatus = ApprovalStatus.PENDING.toString();

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

    public abstract boolean isKidFriendlyEligible();
}
