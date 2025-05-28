package model;

import java.lang.Integer;
import java.lang.Long;
import java.time.LocalDate; 

public class Phong_KS {
    private Integer id;
    private Integer idKS;
    private String loaiPhong;
    private String moTa;
    private Long gia;
    private Long tongSoluong;
    private Long soluongConLai;
    private LocalDate ngayDang;

    public Phong_KS(Integer id, Integer idKS, String loaiPhong, String moTa, Long gia, Long tongSoluong, Long soluongConLai, LocalDate ngayDang) {
        this.id = id;
        this.idKS = idKS;
        this.loaiPhong = loaiPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.tongSoluong = tongSoluong;
        this.soluongConLai = soluongConLai;
        this.ngayDang = ngayDang;
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

    public Long getSoluongConLai() {
        return soluongConLai;
    }

    public void setSoluongConLai(Long soluongConLai) {
        this.soluongConLai = soluongConLai;
    }

    public LocalDate getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(LocalDate ngayDang) {
        this.ngayDang = ngayDang;
    }

    
}