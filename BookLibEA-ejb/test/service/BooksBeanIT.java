package service;

import enitity.Book;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author raitis
 */
public class BooksBeanIT {
    
    public BooksBeanIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class BooksBean.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanLocal instance = (IBooksBeanLocal)container.getContext().lookup("java:global/classes/BooksBean");
        List<Book> expResult = null;
        List<Book> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class BooksBean.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanLocal instance = (IBooksBeanLocal)container.getContext().lookup("java:global/classes/BooksBean");
        Book expResult = null;
        Book result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BooksBean.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Book book = new Book("book 1", "author 1", 10);
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanLocal instance = (IBooksBeanLocal)container.getContext().lookup("java:global/classes/BooksBean");
        instance.create(book);
        
        List<Book> books = instance.findAll();
        assertTrue(books.size()==1);
        container.close();
        
    }

    /**
     * Test of edit method, of class BooksBean.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Book book = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanLocal instance = (IBooksBeanLocal)container.getContext().lookup("java:global/classes/BooksBean");
        instance.edit(book);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BooksBean.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Book book = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanLocal instance = (IBooksBeanLocal)container.getContext().lookup("java:global/classes/BooksBean");
        instance.remove(book);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of r_findAll method, of class BooksBean.
     */
    @Test
    public void testR_findAll() throws Exception {
        System.out.println("r_findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanRemote instance = (IBooksBeanRemote)container.getContext().lookup("java:global/classes/BooksBean");
        List<BookDTO> expResult = null;
        List<BookDTO> result = instance.r_findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of r_findById method, of class BooksBean.
     */
    @Test
    public void testR_findById() throws Exception {
        System.out.println("r_findById");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanRemote instance = (IBooksBeanRemote)container.getContext().lookup("java:global/classes/BooksBean");
        BookDTO expResult = null;
        BookDTO result = instance.r_findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of r_create method, of class BooksBean.
     */
    @Test
    public void testR_create() throws Exception {
        System.out.println("r_create");
        BookDTO book = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanRemote instance = (IBooksBeanRemote)container.getContext().lookup("java:global/classes/BooksBean");
        instance.r_create(book);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of r_edit method, of class BooksBean.
     */
    @Test
    public void testR_edit() throws Exception {
        System.out.println("r_edit");
        BookDTO book = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanRemote instance = (IBooksBeanRemote)container.getContext().lookup("java:global/classes/BooksBean");
        instance.r_edit(book);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of r_remove method, of class BooksBean.
     */
    @Test
    public void testR_remove() throws Exception {
        System.out.println("r_remove");
        BookDTO book = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        IBooksBeanRemote instance = (IBooksBeanRemote)container.getContext().lookup("java:global/classes/BooksBean");
        instance.r_remove(book);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
