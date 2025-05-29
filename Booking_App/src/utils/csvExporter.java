package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class csvExporter {
    public static void exportToCSV(JTable table, String pathDir, String name) throws IOException {
        TableModel model = table.getModel();
        File outFile = new File(pathDir, name);
        // nếu chưa có thư mục thì tạo
        if (!outFile.getParentFile().exists()) {
            outFile.getParentFile().mkdirs();
        }
        System.out.println("Luu tai" + outFile.getAbsolutePath());
        try (OutputStreamWriter osw = new OutputStreamWriter(
                 new FileOutputStream(outFile), StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(osw);
             PrintWriter pw = new PrintWriter(bw)) {

            // Ghi BOM để Excel tự nhận UTF-8
            pw.write('\uFEFF');

            // Header
            for (int c = 0; c < model.getColumnCount(); c++) {
                pw.print(model.getColumnName(c));
                if (c < model.getColumnCount() - 1) pw.print(",");
            }
            pw.println();

            // Data
            for (int r = 0; r < model.getRowCount(); r++) {
                for (int c = 0; c < model.getColumnCount(); c++) {
                    String cell = String.valueOf(model.getValueAt(r, c));
                    // escape dấu phẩy nếu có
                    cell = cell.replace("\"", "\"\"");
                    pw.print("\"" + cell + "\"");
                    if (c < model.getColumnCount() - 1) pw.print(",");
                }
                pw.println();
            }
        }
    }
}
