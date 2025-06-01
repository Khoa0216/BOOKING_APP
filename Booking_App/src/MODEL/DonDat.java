package MODEL;

import java.lang.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Date;

public class DonDat {
    private Integer id, idKH, idKS, idP,sl;
    private String tenKH, tenKS, tenPhong;
    private Long gia;
    private Date ngayDat;
    
    
    private Date ngayNhan, ngayTra;
    

    public DonDat() {
    }
    public DonDat(Integer id,Integer idKH,Date ngaynhan,Date ngaytra,Integer sl,Date ngaydat,Long gia) {
        this.id = id;
        this.idKH = idKH;
        this.gia = gia;
        this.ngayDat = ngaydat;
        this.ngayNhan = ngaynhan;
        this.ngayTra = ngaytra;
        this.sl = sl;
        this.gia = gia;
    }
    

    public DonDat(Integer id, Integer idKH, Integer idKS, Integer idP, String tenKH, String tenKS, Long gia, Date ngayDat) {
        this.id = id;
        this.idKH = idKH;
        this.idKS = idKS;
        this.idP = idP;
        this.tenKH = tenKH;
        this.tenKS = tenKS;
        this.gia = gia;
        this.ngayDat = ngayDat;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKH() {
        return idKH;
    }

    public void setIdKH(Integer idKH) {
        this.idKH = idKH;
    }

    public Integer getIdKS() {
        return idKS;
    }

    public void setIdKS(Integer idKS) {
        this.idKS = idKS;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getTenKS() {
        return tenKS;
    }

    public void setTenKS(String tenKS) {
        this.tenKS = tenKS;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }
    
    
}
