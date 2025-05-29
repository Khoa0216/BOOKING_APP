package MODEL;

public class ThanhToan_model {
    private int id;
    private String NgayGiaoDich;
    private double sotien;
    private String sothe;
    private String chuthe;
    private String tenthe;
    
    public ThanhToan_model(){};
    public ThanhToan_model(int id, double sotien){
        this.id=id;
        this.sotien=sotien;
    }
    public int getId(){
        return id;
    }
    
    public String getNgayGiaoDich(){
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
    
    public void setNgayGiaoDich(String NgayGiaoDich){
        this.NgayGiaoDich=NgayGiaoDich;
    }
    
    public void setSotien(double sotien){
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
