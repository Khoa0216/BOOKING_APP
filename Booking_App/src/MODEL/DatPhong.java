/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;
import java.util.Date;
/**
 *
 * @author bobui
 */
public class DatPhong {
    private int idDatPhong; // ID đặt phòng
    private int idKhachHang; // ID khách hàng
    private int idPhong; // ID phòng
    private int soLuong; // Số lượng phòng đặt
    private int SoNgay;
    private Date ngayNhan;
    private Date ngayDat; // Ngày đặt phòng
    private String trangThai; // Trạng thái đặt phòng (VD: "Đã đặt", "Đã hủy")

    // Constructor không tham số
    public DatPhong() {
    }

    // Constructor đầy đủ tham số
    public DatPhong(int idDatPhong, int idKhachHang, int idPhong, int soLuong, Date ngayDat, String trangThai) {
        this.idDatPhong = idDatPhong;
        this.idKhachHang = idKhachHang;
        this.idPhong = idPhong;
        this.soLuong = soLuong;
        this.ngayDat = ngayDat;
        this.trangThai = trangThai;
    }

    // Getter và Setter cho từng thuộc tính
    public int getIdDatPhong() {
        return idDatPhong;
    }

    public void setIdDatPhong(int idDatPhong) {
        this.idDatPhong = idDatPhong;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }
    public int getSoNgay() {
        return SoNgay;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public void setNgayNhan(Date NgayNhan){
        this.ngayNhan = NgayNhan;
    }
    public void setSoNgay(int songay){
        this.SoNgay = songay;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }
    public Date getNgayNhan(){
        return ngayNhan;
    }
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    // Phương thức toString để hiển thị thông tin đặt phòng
    @Override
    public String toString() {
        return "DatPhong{" +
                "idDatPhong=" + idDatPhong +
                ", idKhachHang=" + idKhachHang +
                ", idPhong=" + idPhong +
                ", soLuong=" + soLuong +
                ", ngayDat=" + ngayDat +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
