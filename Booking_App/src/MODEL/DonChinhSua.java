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
public class DonChinhSua {
    private int id;                      // Mã đơn chỉnh sửa
    private String LoaiPhong;            // Tên loại phòng
    private int datPhongId;              // ID của đơn đặt phòng gốc
    private Date ngayNhanMoi;            // Ngày nhận mới
    private Date ngayTraMoi;             // Ngày trả mới
    private int slMoi;                   // Số lượng mới
    private String trangThaiDuyet;       // Trạng thái duyệt (CHỜ DUYỆT, ĐÃ DUYỆT, KHÔNG DUYỆT)
    private String trangThaiThanhToan;   // Trạng thái thanh toán (ĐÃ THANH TOÁN, CHƯA THANH TOÁN)

    
    public DonChinhSua(){
    }
    public DonChinhSua(String ttd,String tttt) {
        this.trangThaiDuyet = ttd;
        this.trangThaiThanhToan = tttt;
    }

    public DonChinhSua(int id, String LoaiPhong, int datPhongId, Date ngayNhanMoi, Date ngayTraMoi, int slMoi,
                       String trangThaiDuyet, String trangThaiThanhToan) {
        this.id = id;
        this.datPhongId = datPhongId;
        this.ngayNhanMoi = ngayNhanMoi;
        this.ngayTraMoi = ngayTraMoi;
        this.slMoi = slMoi;
        this.trangThaiDuyet = trangThaiDuyet;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.LoaiPhong=LoaiPhong;
    }

    public DonChinhSua(int id, int datPhongId, Date ngayNhanMoi, Date ngayTraMoi, int slMoi,
                       String trangThaiDuyet, String trangThaiThanhToan) {
        this.id = id;
        this.datPhongId = datPhongId;
        this.ngayNhanMoi = ngayNhanMoi;
        this.ngayTraMoi = ngayTraMoi;
        this.slMoi = slMoi;
        this.trangThaiDuyet = trangThaiDuyet;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }
    
    // Getter & Setter
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

    public Date getNgayNhanMoi() {
        return ngayNhanMoi;
    }

    public void setNgayNhanMoi(Date ngayNhanMoi) {
        this.ngayNhanMoi = ngayNhanMoi;
    }

    public Date getNgayTraMoi() {
        return ngayTraMoi;
    }

    public void setNgayTraMoi(Date ngayTraMoi) {
        this.ngayTraMoi = ngayTraMoi;
    }

    public int getSlMoi() {
        return slMoi;
    }

    public void setSlMoi(int slMoi) {
        this.slMoi = slMoi;
    }

    public String getTrangThaiDuyet() {
        return trangThaiDuyet;
    }

    public void setTrangThaiDuyet(String trangThaiDuyet) {
        this.trangThaiDuyet = trangThaiDuyet;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }
}
