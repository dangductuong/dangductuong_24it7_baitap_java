package com.example.ma_hoa_hai;


import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> algorithmBox;
    @FXML private TextArea outputArea;

    private SecretKey aesKey;

    @FXML
    public void initialize() {
        algorithmBox.getItems().addAll("MD5", "SHA-256", "AES");
        algorithmBox.setValue("MD5"); // mặc định

        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            aesKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String algorithm = algorithmBox.getValue();

        if (username.isEmpty() || password.isEmpty()) {
            outputArea.setText("Vui lòng nhập đầy đủ tên và mật khẩu.");
            return;
        }

        try {
            String result = switch (algorithm) {
                case "MD5" -> hash(password, "MD5");
                case "SHA-256" -> hash(password, "SHA-256");
                case "AES" -> encryptAES(password);
                default -> "Thuật toán không hợp lệ!";
            };

            outputArea.setText("Tên: " + username + "\nThuật toán: " + algorithm + "\nMã hóa: " + result);

        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Lỗi khi mã hóa.");
        }
    }

    private String hash(String input, String algorithm) throws Exception {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashed = digest.digest(input.getBytes());
        return bytesToHex(hashed);
    }

    private String encryptAES(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encrypted = cipher.doFinal(input.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hex = new StringBuilder();
        for (byte b : bytes) hex.append(String.format("%02x", b));
        return hex.toString();
    }
}
