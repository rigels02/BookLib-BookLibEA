package service;

import dao.BookFacadeLocal;
import enitity.Book;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author raitis
 */
@Stateless(name = "BookBean")
public class BooksBean implements IBooksBeanRemote, IBooksBeanLocal,Serializable {

    @EJB
    BookFacadeLocal bookFacade;
    
    @Override
    public List<Book> findAll() {
        return bookFacade.findAll();
    }

    @Override
    public Book findById(long id) {
       return bookFacade.find(id);
    }

    @Override
    public void create(Book book){
      bookFacade.create(book);
    }
    
    @Override
    public void edit(Book book) {
        bookFacade.edit(book);
    }

    @Override
    public void remove(Book book) {
        bookFacade.remove(book);
    }

    @Override
    public List<BookDTO> r_findAll() {
        List<BookDTO> listOut = new ArrayList<>();
        List<Book> books = bookFacade.findAll();
        for (Book book : books) {
            listOut.add(Helper.getBook(book));
        }
       return listOut; 
    }

    @Override
    public BookDTO r_findById(long id) {
        Book book = bookFacade.find(id);
        if(book == null) return null;
        return Helper.getBook(book);
    }

    @Override
    public void r_create(BookDTO book) {
        Book rbook = Helper.getBook(book);
        bookFacade.create(rbook);
    }

    @Override
    public void r_edit(BookDTO book) {
        Book rbook = Helper.getBook(book);
        bookFacade.edit(rbook);
    }

    @Override
    public void r_remove(BookDTO book) {
        Book rbook = Helper.getBook(book);
        bookFacade.remove(rbook);
    }

   
}
