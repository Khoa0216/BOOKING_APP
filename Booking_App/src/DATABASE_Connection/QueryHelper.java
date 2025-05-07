package DATABASE_Connection;
import java.sql.*;

public class QueryHelper {
    public static ResultSet executeSelect(String sql, Object... params) {
        try {
            Connection conn = Oracle_connection.getConnection("nguoidung_user", "12345678");
            PreparedStatement ps = conn.prepareStatement(sql);
            
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            return ps.executeQuery();  // Bạn cần tự đóng ResultSet và Connection sau khi dùng
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
