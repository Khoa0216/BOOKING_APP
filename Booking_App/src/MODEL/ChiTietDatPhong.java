/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author bobui
 */
public class ChiTietDatPhong {
    private int id; // ID của chi tiết đặt phòng
    private int datPhongId; // ID của đặt phòng
    private int phongId; // ID của phòng
    private double giaTien; // Giá tiền của phòng
    private String ghiChu; // Ghi chú (nếu có)

    // Constructor không tham số
    public ChiTietDatPhong() {
    }

    // Constructor đầy đủ tham số
    public ChiTietDatPhong(int id, int datPhongId, int phongId, double giaTien, String ghiChu) {
        this.id = id;
        this.datPhongId = datPhongId;
        this.phongId = phongId;
        this.giaTien = giaTien;
        this.ghiChu = ghiChu;
    }

    // Getter và Setter cho từng thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDatPhongId() {
        return datPhongId;
    }

    public void setDatPhongId(int datPhongId) {
        this.datPhongId = datPhongId;
    }

    public int getPhongId() {
        return phongId;
    }

    public void setPhongId(int phongId) {
        this.phongId = phongId;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    // Phương thức toString để hiển thị thông tin chi tiết đặt phòng
    @Override
    public String toString() {
        return "ChiTietDatPhong{" +
                "id=" + id +
                ", datPhongId=" + datPhongId +
                ", phongId=" + phongId +
                ", giaTien=" + giaTien +
                ", ghiChu='" + ghiChu + '\'' +
                '}';
    }
}
