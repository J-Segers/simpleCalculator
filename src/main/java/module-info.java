module nl.atjays.practice.simplecalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.atjays.practice.simplecalculator to javafx.fxml;
    exports nl.atjays.practice.simplecalculator;
}