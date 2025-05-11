/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.lang.Integer;
import java.lang.Long;
/**
 *
 * @author Admin
 */
public class Chuyen_DangTai {
    private Integer id;
    private Integer doanhnghiepPT_id;
    private String loaiPhuongTien;
    private String diemDi;
    private String diemDen;
    private String ngayGioKhoiHanh;
    private String moTa;
    private Long gia;
    private Long tongSoluong;
    private Long soluongConLai;

    public Chuyen_DangTai (Integer id, Integer doanhnghiep_id, String loaiPT, String diemdi, String diemden, String ngayGioKhoiHanh, Long gia, String moTa, Long tongSoluong, Long soluongConLai) {
        this.id = id;
        this.doanhnghiepPT_id = doanhnghiep_id;
        this.loaiPhuongTien = loaiPT;
        this.diemDi = diemdi;
        this.diemDen = diemden;
        this.ngayGioKhoiHanh = ngayGioKhoiHanh;
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

    // Getter và Setter cho doanhnghiePT_id
    public Integer getDoanhnghiepPT_id() {
        return doanhnghiepPT_id;
    }

    public void setDoanhnghiePT_id(Integer doanhnghiepPT_id) {
        this.doanhnghiepPT_id = doanhnghiepPT_id;
    }

    // Getter và Setter cho loaiPhuongTien
    public String getLoaiPhuongTien() {
        return loaiPhuongTien;
    }
    
    public void setLoaiPhuongTien(String loaiPhuongTien) {
        this.loaiPhuongTien = loaiPhuongTien;
    }

    // Getter và Setter cho diemDi
    public String getDiemDi() {
        return diemDi;
    }

    public void setDiemDi(String diemDi) {
        this.diemDi = diemDi;
    }

    // Getter và Setter cho diemDen
    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemden) {
        this.diemDen = diemden;
    }
    
    // Getter và Setter cho ngayGioKhoiHanh
    public String getNgayGioKhoiHanh() {
        return ngayGioKhoiHanh;
    }

    public void setNgayGioKhoiHanhi(String ngaygio) {
        this.ngayGioKhoiHanh = ngaygio;
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
    public Long getSoLuongConLai() {
        return soluongConLai;
    }

    public void setSoLuongConLai(Long soluongConLai) {
        this.soluongConLai = soluongConLai;
    }
}
