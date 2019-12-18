/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mariana
 */
@WebServlet(urlPatterns = {"/temperaturaServlet"})
public class temperaturaServlet extends HttpServlet {

    @Override
    @SuppressWarnings("empty-statement")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p1= Integer.parseInt(request.getParameter("p1"));
        int convertido;
        String a = request.getParameter("temperaturas");
        if(a.equals("Fahrenheit")){
            convertido = ((p1 * 9) / 5) + 32;
        }else{
            convertido = ((p1 - 32) * 5) / 9;
         };
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet temperaturaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>A temperatura em " + a + " é "+convertido+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
