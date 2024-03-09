package com.example.qualitycontrolsystem.login.service.change_service;

import com.example.qualitycontrolsystem.login.config.message.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ChangeExcelLayoutService {
    public ResponseObject changeExcelLayout(MultipartFile file) {
        ResponseObject response = new ResponseObject(); // 实例化 ResponseObject 对象

        try (InputStream is = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(is);

            for (Sheet sheet : workbook) {

                // Set the width of columns
                sheet.setColumnWidth(0, (int) (16.5 * 256));
                sheet.setColumnWidth(1, (int) (66 * 256));
                sheet.setColumnWidth(2, (int) (5.5 * 256));

                // Adjust row height and content auto line feed
//                for (Row row : sheet) {
//                    row.setHeightInPoints((float) 15.6); // All rows have a height of 15.6
//                    for (Cell cell : row) {
//                        CellStyle style = workbook.createCellStyle();
//                        style.setWrapText(true); // All content auto line feed
//                        cell.setCellStyle(style);
//                    }
//                }
            }

            String fileName = "D:\\质控反馈单.xlsx"; // 文件保存路径
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

            // If everything goes well
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("文件处理成功并已保存至：" + fileName);
        } catch (Exception e) {
            // If something goes wrong
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("处理文件时出错：" + e.getMessage());
        }
        return response;
    }
}
