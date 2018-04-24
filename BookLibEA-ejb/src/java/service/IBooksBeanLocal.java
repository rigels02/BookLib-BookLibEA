
package service;

import enitity.Book;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author raitis
 */
@Local
public interface IBooksBeanLocal {
    
    List<Book> findAll();
    
    Book  findById(long id);
    
    void create(Book book);
    
    void edit(Book book);
    
    void remove(Book book);
}
