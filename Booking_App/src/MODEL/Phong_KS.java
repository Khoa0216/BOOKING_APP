package model;

import java.lang.Integer;
import java.lang.Long;

public class Phong_KS {
    private Integer id;
    private Integer doanhnghie_id;
    private String tenPhong;
    private String loaiPhong;
    private String moTa;
    private Long gia;
    private Long tongSoluong;
    private Long soluongConLai;

    public Phong_KS(Integer id, Integer doanhnghie_id, String tenPhong, String loaiPhong, Long gia, String moTa, Long tongSoluong, Long soluongConLai) {
        this.id = id;
        this.doanhnghie_id = doanhnghie_id;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.tongSoluong = tongSoluong;
        this.soluongConLai = soluongConLai;
    }

    // Getter và Setter cho id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter và Setter cho doanhnghie_id
    public Integer getDoanhnghie_id() {
        return doanhnghie_id;
    }

    public void setDoanhnghie_id(Integer doanhnghie_id) {
        this.doanhnghie_id = doanhnghie_id;
    }

    // Getter và Setter cho tenPhong
    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    // Getter và Setter cho loaiPhong
    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    // Getter và Setter cho moTa
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    public Long getGia(){
        return this.gia;
    }
    
    public void setGia(Long gia){
        this.gia = gia;
    }

    // Getter và Setter cho tongSoluong
    public Long getTongSoluong() {
        return tongSoluong;
    }

    public void setTongSoluong(Long tongSoluong) {
        this.tongSoluong = tongSoluong;
    }

    // Getter và Setter cho soluongConLai
    public Long getSoluongConLai() {
        return soluongConLai;
    }

    public void setSoluongConLai(Long soluongConLai) {
        this.soluongConLai = soluongConLai;
    }
}