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
        return LOAITK;
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
