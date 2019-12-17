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
@WebServlet(urlPatterns = {"/somar"})
public class somaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int p1=Integer.parseInt(request.getParameter("p1"));
        int p2=Integer.parseInt(request.getParameter("p2"));
        int total = p1+p2;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da soma</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>O resultado " + total + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
