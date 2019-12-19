
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/contadorServlet"})
public class contadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request
        if(request.getAttribute("contador")== null){
            request.setAttribute("contador", new contadorjava("request"));
        }
        ((contadorjava)request.getAttribute("contadot")).contar();
        //session
        if(request.getSession().getAttribute("contador")== null){
            request.getSession().setAttribute("contador", new contadorjava("session"));
        }
        ((contadorjava)request.getSession().getAttribute("contadot")).contar();
        //aplication
        if(getServletContext().getAttribute("contador")== null){
            getServletContext().setAttribute("contador", new contadorjava("aplication"));
        }
        ((contadorjava)getServletContext().getAttribute("contadot")).contar();
        
        PrintWriter pw = response.getWriter();
        pw.append("<html>");
        pw.append("<h1>"+request.getAttribute("contador")+" </h1>");
        pw.append("<h1>"+request.getSession().getAttribute("contador")+" </h1>");
        pw.append("<h1>"+getServletContext().getAttribute("contador")+" </h1>");
        pw.append("</html>");
      
    }
}
