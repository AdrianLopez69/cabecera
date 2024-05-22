package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//Nombre del programador: Adrian Lopez
//Materia: Programacion 2
//fecha: 22/05/2024
//version:1


//vamos a crear la key para enlazarnos al servlet
@WebServlet("/ServletCabe")
public class Servlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        //defino una variable printwrite para que imprima
        PrintWriter out = resp.getWriter();
        String metodo = req.getMethod();
        out.print("<html");
        out.print("<head>");
        out.print("<title></title>");
        out.print("<head>");
        out.print("<body>");
        out.print("<h1>Imprime los cabeceros</h1>");
        out.print("el metodo que se utiliza es "+metodo);
        out.print("<br>");
        String uri= req.getRequestURI();
        out.print("La uri es  "+uri);
        out.print("<br>");
        // Creamos un cabecero tipo lista
        //para organizar
        Enumeration caberos =req.getHeaderNames();
        //necesita un bucle para recorer
        while(caberos.hasMoreElements()){
            //especificamos que va recorrer de 1 en 1
            String nombreCabeceros = (String) caberos.nextElement();
            out.print("<b>"+nombreCabeceros+"</b>");
            out.print(req.getHeader(nombreCabeceros));
            out.print("<br>");
        }
        out.print("</body>");
        out.print("</html>");
    }


}
