package CalcUtils;

public class CalcUtils {

    private String getOperator(String operation) {
        String operator = "";
        switch (operation) {

            case "add":
                operator = "+";  // not used secondOperand variable
                break;

            case "subtract":
                operator = "-";
                break;

            case "multiply":
                operator = "*";
                break;

            case "division":
                operator = "/";
                break;

        }
        return operator;
    }


    // SWITCH CASE TO DECIDE THE OPERATION TO BE PERFORMED
    public float evaluate(float firstOperand,float secondOperand,String operation){

        switch (operation){

            case "add":
                firstOperand = doAddition(firstOperand,secondOperand);  // not used secondOperand variable
                break;

            case "subtract":
                firstOperand = doSubtraction(firstOperand,secondOperand);  // not used secondOperand variable
                break;

            case "multiply":
                firstOperand = doMultiplication(firstOperand,secondOperand);
                break;

            case "division":
                firstOperand =  doDivision(firstOperand,secondOperand);
                break;

            default :
                break;

        }
        return firstOperand;
    }


    // METHODS TO PERFORM OPERATIONS
    private static float doAddition(float firstNo,float secondNo){
        return firstNo + secondNo;
    }

    private static float doSubtraction(float firstNo,float secondNo){
        return firstNo - secondNo;
    }

    private static float doMultiplication(float firstNo,float secondNo){
        return firstNo * secondNo;
    }
    private static float doDivision(float firstNo,float secondNo){
        return firstNo / secondNo;
    }


}
