package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    // Khi chuỗi theo ISO: "2025-05-30"
    public static LocalDate fromIso(String dateStr) {
        return LocalDate.parse(dateStr);
    }

    // Khi chuỗi theo dd/MM/yyyy, ví dụ "30/05/2025"
    public static LocalDate fromCustom(String dateStr) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, fmt);
    }

    public static void main(String[] args) {
        try {
            LocalDate d1 = fromIso("2025-05-30");
            LocalDate d2 = fromCustom("30/05/2025");
            System.out.println(d1); // 2025-05-30
            System.out.println(d2); // 2025-05-30
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }
}
