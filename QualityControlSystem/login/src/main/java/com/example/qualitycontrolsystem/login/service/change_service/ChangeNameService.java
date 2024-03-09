package com.example.qualitycontrolsystem.login.service.change_service;

import com.example.qualitycontrolsystem.login.config.message.ResponseObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Service
public class ChangeNameService {

    public ResponseObject changeName(MultipartFile file) {
        ResponseObject response = new ResponseObject();
        try {
            InputStream fis = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0); // assuming you're interested in the first sheet
            Row headerRow = sheet.getRow(0);
            int columnIndex = -1;

            // find the column index for "科室"
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equals("科室")) {
                    columnIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (columnIndex != -1) {
                for (Row row : sheet) {
                    Cell cell = row.getCell(columnIndex);
                    if (cell != null) {
                        String cellValue = cell.getStringCellValue();
                        if (cellValue.contains("心血")) { // if the cell contains "关键字"
                            cell.setCellValue("心血管内科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("心内科")) { // if the cell contains "关键字"
                            cell.setCellValue("心血管内科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("消化")) { // if the cell contains "关键字"
                            cell.setCellValue("消化内科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("呼吸")) { // if the cell contains "关键字"
                            cell.setCellValue("呼吸与危重症医学科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("肾")) { // if the cell contains "关键字"
                            cell.setCellValue("肾病内科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("神内")) { // if the cell contains "关键字"
                            cell.setCellValue("神经内科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("全")) { // if the cell contains "关键字"
                            cell.setCellValue("全科医学科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("I")) { // if the cell contains "关键字"
                            cell.setCellValue("重症医学科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("老")) { // if the cell contains "关键字"
                            cell.setCellValue("老年医学科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("血液")) { // if the cell contains "关键字"
                            cell.setCellValue("血液风湿免疫肿瘤科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("风湿")) { // if the cell contains "关键字"
                            cell.setCellValue("血液风湿免疫肿瘤科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("肿瘤")) { // if the cell contains "关键字"
                            cell.setCellValue("血液风湿免疫肿瘤科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("感染")) { // if the cell contains "关键字"
                            cell.setCellValue("感染性疾病科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普外科")) { // if the cell contains "关键字"
                            cell.setCellValue("普外儿外肛肠科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普外儿外")) { // if the cell contains "关键字"
                            cell.setCellValue("普外儿外肛肠科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普外")) { // if the cell contains "关键字"
                            cell.setCellValue("普外儿外肛肠科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("胸")) { // if the cell contains "关键字"
                            cell.setCellValue("胸外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("肝胆")) { // if the cell contains "关键字"
                            cell.setCellValue("肝胆胰外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("神外")) { // if the cell contains "关键字"
                            cell.setCellValue("神经外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("尿")) { // if the cell contains "关键字"
                            cell.setCellValue("泌尿外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("骨")) { // if the cell contains "关键字"
                            cell.setCellValue("骨科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("骨    科")) { // if the cell contains "关键字"
                            cell.setCellValue("骨科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("乳腺")) { // if the cell contains "关键字"
                            cell.setCellValue("乳腺甲状腺外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("烧")) { // if the cell contains "关键字"
                            cell.setCellValue("烧伤整形美容皮肤外科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("眼")) { // if the cell contains "关键字"
                            cell.setCellValue("眼耳鼻喉科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("耳")) { // if the cell contains "关键字"
                            cell.setCellValue("眼耳鼻喉科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("口")) { // if the cell contains "关键字"
                            cell.setCellValue("口腔科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("麻")) { // if the cell contains "关键字"
                            cell.setCellValue("麻醉科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("痛")) { // if the cell contains "关键字"
                            cell.setCellValue("疼痛科"); // replace the cell content with "新的内容"
                        }
                        if (!cellValue.equals("妇产科合计") && cellValue.contains("妇")) {
                            cell.setCellValue("妇科");
                        }
                        if (cellValue.contains("产 二 科")) { // if the cell contains "关键字"
                            cell.setCellValue("产二科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("产 一 科")) { // if the cell contains "关键字"
                            cell.setCellValue("产一科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("新")) { // if the cell contains "关键字"
                            cell.setCellValue("新生儿科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普儿")) { // if the cell contains "关键字"
                            cell.setCellValue("儿科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普 儿 科")) { // if the cell contains "关键字"
                            cell.setCellValue("儿科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("普通儿科")) { // if the cell contains "关键字"
                            cell.setCellValue("儿科"); // replace the cell content with "新的内容"
                        }
                        if (cellValue.contains("内分泌")) { // if the cell contains "关键字"
                            cell.setCellValue("内分泌科"); // replace the cell content with "新的内容"
                        }

                    }
                }
            }

            fis.close();

            // Generate a unique timestamp to append to the file name
            long timestamp = System.currentTimeMillis();
            // Use the timestamp to create a unique file name
            String filename = "D:\\重命名" + timestamp + ".xlsx";
            FileOutputStream fos = new FileOutputStream(new File(filename));
            workbook.write(fos);
            fos.close();

            // If everything goes well
            response.setStatusCode(200);
            response.setMessage("文件处理成功并已保存至：" + filename);
        } catch (Exception e) {
            // If something goes wrong
            response.setStatusCode(500);
            response.setMessage("处理文件时出错：" + e.getMessage());
        }
        return response;
    }
}



