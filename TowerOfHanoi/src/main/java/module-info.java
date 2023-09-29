module com.example.towerofhanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.towerofhanoi to javafx.fxml;
    exports com.example.towerofhanoi;
}