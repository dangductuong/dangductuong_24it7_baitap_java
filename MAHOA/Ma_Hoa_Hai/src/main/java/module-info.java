module com.example.ma_hoa_hai {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ma_hoa_hai to javafx.fxml;
    exports com.example.ma_hoa_hai;
}