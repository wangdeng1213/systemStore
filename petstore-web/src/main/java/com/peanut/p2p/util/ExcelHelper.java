package com.peanut.p2p.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 * Created by my on 2015/5/8.
 */
public class ExcelHelper {

    /**
     * 导出Excel文档工具类
     *
     * @author my
     * @date
     */

    public static void toExcel(List<Map<String, Object>> list, String[] keys, String columnNames[], String fileName, HttpServletResponse response) {
        HttpServletResponse re = response;
        re.setCharacterEncoding("UTF-8");
        re.setContentType("application/vnd.ms-excel");
        String extName = ".xls";
        String contentDisposition = null;
        try {
            contentDisposition = "attachment; filename=\"" + new String((fileName).getBytes(), "ISO8859-1") + extName + "\"";
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        re.setHeader("Content-Disposition", contentDisposition);
        try {
            OutputStream out = re.getOutputStream();
            //ExportUtils.toExcel(out, list);
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(getInputStream(list, keys, columnNames));
                bos = new BufferedOutputStream(out);

                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff))) {
                    bos.write(buff, 0, bytesRead);
                    bos.flush();
                }
                //bos.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
                if (out != null)
                    out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InputStream getInputStream(List<Map<String, Object>> list, String[] keys, String columnNames[]) {
        Workbook wb = createWorkBook(list, keys, columnNames);
        // 捕获内存缓冲区的数据，转换成字节数组
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        InputStream is = null;
        try {
            wb.write(os);
            // 获取内存缓冲中的数据
            byte[] content = os.toByteArray();
            is = new ByteArrayInputStream(content);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 创建excel文档，
     *
     * @param list        数据
     * @param keys        list中map的key数组集合
     * @param columnNames excel的列名
     */
    public static Workbook createWorkBook(List<Map<String, Object>> list, String[] keys, String columnNames[]) {
        // 创建excel工作簿
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = null;
        // 创建两种单元格格式
        // 创建第一个sheet（页），并命名
        String sheetName = list.get(0).get("sheetName").toString();
        Row row = null;
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        //删除第一条数据
        list.remove(0);
        int n = 0, k = 0;
        Cell cell = null;
        //设置每行每列的值
        for (short i = 0; i < list.size(); i++) {
            Map m = list.get(i);
            if (i % 3 == 0) {
                k = 0;
                sheet = wb.createSheet(sheetName + (++n));
                for (int z = 0; z < keys.length; z++) {
                    sheet.setColumnWidth((short) z, (short) (35.7 * 150));
                }
            }
            row = sheet.createRow(k++);
            if ((k - 1) == 0)// 生成表头
            {
                for (int t = 0; t < columnNames.length; t++) {
                    cell = row.createCell(t);
                    cell.setCellValue(columnNames[t]);
                    cell.setCellStyle(getContentCellStyle(wb, true));
                }
                row = sheet.createRow(k++);
            }
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 在row行上创建一个方格

            for (short j = 0; j < keys.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(list.get(i).get(keys[j]) == null ? " " : list.get(i).get(keys[j]).toString());
            }
        }
        cell.setCellStyle(getContentCellStyle(wb, false));
        return wb;
    }

    /**
     * @param wb
     * @param =false设置边框加粗,为true设置字体为微软雅黑并加粗,设置边框加粗。
     * @param ；
     * @return
     */
    private static CellStyle getContentCellStyle(Workbook wb, boolean headerFlag) {
        CellStyle cellStyle = wb.createCellStyle();
        Font f = wb.createFont();
        if (headerFlag) {
            // 创建第一种字体样式（用于列名）
            f.setFontHeightInPoints((short) 10);
            f.setColor(IndexedColors.BLACK.getIndex());
            f.setBoldweight(Font.BOLDWEIGHT_BOLD);
        } else {
            f.setFontHeightInPoints((short) 10);
            f.setColor(IndexedColors.BLACK.getIndex());
        }
        // 设置第一种单元格的样式（用于列名）
        cellStyle.setFont(f);
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        return cellStyle;
    }
}
