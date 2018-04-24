package service;

import enitity.Book;

/**
 *
 * @author raitis
 */
public class Helper {
    
    private Helper(){}
    
    public static Book getBook(BookDTO book){
        Book bookOut = new Book();
        bookOut.setId(book.getId());
        bookOut.setTitle(book.getTitle());
        bookOut.setAuthor(book.getAuthor());
        bookOut.setPages(book.getPages());
        return bookOut;
    }
    
    public static BookDTO getBook(Book book){
        BookDTO bookOut = new BookDTO();
        bookOut.setId(book.getId());
        bookOut.setTitle(book.getTitle());
        bookOut.setAuthor(book.getAuthor());
        bookOut.setPages(book.getPages());
        return bookOut;
    }
}
