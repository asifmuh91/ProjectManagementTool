package entities;

public class Weblink extends BookMark {
    public Weblink(int year, String url, String host) {
        this.url = url;
        this.host = host;
        this.year = year;
    }

    private int year;
    private String url;
    private String host;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Weblink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        return !this.url.contains("porn") || this.getTitle().contains("porn") || this.host.contains("adult");
    }
}
