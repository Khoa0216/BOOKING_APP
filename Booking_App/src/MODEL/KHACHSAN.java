package MODEL;

public class KHACHSAN extends NGUOIDUNG{
    private String TENDN;
    private String DIACHI;
    private String MOTA;
    private String TINH;
    private String STK;
    private String BANK;
    
    public KHACHSAN(){};
    public KHACHSAN(NGUOIDUNG ng){
        this.EMAIL=ng.getEMAIL();
        this.HOTEN=ng.getHOTEN();
        this.MATKHAU=ng.getMATKHAU();
        this.ID=ng.getID();
        this.LOAITK=ng.getLOAITK();
    }
    
    public KHACHSAN(Integer id,String name,String email,String tenDN,String diachi,String tinh,String mota){
        this.DIACHI = diachi;
        this.ID = id;
        this.HOTEN = name;
        this.EMAIL = email;
        this.TENDN = tenDN;
        this.MOTA = mota;
        this.TINH = tinh;                  
    }
    public KHACHSAN(Integer id,String name,String email,String tenDN,String diachi,String tinh,String mota,String bank,String stk){
        this.DIACHI = diachi;
        this.ID = id;
        this.HOTEN = name;
        this.EMAIL = email;
        this.TENDN = tenDN;
        this.MOTA = mota;
        this.TINH = tinh;  
        this.BANK = bank;
        this.STK = stk;
    }

    public String getSTK() {
        return STK;
    }

    public void setSTK(String STK) {
        this.STK = STK;
    }

    public String getBANK() {
        return BANK;
    }

    public void setBANK(String BANK) {
        this.BANK = BANK;
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
        return this.ID;
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
    public void setTINH(String tinh){
        this.TINH = tinh;
    }
    public String getTINH(){
        return this.TINH;
    }
}
