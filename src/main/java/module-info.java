module com.example.l_m_s {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.l_m_s to javafx.fxml;
    exports com.example.l_m_s;
}