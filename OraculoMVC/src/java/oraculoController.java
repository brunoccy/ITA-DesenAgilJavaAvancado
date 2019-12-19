/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mariana
 */
@WebServlet("/oraculoController")
public class oraculoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipoProduto = request.getParameter("produto");
        Oraculo o = new Oraculo();
        List<String> produtos = o.melhoresProdutos(tipoProduto);
        request.setAttribute("produtos", produtos);
        request.getRequestDispatcher("resposta.jsp").forward(request, response);
        
    }


}
