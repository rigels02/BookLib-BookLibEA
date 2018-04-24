# JEE application example
Netbeans projects

## Data base
Books library DB Running on Derby server accessible via Glassfish server and defined
as dataSource jdbc/shopping. Book is defined as JPA entity class and JPA api is used
to access it. 

## Data access logic (DAO)
Data access is defined as EJB @Stateless session bean using BookFacadeLocal 
interface.

## Books data management logic
Books CRUD busyness logic (service) is defined with BooksBean - Stateless bean.
BooksBean implements both interfaces : Local,Remote (IBooksBeanLocal,IBooksBeanRemote).
This service is accessible for clients applications by using interfaces:
- IBooksBeanLocal  - for local clients or modules in one JEE app (EAR file)
- IBooksBeanRemote - for remote clients. The remote clients are out of the EAR file
(not JEE module) or even resided on other jvm (on the same machine or even on other machine in network).

The remote interface with DTO model are resided as separate Library project BookLibEA_itf.

## Local web client app BookLibEA-war
BookLibEA-war is web app module of BookLibEA JEE app.

To access book service the servlet is used. The servlet injects BooksBean service
by EJB injection via local interface:
~~~~
@EJB
    IBooksBeanLocal booksEjb;
~~~~

## Remote jar standalone client BookLib-jar
It is simple JavaSE console application. To access BooksBean service it uses remote interface and, therefore, has dependency from BookLibEA_itf lib.
In addition, it needs Glassfish library gf-client.jar as reference in classpath.

## Remote war web application BookLib-war
The BookLib-war is standalone web app resided on the same JVM (Glassfish server)
as JEE BookLibEA. So, it use remote interface to access BooksBean service, therefore,
it has dependency from lib BookLibEA_itf.jar.
The servlet is used to access this service by injecting remote interface:
~~~~
 @EJB
    IBooksBeanRemote booksEjb;
~~~~
