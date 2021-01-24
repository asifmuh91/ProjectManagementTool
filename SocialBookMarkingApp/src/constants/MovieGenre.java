package constants;

public enum MovieGenre {
    CLASSICS("Classics"),
    DRAMA("Drama"),
    SCIFI_AND_FANTASY("Sci-Fi & Fantasy"),
    COMEDY("Comedy");

    private final String movieGenre;

    private MovieGenre(String movieGenre){
        this.movieGenre = movieGenre;
    }

    public String getMovieGenre(){
        return this.movieGenre;
    }

}
