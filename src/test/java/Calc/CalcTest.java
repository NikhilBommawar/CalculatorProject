package Calc;


    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;

    import org.apache.poi.ss.usermodel.Row;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.junit.jupiter.api.Test;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.PrintWriter;
    import java.io.StringWriter;
    import java.util.Iterator;


    import static junit.framework.Assert.*;
    import static org.mockito.Mockito.*;


public class CalcTest {

 @Test
    public void testDoPost1() throws Exception {

        // input = 5+10
       String input = "[{'type':'NUMBER','value':'5'},{'type':'OPERATOR','value':'add'},{'type':'NUMBER','value':'10'}]";

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("input")).thenReturn(input);  // stub

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);  // stub

        new Calc().doPost(request, response);

        assertTrue(stringWriter.toString().contains("15"));

    }

    @Test
    public void testDoPost2() throws Exception {

        // input = -20+10
        String input = "[{'type':'OPERATOR','value':'subtract'},{'type':'NUMBER','value':'20'},{'type':'OPERATOR','value':'add'},{'type':'NUMBER','value':'10'}]";

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("input")).thenReturn(input);  // stub

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);  // stub

        new Calc().doPost(request, response);

        assertEquals("-10.0",stringWriter.toString());

    }

    @Test
    public void testDoPost3() throws Exception {

        // input = +-20-+10 = -10
        String input = "[{'type':'OPERATOR','value':'add'},{'type':'OPERATOR','value':'subtract'},{'type':'NUMBER','value':'20'},{'type':'OPERATOR','value':'subtract'},{'type':'OPERATOR','value':'add'},{'type':'NUMBER','value':'10'}]";

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("input")).thenReturn(input);  // stub

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);  // stub

        new Calc().doPost(request, response);

        assertEquals("-10.0",stringWriter.toString());


    }

    @Test
    public void testDoPost4() throws Exception {

        // input = 10+50*3/180-1 = 0

        String input = "[{'type':'NUMBER','value':'10'},{'type':'OPERATOR','value':'add'}," +
                      " {'type':'NUMBER','value':'50'},{'type':'OPERATOR','value':'multiply'}," +
                       " {'type':'NUMBER','value':'3'}," +
                        "{'type':'OPERATOR','value':'division'}," +
                        " {'type':'NUMBER','value':'180'}" +
                ",{'type':'OPERATOR','value':'subtract'}," +
                        "{'type':'NUMBER','value':'1'}]";

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("input")).thenReturn(input);  // stub

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);  // stub

        new Calc().doPost(request, response);

        assertEquals("0.0",stringWriter.toString());

    }


    @Test
    public void testDoPost5() throws Exception {
     try{
         int count = 0;
         String path = "C:\\Users\\Nikhil\\OneDrive\\Desktop\\Calc input.xlsx";
         // Reading file from local directory
         FileInputStream file = new FileInputStream(new File(path));

         // Create Workbook instance holding reference to
         // .xlsx file
         XSSFWorkbook workbook = new XSSFWorkbook(file);
         XSSFSheet sheet = workbook.getSheetAt(0);
         // Iterate through each rows one by one
         Iterator<Row> rowIterator = sheet.iterator();
         System.out.println("Printing cell values ........");

        while (rowIterator.hasNext()) {

             Row row = rowIterator.next();

             System.out.println("input " + row.getCell(0));
             System.out.println("expected " + row.getCell(1));

             HttpServletRequest request = mock(HttpServletRequest.class);
             HttpServletResponse response = mock(HttpServletResponse.class);

             when(request.getParameter("input")).thenReturn(String.valueOf(row.getCell(0)));  // stub

             StringWriter stringWriter = new StringWriter();
             PrintWriter writer = new PrintWriter(stringWriter);

             when(response.getWriter()).thenReturn(writer);  // stub

             new Calc().doPost(request, response);

             assertEquals(String.valueOf(row.getCell(1)),stringWriter.toString());

             count += 1;

             if(count>3){
                 break;
             }

         }

       }
     catch (Exception e){
         System.out.println(e);
     }
    }


    @Test
    public void testDoPost6() throws Exception {
        // input = 10+ nikhil != 10
        String input = "[{'type':'NUMBER','value':'6'},{'type':'OPERATOR','value':'add'}," +
                " {'type':'NUMBER','value':'nikhil'}]";

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("input")).thenReturn(input);  // stub

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);  // stub


        new Calc().doPost(request, response);

        assertFalse(!stringWriter.toString().equals("number format exception") );

     }
  }
