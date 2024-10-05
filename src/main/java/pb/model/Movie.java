package pb.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("id")
    private Integer id;

    @SerializedName("movie")
    private String movie;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("image")
    private String image;

    @SerializedName("imdb_url")
    private String imdbUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }
}