package MODEL;

public class KHACHHANG extends NGUOIDUNG{
    private String CCCD;
    private String NGAYSINH;
    
    public KHACHHANG() {};
    public KHACHHANG(NGUOIDUNG ng){
        this.EMAIL=ng.getEMAIL();
        this.HOTEN=ng.getHOTEN();
        this.MATKHAU=ng.getMATKHAU();
        this.ID=ng.getID();
        this.LOAITK=ng.getLOAITK();
    }
    public KHACHHANG(String name, String cccd, String date){
        this.HOTEN = name;
        this.CCCD = cccd;
        this.NGAYSINH = date;
    }
    public KHACHHANG(Integer id,String name,String email,String cccd,String date,String pass){
        this.HOTEN = name;
        this.EMAIL = email;
        this.ID = id;
        this.CCCD = cccd;
        this.NGAYSINH = date;
        this.MATKHAU = pass;
    }
    public KHACHHANG(String name, String email, String cccd, String date, String pass) {
        this.HOTEN = name;
        this.EMAIL = email;
        this.CCCD = cccd;
        this.NGAYSINH = date;
        this.MATKHAU = pass;
    }

    public String getCCCD() {
        return CCCD;
    }

    @Override
    public String getEMAIL() {
        return EMAIL;
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getLOAITK() {
        return "KHACHHANG";
    }

    @Override
    public String getMATKHAU() {
        return MATKHAU;
    }

    public String getNGAYSINH() {
        return NGAYSINH;
    }

    @Override
    public String getHOTEN() {
        return HOTEN;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    @Override
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public void setLOAITK(String LOAITK) {
        this.LOAITK = LOAITK;
    }

    @Override
    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public void setNGAYSINH(String NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }
    
    
    
    
}
