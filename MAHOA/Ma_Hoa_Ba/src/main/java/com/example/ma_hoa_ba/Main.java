package com.example.ma_hoa_ba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EncryptDecryptApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mã hóa và Giải mã (Đa luồng)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}