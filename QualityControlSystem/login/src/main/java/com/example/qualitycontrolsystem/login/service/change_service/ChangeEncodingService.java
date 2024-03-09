package com.example.qualitycontrolsystem.login.service.change_service;

import com.example.qualitycontrolsystem.login.config.message.ResponseObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class ChangeEncodingService {
    public ResponseObject changeEncoding(MultipartFile file) {
        ResponseObject response = new ResponseObject();
        try {
            // 将 MultipartFile 转换为 File
            File convertedFile = new File(file.getOriginalFilename());
            file.transferTo(convertedFile);

            // 使用 Apache POI 读取 Excel 文件内容
            Workbook workbook = new XSSFWorkbook(new FileInputStream(convertedFile));
            Sheet sheet = workbook.getSheetAt(0); // 假设你关心的是第一个工作表

            // 处理 Excel 文件内容，执行编码转换的逻辑
            String convertedFilePath = processExcel(sheet);

            // 关闭 Workbook
            workbook.close();

            // 删除临时文件
            convertedFile.delete();

            // 如果一切顺利
            response.setStatusCode(200);
            response.setMessage("文件处理成功，并已转换为 UTF-8 编码保存至：" + convertedFilePath);
        } catch (Exception e) {
            // 如果出现错误
            response.setStatusCode(500);
            response.setMessage("处理文件时出错：" + e.getMessage());
        }
        return response;
    }

    private String processExcel(Sheet sheet) {
        // 处理 Excel 文件内容的逻辑
        // 可以使用 sheet.getRow(rowNum) 和 row.getCell(cellNum) 方法来获取单元格内容，并进行相应的处理
        // ...

        // 返回转换后的文件路径
        return "C:\\\\Users\\\\ASUS\\\\Downloads\\\\重新编码\" + timestamp + \".xlsx";
    }
}

