package entities;

import Partner.Shareable;
import com.sun.deploy.util.StringUtils;

import java.util.Arrays;
import java.util.Date;

public class Book extends BookMark implements Shareable {

    private String publicationYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRating;

    public Book(String publicationYear, String publisher, String[] authors, String genre, double amazonRating) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.authors = authors;
        this.genre = genre;
        this.amazonRating = amazonRating;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAmazonRating() {
        return amazonRating;
    }

    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "publicationYear='" + publicationYear + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", genre='" + genre + '\'' +
                ", amazonRating=" + amazonRating +
                '}';
    }

    @Override
    public boolean isKidFriendlyEligible() {
        return false;
    }

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
        builder.append("<type><Book</type>");
        builder.append("<title>").append(getTitle()).append("</title>");
        builder.append("<authors>").append(StringUtils.join(Arrays.asList(authors),",")).append("<genre>");
        builder.append("<publisher>").append(publisher).append("</publisher>");
        builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
        builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
        builder.append("<genre>").append(genre).append("<genre>");
        return builder.toString();
    }
}
