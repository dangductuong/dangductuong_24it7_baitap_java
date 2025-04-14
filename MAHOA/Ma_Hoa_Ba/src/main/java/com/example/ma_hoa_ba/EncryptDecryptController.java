package com.example.ma_hoa_ba;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptDecryptController {

    @FXML
    private TextArea inputArea, encryptedArea, decryptedArea;

    private static final String AES = "AES";
    private SecretKey secretKey;

    public EncryptDecryptController() {
        try {
            KeyGenerator generator = KeyGenerator.getInstance(AES);
            generator.init(128);
            secretKey = generator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onEncrypt() {
        String input = inputArea.getText();
        new Thread(() -> {
            try {
                Cipher cipher = Cipher.getInstance(AES);
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(input.getBytes());
                String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

                javafx.application.Platform.runLater(() ->
                        encryptedArea.setText(encryptedText)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void onDecrypt() {
        String encryptedText = encryptedArea.getText();
        new Thread(() -> {
            try {
                Cipher cipher = Cipher.getInstance(AES);
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
                byte[] decryptedBytes = cipher.doFinal(decodedBytes);
                String decryptedText = new String(decryptedBytes);

                javafx.application.Platform.runLater(() ->
                        decryptedArea.setText(decryptedText)
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}