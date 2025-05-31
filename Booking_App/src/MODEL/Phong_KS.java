package MODEL;

import java.lang.Integer;
import java.lang.Long;
import java.time.LocalDate; 
import java.sql.*;

public class Phong_KS {
    private Blob[] images = new Blob[3];
    private Integer id;
    private Integer idKS;
    private String loaiPhong;
    private String moTa;
    private Long gia;
    private Long tongSoluong;
    private Long soluongConLai;
    private LocalDate ngayDang;
    private String location;
    private Integer star;
    private Integer numReviews;
    private String tenKS;

    @Override
    public String toString() {
        return "Phong_KS{" + "id=" + id + ", idKS=" + idKS + ", loaiPhong=" + loaiPhong + ", moTa=" + moTa + ", gia=" + gia + ", tongSoluong=" + tongSoluong + ", soluongConLai=" + soluongConLai + ", ngayDang=" + ngayDang + ", location=" + location + ", star=" + star + ", numReviews=" + numReviews + '}';
    }
    
    

    public Phong_KS(Integer id, Integer idKS, String loaiPhong, String moTa, Long gia, Long tongSoluong, Long soluongConLai, LocalDate ngayDang) {
        this.id = id;
        this.idKS = idKS;
        this.loaiPhong = loaiPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.tongSoluong = tongSoluong;
        this.soluongConLai = soluongConLai;
        this.ngayDang = ngayDang;
        this.location = "null";
        this.star = 0;
        this.numReviews = 0;
    }

    public Phong_KS(Integer id, Integer idKS, String loaiPhong, String moTa, Long gia, Long tongSoluong, LocalDate ngayDang, String location, Integer star, Integer numReviews) {
        this.id = id;
        this.idKS = idKS;
        this.loaiPhong = loaiPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.tongSoluong = tongSoluong;
        
        this.ngayDang = ngayDang;
        this.location = location;
        this.star = star;
        this.numReviews = numReviews;
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKS() {
        return idKS;
    }

    public void setIdKS(Integer idKS) {
        this.idKS = idKS;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public Long getTongSoluong() {
        return tongSoluong;
    }

    public void setTongSoluong(Long tongSoluong) {
        this.tongSoluong = tongSoluong;
    }

//    public Long getSoluongConLai() {
//        return soluongConLai;
//    }
//
//    public void setSoluongConLai(Long soluongConLai) {
//        this.soluongConLai = soluongConLai;
//    }

    public LocalDate getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDate ngayDang) {
        this.ngayDang = ngayDang;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    // Getter trả về toàn bộ mảng
    public Blob[] getImages() {
        return images;
    }

    // Setter gán toàn bộ mảng (đảm bảo độ dài = 3 nếu cần)
    public void setImages(Blob[] images) {
        if (images == null || images.length != 3) {
            throw new IllegalArgumentException("Array phải có đúng 3 phần tử");
        }
        this.images = images;
    }

    // (Tùy chọn) Getter/Setter theo chỉ số
    public Blob getImage(int index) {
        return images[index];
    }

    public void setImage(int index, Blob image) {
        images[index] = image;
    }
}