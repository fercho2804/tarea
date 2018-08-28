/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.educlick.examen1.CONTROLLER;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fercho
 */
@WebServlet(name = "crearpdf", urlPatterns = {"/crearpdf"})
public class crearpdf extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("application / pdf; charset=UTF-8");
        try  {
            /* TODO output your page here. You may use following sample code. */
            String letra = request.getServletContext().getRealPath("") + "/Font/Precious.ttf";
            BaseFont bas = BaseFont.createFont(letra,BaseFont.CP1252,BaseFont.EMBEDDED);
            Font obj = new Font(bas,15);
            Document doc = new Document(PageSize.LETTER,50,10,10,20);
            PdfWriter writer = PdfWriter.getInstance(doc, response.getOutputStream());
            doc.open();
            PdfPTable container = new PdfPTable(3);
            PdfPCell cell = new PdfPCell(new Paragraph ("hola",obj));
            container.addCell(new Paragraph ("hjf"));
            container.addCell(cell);
            container.addCell(cell);
            doc.add(container);
            Paragraph prueba = new Paragraph("hola de nuevo este soy yo",obj);
            doc.add(prueba);
            doc.close();
        }
        catch (DocumentException ex) {Logger.getLogger(crearpdf.class.getName()).log(Level.SEVERE, null, ex);}
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(crearpdf.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(crearpdf.class.getName()).log(Level.SEVERE, null, ex);
        }
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
