package entities;

import Partner.Shareable;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class Weblink extends BookMark implements Shareable {
    public Weblink(int year, String url, String host, String title) {
        this.url = url;
        this.host = host;
        this.year = year;
        this.setTitle(title);
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
        return !url.contains("porn") || getTitle().contains("porn") || host.contains("adult");
    }
    @Override
    public String getItemData() {
            StringBuilder builder = new StringBuilder();
            builder.append("<item>");
            builder.append("<type><WebLink</type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<url>").append(getUrl()).append("</url>");
            builder.append("<host>").append(getHost()).append("</host>");
            return builder.toString();
        }
    }
