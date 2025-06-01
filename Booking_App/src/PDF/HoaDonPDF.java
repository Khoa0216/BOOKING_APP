package PDF;

import MODEL.DonDat;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;

public class HoaDonPDF {

    public static void xuatHoaDonPDF(DonDat don, String tenChuThe, String loaiThe, String soThe, long tongtien, String path) {
        try {
            Document document = new Document(PageSize.A6, 10, 10, 10, 10);
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();

            // Định dạng font
            Font fontTitle = new Font(Font.HELVETICA, 18, Font.BOLD);
            Font fontSub = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font fontNormal = new Font(Font.HELVETICA, 12, Font.NORMAL);

            DateTimeFormatter dfNgay = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter dfNgayGio = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            // Tiêu đề (căn giữa)
            Paragraph title = new Paragraph("HÓA ĐƠN THANH TOÁN", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            Paragraph ngayLap = new Paragraph("Ngày lập hóa đơn: " + don.getNgayDat().format(dfNgayGio), fontNormal);
            ngayLap.setAlignment(Element.ALIGN_CENTER);
            document.add(ngayLap);

            Paragraph line = new Paragraph("----------------------------------------------------");
            line.setAlignment(Element.ALIGN_CENTER);
            document.add(line);

            document.add(new Paragraph(" "));

            // Thông tin khách hàng
            document.add(new Paragraph("Thông tin Khách Hàng", fontSub));
            document.add(new Paragraph("Mã KH: " + don.getIdKH(), fontNormal));
            document.add(new Paragraph("Tên KH: " + don.getTenKH(), fontNormal));

            document.add(new Paragraph(" "));

            // Thông tin đặt phòng
            document.add(new Paragraph("Thông tin Đặt Phòng", fontSub));
            document.add(new Paragraph("Khách Sạn: " + don.getTenKS() + " (ID: " + don.getIdKS() + ")", fontNormal));
            document.add(new Paragraph("Phòng: " + don.getTenPhong() + " (ID: " + don.getIdP() + ")", fontNormal));
            document.add(new Paragraph("Số lượng phòng: " + don.getSl(), fontNormal));
            document.add(new Paragraph("Ngày nhận phòng: " + don.getNgayNhan().format(dfNgay), fontNormal));
            document.add(new Paragraph("Ngày trả phòng: " + don.getNgayTra().format(dfNgay), fontNormal));

            document.add(new Paragraph(" "));

            // Thông tin thanh toán
            document.add(new Paragraph("Thông tin Thanh Toán", fontSub));
            document.add(new Paragraph("Tên chủ thẻ: " + tenChuThe, fontNormal));
            document.add(new Paragraph("Loại thẻ: " + loaiThe, fontNormal));
            document.add(new Paragraph("Số thẻ: **** **** **** " + soThe.substring(soThe.length() - 4), fontNormal));
            document.add(new Paragraph("Tổng tiền: " + String.format("%,d", tongtien) + " VNĐ", fontNormal));

            document.close();
            System.out.println(">> Hóa đơn đã được xuất ra file PDF.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

