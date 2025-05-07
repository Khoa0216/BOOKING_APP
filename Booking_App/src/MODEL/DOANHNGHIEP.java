package MODEL;

public class DOANHNGHIEP extends NGUOIDUNG{
    private String TENDN;
    private String LOAIDN;
    private String DIACHI;
    private String MOTA;
    
    public DOANHNGHIEP(){};
    public DOANHNGHIEP(NGUOIDUNG ng){
        this.EMAIL=ng.getEMAIL();
        this.HOTEN=ng.getHOTEN();
        this.MATKHAU=ng.getMATKHAU();
        this.ID=ng.getID();
        this.LOAITK=ng.getLOAITK();
    }

    public String getDIACHI() {
        return DIACHI;
    }

    @Override
    public String getEMAIL() {
        return EMAIL;
    }

    @Override
    public String getHOTEN() {
        return HOTEN;
    }

    @Override
    public int getID() {
        return ID;
    }

    public String getLOAIDN() {
        return LOAIDN;
    }

    @Override
    public String getLOAITK() {
        return LOAITK;
    }

    @Override
    public String getMATKHAU() {
        return MATKHAU;
    }

    public String getMOTA() {
        return MOTA;
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
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

    public void setLOAIDN(String LOAIDN) {
        this.LOAIDN = LOAIDN;
    }

    @Override
    public void setLOAITK(String LOAITK) {
        this.LOAITK = LOAITK;
    }

    @Override
    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }
}
