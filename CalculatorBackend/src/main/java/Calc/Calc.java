package Calc;


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
            int result;
            System.out.println("--- api called");
            response.setContentType("application/json");

 // calling header methods for preflight
            setAccessControlHeaders(response);
            doOptions(request,response);

 // (Method 1) ----> to read json from request and conver to String using Collectors
            String exp2 = request.getReader().lines().collect(Collectors.joining());
            System.out.println("Got the expression from Frontend => " + exp2);

        Gson gson = new Gson();

//        ArrayList<InputModel> inputList = new ArrayList<InputModel>();

//        inputList = gson.fromJson(exp2, ArrayList.class);


        ArrayList<InputModel> outputList = new Gson().fromJson(exp2, new TypeToken<ArrayList<InputModel>>() {}.getType());


        //  COUNTING THE LENGTH OF ARRAY
        int count = (int) outputList.stream().count();
        //  COUNTING THE LENGTH OF ARRAY
        int noOfOperator = count/2;

        // SIR's LOGIC FOR MAIN CALCULATION
      int firstOperand;
      int secondOperand;
      int index = 0;
      int j = 0;


        firstOperand = Integer.parseInt(outputList.get(0).getValue());

       while((index + 3) < count){

            System.out.println("j " + j);

            secondOperand = Integer.parseInt(outputList.get(j+2).getValue());

            switch (outputList.get(j+1).getValue()){

                case "add":
                    firstOperand = firstOperand + secondOperand;
                    break;

                case "subtract":
                    firstOperand = firstOperand - secondOperand;
                    break;

                case "multiply":
                    firstOperand = firstOperand * secondOperand;
                    break;

                case "division":
                    firstOperand = firstOperand / secondOperand;
                    break;

                default :
                    break;

            }

            index += 1;
            j+=2;
        }

        System.out.println("firstOperand "+ firstOperand);



        // MY LOGIC FOR MAIN CALCULATION
      for(int i = 1; i<= noOfOperator; i++){
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
        response.getWriter().print(outputList.get(0).getValue());

    }

    //for Preflight
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    //for Preflight
    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "POST");
    }
}
