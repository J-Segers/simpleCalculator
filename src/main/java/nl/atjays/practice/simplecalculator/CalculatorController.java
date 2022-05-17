package nl.atjays.practice.simplecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {

    private float result = 0;
    private Long inputNumber = 0L;
    private String currentCalculation = "";
    private String nextCalculation = "";

    @FXML
    private Label resultLabel;

    @FXML
    private Label inputLabel;

    @FXML
    protected void onOneButtonClick() {
        addAndSetInput(1);
    }

    @FXML
    protected void onTwoButtonClick() {
        addAndSetInput(2);
    }

    @FXML
    protected void onThreeButtonClick() {
        addAndSetInput(3);
    }

    @FXML
    protected void onFourButtonClick() {
        addAndSetInput(4);
    }

    @FXML
    protected void onFiveButtonClick() {
        addAndSetInput(5);
    }

    @FXML
    protected void onSixButtonClick() {
        addAndSetInput(6);
    }

    @FXML
    protected void onSevenButtonClick() {
        addAndSetInput(7);
    }

    @FXML
    protected void onEightButtonClick() {
        addAndSetInput(8);
    }

    @FXML
    protected void onNineButtonClick() {
        addAndSetInput(9);
    }

    @FXML
    protected void onZeroButtonClick() {
        addAndSetInput(0);
    }

    @FXML
    protected void onCButtonClick() {
        currentCalculation = "";
        nextCalculation = "";

        inputNumber = 0L;
        result = 0L;

        inputLabel.setText("0");
        resultLabel.setText("0");
    }

    @FXML
    protected void onCEButtonClick() {
        inputLabel.setText("0");

        inputNumber = 0L;
    }


    @FXML
    protected void onResultButtonClick() {
        nextCalculation = "";

        makeCalculation();

        inputNumber = 0L;
    }

    @FXML
    protected void onPlusButtonClick() {
        defineCalculation("addition");

        makeCalculation();
    }



    @FXML
    protected void onMinButtonClick() {
        defineCalculation("subtraction");

        makeCalculation();
    }

    @FXML
    protected void onMultiplyButtonClick() {
        defineCalculation("multiplication");

        makeCalculation();
    }

    @FXML
    protected void onDivideButtonClick() {
        defineCalculation("division");

        makeCalculation();
    }

    private Long addToInput(int number) {
        Long returnNumber = this.inputNumber;
        if(returnNumber == 0) {
            return (long) number;
        }

        returnNumber *= 10;
        returnNumber += number;
        return returnNumber;
    }

    private void add() {
        result += inputNumber;
    }

    private void subtract() {
        result -= inputNumber;
    }

    private void multiply() {
        result *= inputNumber;
    }

    private void divide() {
        result /= inputNumber;
    }

    private void makeCalculation() {
        switch (currentCalculation) {
            case "addition" -> add();
            case "subtraction" -> subtract();
            case "multiplication" -> multiply();
            case "division" -> divide();
            default -> {
                if (result != 0 && currentCalculation.equals("") && inputNumber != 0) {
                    result = inputNumber;
                }

                if (result == 0 && inputNumber != 0) {
                    result = inputNumber;
                }
            }
        }

        outputResult();
    }

    private void outputResult() {
        if(result % 1 != 0.0D) {
            resultLabel.setText("" + result);
        } else {
            resultLabel.setText("" + (int)result);
        }

        inputNumber = 0L;
        inputLabel.setText("" + inputNumber);
        currentCalculation = nextCalculation;
    }

    private void defineCalculation(String calculationType) {
        nextCalculation = calculationType;
    }

    private void addAndSetInput(int number) {
        inputNumber = addToInput(number);
        inputLabel.setText("" + inputNumber);
    }

}