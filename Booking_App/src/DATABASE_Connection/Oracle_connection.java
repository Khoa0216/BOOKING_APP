package DATABASE_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Oracle_connection {
    public static Connection getConnection(String user, String password) throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521/booking_pdb";  // Địa chỉ CSDL Booking_pdb
        String driver = "oracle.jdbc.driver.OracleDriver";
        
        try{
            Class.forName(driver);// Đăng ký Driver JDBC đối với Oracle
            
            //kết nói với csdl với user và password được nhập
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver không tìm thấy!", e);
        }
    }
}
