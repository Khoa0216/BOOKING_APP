package MODEL;

import java.time.LocalDate;

public class ThanhToan_model {
    private int id;
    private LocalDate NgayGiaoDich;
    private Long sotien;
    private String sothe;
    private String chuthe;
    private String tenthe;
    
    public ThanhToan_model(){};
    public ThanhToan_model(int id, Long sotien){
        this.id=id;
        this.sotien=sotien;
    }
    public int getId(){
        return id;
    }
    
    public LocalDate getNgayGiaoDich(){
        return NgayGiaoDich;
    }
    
    public double getSotien(){
        return sotien;
    }
    
    public String getSothe(){
        return sothe;
    }
    
    public String getChuthe(){
        return chuthe;
    }
    
    public String getTenthe(){
        return tenthe;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public void setNgayGiaoDich(LocalDate NgayGiaoDich){
        this.NgayGiaoDich=NgayGiaoDich;
    }
    
    public void setSotien(Long sotien){
        this.sotien=sotien;
    }
    
    public void setSothe(String sothe){
        this.sothe=sothe;
    }
    
    public void setChuthe(String chuthe){
        this.chuthe=chuthe;
    }
    
    public void setTenthe(String tenthe){
        this.tenthe=tenthe;
    }
}
