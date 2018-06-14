package ahuja.shivam.json_volley_imagepractice;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by root on 18/7/17.
 */

    public class Movie {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("rating")
        @Expose
        private Double rating;
        @SerializedName("releaseYear")
        @Expose
        private Integer releaseYear;
        @SerializedName("genre")
        @Expose
        private List<String> genre = null;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }

        public Integer getReleaseYear() {
            return releaseYear;
        }

        public void setReleaseYear(Integer releaseYear) {
            this.releaseYear = releaseYear;
        }

        public List<String> getGenre() {
            return genre;
        }

        public void setGenre(List<String> genre) {
            this.genre = genre;
        }

    }

