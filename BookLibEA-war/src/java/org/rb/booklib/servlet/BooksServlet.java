package org.rb.booklib.servlet;

import enitity.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.IBooksBeanLocal;

/**
 *
 * @author raitis
 */
@WebServlet(name = "BooksServlet", urlPatterns = {"/lib","/addbook"})
public class BooksServlet extends HttpServlet {

    @EJB
    IBooksBeanLocal booksEjb;

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
       
        String path = request.getServletPath();
        if(path.equals("/lib")){
            List<Book> books = booksEjb.findAll();
            request.setAttribute("books", books);
            request.getRequestDispatcher("WEB-INF/view/books.jsp").forward(request, response);
            return;        
        }
        if(path.equals("/addbook")){
            Book book = new Book("", "", 0);
            request.setAttribute("book", book);
            request.getRequestDispatcher("WEB-INF/view/addbook.jsp").forward(request, response);
            return;        
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
       
         String path = request.getServletPath();
        if(path.equals("/lib")){
             // Book book = (Book) request.getAttribute("book");
             Book book = new Book();
             book.setTitle(request.getParameter("title"));
              book.setAuthor(request.getParameter("author"));
               book.setPages(Integer.parseInt(request.getParameter("pages")));
             if(book!=null){
             booksEjb.create(book);
             }
             response.sendRedirect("lib");
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
