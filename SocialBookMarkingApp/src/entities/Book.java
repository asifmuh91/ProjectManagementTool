package entities;

import java.util.Arrays;
import java.util.Date;

public class Book extends BookMark {

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
}
