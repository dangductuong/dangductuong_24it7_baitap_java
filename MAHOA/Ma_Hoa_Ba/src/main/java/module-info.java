module com.example.ma_hoa_ba {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ma_hoa_ba to javafx.fxml;
    exports com.example.ma_hoa_ba;
}