package MODEL;

public class NGUOIDUNG {
    protected int ID;
    protected String EMAIL;
    protected String MATKHAU;
    protected String HOTEN;
    protected String LOAITK;
    
    public NGUOIDUNG(){};
    
    public NGUOIDUNG(String EMAIL, String MATKHAU, String HOTEN){
        this.EMAIL=EMAIL;
        this.MATKHAU=MATKHAU;
        this.HOTEN=HOTEN;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public String getLOAITK() {
        return LOAITK;
    }

    public int getID() {
        return ID;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public void setLOAITK(String LOAITK) {
        this.LOAITK = LOAITK;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
