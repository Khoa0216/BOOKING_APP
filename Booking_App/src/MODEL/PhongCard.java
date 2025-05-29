package model;

/**
 *
 * @author Admin
 */
import java.lang.Integer;
import java.lang.Double;

public class PhongCard {
    private Integer idP;
    private String imagePath;
    private String loaiPhong;
    private Integer star;
    private String location;
    private String description;
    private Double score;
    private Integer reviews;
    private Double price;

    public PhongCard(String imagePath, String loaiPhong, String location, String description, Double price) {
        this.imagePath = imagePath;
        this.loaiPhong = loaiPhong;
        this.location = location;
        this.description = description;
        this.price = price;
    }
    
    
    
    public PhongCard(String imagePath, String loaiPhong, Integer star, String location, String description, Double score, Integer reviews, Double price) {
        this.imagePath = imagePath;
        this.loaiPhong = loaiPhong;
        this.star = star;
        this.location = location;
        this.description = description;
        this.score = score;
        this.reviews = reviews;
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Integer getStart() {
        return star;
    }

    public void setStart(Integer start) {
        this.star = start;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
}
