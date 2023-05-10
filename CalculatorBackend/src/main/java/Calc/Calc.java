package Calc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;


@WebServlet("/calc/*")
public class Calc extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        setAccessControlHeaders(response);
//        doOptions(request,response);
//        response.addHeader("Access-Control-Allow-Origin", "*");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            System.out.println("--- api called");
        response.setContentType("application/json");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setStatus(200);

            setAccessControlHeaders(response);
            doOptions(request,response);

   // (Method 1) ----> to read json from request and conver to String using Collectors
            String exp2 = request.getReader().lines().collect(Collectors.joining());
            System.out.println("Got the expression from Frontend => " + exp2);

 // (Method 2)  ----> reading json object from request using BufferedReader

    // using DoubleEvaluator class of Javaluator package to evaluate given expression
             DoubleEvaluator eval = new DoubleEvaluator();
             Double result = eval.evaluate(exp2);
             System.out.println(result);

            response.getWriter().print(result);

    }

    //for Preflight
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        resp.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS");
    }
}
