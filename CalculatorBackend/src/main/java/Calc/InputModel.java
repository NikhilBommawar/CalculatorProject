package Calc;

public class InputModel {

    int Operand[];
    String operation;

    public int[] getOperand() {
        return Operand;
    }

    public void setOperand(int[] operand) {
        Operand = operand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}