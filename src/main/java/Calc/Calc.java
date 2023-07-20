package Calc;


import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;



@WebServlet("/calc/*")
public class Calc extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            double result;
            System.out.println("--- api called");
            response.setContentType("application/json");

 // calling header methods for preflight
            setAccessControlHeaders(response);
            doOptions(request,response);

 // (Method 1) ----> to read json from request and convert to String using Collectors
            String exp2 = request.getReader().lines().collect(Collectors.joining());
            System.out.println("Got the expression from Frontend => " + exp2);

        Gson gson = new Gson();

        DoubleEvaluator eval = new DoubleEvaluator();

        // USING TYPETOKEN TO PARSE ARRAY OF INPUTMODEL
        ArrayList<InputModel> outputList = new Gson().fromJson(exp2, new TypeToken<ArrayList<InputModel>>() {}.getType());


        //  COUNTING THE LENGTH OF ARRAY
        int count = (int) outputList.stream().count();
        //  COUNTING THE NUMBER OF OPERATORS
        int noOfOperator = count/2;


        //  MY LOGIC - IS AT THE BOTTOM - UNDER COMMENT - JUST FOR REFERENCE


        // ----------- SIR's LOGIC FOR MAIN CALCULATION  -------------------

        float firstOperand = 0;
                    String operation = "";
/* double evaluator*/  String first = "";  // ########### Method 2 - using double evaluator
                    String operator = ""; // ###########

     for(int index =0; index< count; index++){
            if(outputList.get(index).getType().equals("NUMBER")){
                if(firstOperand == 0){
                    firstOperand = Float.parseFloat(outputList.get(index).getValue());
                    first = outputList.get(index).getValue(); // ###########
                    if(index>0 && outputList.get(index-1).getValue().equals("subtract")){
                         firstOperand = -firstOperand;
                         first = "-"+first; // ###########
                     }
                }
                else{
                     firstOperand = evaluate(firstOperand, Float.parseFloat(outputList.get(index).getValue()),operation);
                     operator = getOperator(operation);  // ###########
                    System.out.println(operator);
                    result = eval.evaluate(first + operator + outputList.get(index).getValue()); // ###########
                    first = result+"" ;  // ###########
                    System.out.println("using doubleevaluator "+result);
                  }
            }
          if((outputList.get(index).getType().equals("OPERATOR")) && (firstOperand != 0)){
               operation = outputList.get(index).getValue();
            }

        }

        System.out.println("firstOperand "+ firstOperand);
        response.getWriter().print(firstOperand);

     }

     // This method is used for Double Evaluator  ###############
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



    //for Preflight Request
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    //for Preflight Request
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
    }
}



// ----------- MY LOGIC FOR MAIN CALCULATION  -------------------

/*     for(int i = 1; i<= noOfOperator; i++){
            System.out.println("loop "+ i);

             switch (outputList.get(1).getValue()){

             case "add":
                     InputModel input = new InputModel();
                     result = Integer.parseInt(outputList.get(0).getValue()) + Integer.parseInt(outputList.get(2).getValue());

                     // REMOVING FIRST THREE TERMS
                     outputList.remove(0);
                     outputList.remove(0);
                     outputList.remove(0);
                     // ADDING RESULT IN THE FIRST INDEX
                     input.setType("NUMBER");
                     input.setValue(""+result);
                     outputList.add(0,input);
                    break;

             case "subtract":
                  InputModel input2 = new InputModel();
                    result = Integer.parseInt(outputList.get(0).getValue()) - Integer.parseInt(outputList.get(2).getValue());
                    // REMOVING FIRST THREE TERMS
                     outputList.remove(0);
                     outputList.remove(0);
                     outputList.remove(0);

                 // ADDING RESULT IN THE FIRST INDEX
                     input2.setType("NUMBER");
                     input2.setValue(""+result);
                     outputList.add(0,input2);
                     break;

                 case "multiply":
                     InputModel input3 = new InputModel();
                     result = Integer.parseInt(outputList.get(0).getValue()) * Integer.parseInt(outputList.get(2).getValue());

                     // REMOVING FIRST THREE TERMS
                     outputList.remove(0);
                     outputList.remove(0);
                     outputList.remove(0);

                     // ADDING RESULT IN THE FIRST INDEX
                     input3.setType("NUMBER");
                     input3.setValue(""+result);
                     outputList.add(0,input3);
                     break;

                 case "division":
                     InputModel input4 = new InputModel();
                     result = Integer.parseInt(outputList.get(0).getValue()) / Integer.parseInt(outputList.get(2).getValue());

                     // REMOVING FIRST THREE TERMS
                     outputList.remove(0);
                     outputList.remove(0);
                     outputList.remove(0);

                     // ADDING RESULT IN THE FIRST INDEX
                     input4.setType("NUMBER");
                     input4.setValue(""+result);
                     outputList.add(0,input4);
                     break;

             }


        }

        System.out.println("Final result is  "+outputList.get(0).getValue());

        // MY LOGIC RESONSE - outputList.get(0).getValue()
      response.getWriter().print(outputList.get(0).getValue());


   */

