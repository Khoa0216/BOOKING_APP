package model;

/**
 *
 * @author Admin
 */
import java.lang.*;
import java.time.LocalDateTime;
public class DonDat {
    private Integer id, idKH, idKS, idP;
    private String tenKH, tenKS;
    private Long gia;
    private LocalDateTime ngayDat;

    public DonDat() {
    }

    public DonDat(Integer id, Integer idKH, Integer idKS, Integer idP, String tenKH, String tenKS, Long gia, LocalDateTime ngayDat) {
        this.id = id;
        this.idKH = idKH;
        this.idKS = idKS;
        this.idP = idP;
        this.tenKH = tenKH;
        this.tenKS = tenKS;
        this.gia = gia;
        this.ngayDat = ngayDat;
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

    public LocalDateTime getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(LocalDateTime ngayDat) {
        this.ngayDat = ngayDat;
    }
    
    
}
