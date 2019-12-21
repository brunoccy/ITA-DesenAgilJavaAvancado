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

@WebServlet(urlPatterns = {"/tradutorController"})
public class tradutorController extends HttpServlet {



   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String palavraEscrita = request.getParameter("nomePalavra");
      tradutorJava tj = new tradutorJava();
      String traduzida = tj.traduzirPalavra(palavraEscrita);
      request.setAttribute("palavraTraduzida", traduzida);
      request.setAttribute("nomePalavra", palavraEscrita);
      request.getRequestDispatcher("tradutorJsp.jsp").forward(request, response);
    }
}
