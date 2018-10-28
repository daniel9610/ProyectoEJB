/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Video;
import java.lang.String;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import model.Idioma;
import model.IdiomaFacade;
import model.Serie;
import model.SerieFacade;
import model.VideoFacade;

/**
 *
 * @author DanielEsteban
 */
@WebServlet(name = "Videos", urlPatterns = {"/Videos"})
public class Videos extends HttpServlet {
     Date AñoProduccion;
     Date duracion;
    @EJB
    private SerieFacade serieFacade;
    @EJB
    private IdiomaFacade idiomaFacade;

    @EJB
    private VideoFacade videoFacade;
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Videos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Videos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./Videos.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Isan = request.getParameter("Isan");
        String Titulo = request.getParameter("Titulo");
        String Duracion = request.getParameter("duracion");
        String añoProduccion = request.getParameter("AñoProduccion");
//        String cod_idioma = request.getParameter("cod_idioma");
//        String IdSerie = request.getParameter("IdSerie");
        String $valor = request.getParameter("valor");
        int valor;
        Integer Isan2 = null;
//        Integer IdSerie2;
//        Integer cod_idioma2;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat stf = new SimpleDateFormat("HH:mm:ss");

        try {
            valor = Integer.parseInt($valor);
            AñoProduccion = sdf.parse(añoProduccion);
            duracion = stf.parse(Duracion);
            Isan2 = Integer.parseInt(Isan);
        } catch (Exception e) {
            valor = 0;
        }
        if (Isan == null || Isan.isEmpty()) {
            Video p1 = new Video();       
              Video videito= new Video();
            Video p = new Video(Isan2, Titulo, duracion, AñoProduccion, valor, videito.getIdSerie(), videito.getCodIdioma());
            
            videoFacade.create(p);
           
            
        }

        request.getRequestDispatcher("./index.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
