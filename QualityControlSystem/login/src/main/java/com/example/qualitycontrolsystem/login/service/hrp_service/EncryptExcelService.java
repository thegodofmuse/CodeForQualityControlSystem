package com.example.qualitycontrolsystem.login.service.hrp_service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
@Service
public class EncryptExcelService {
    private static final String[] PASSWORDS = {"12345", "123456", "1234567"};

    public void encryptExcelFile(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        int rowCount = 0;
        for (Row row : sheet) {
            if (rowCount < PASSWORDS.length) {
                for (Cell cell : row) {
                    String originalContent = dataFormatter.formatCellValue(cell);
                    String encryptedContent = encrypt(originalContent, PASSWORDS[rowCount]);
                    cell.setCellValue(encryptedContent);
                }
            }
            rowCount++;
        }
        fis.close();

        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\ASUS\\Downloads\\encryptedFile.xlsx"));
        workbook.write(fos);
        fos.close();
        workbook.close();
    }


    private String encrypt(String content, String password) throws Exception {
        Key key = new SecretKeySpec(password.getBytes(StandardCharsets.UTF_8), "RC4");
        Cipher cipher = Cipher.getInstance("RC4");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
