package id.jessbcas.jesstore.services.book;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.jessbcas.jesstore.dao.BookRepo;
import id.jessbcas.jesstore.models.Book;
import id.jessbcas.jesstore.payloads.BookRequest;
import id.jessbcas.jesstore.payloads.Response;
import id.jessbcas.jesstore.payloads.ResponseData;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;

    @Override
    public ResponseData<List<Book>> getBooks() {
        // ambil data dari db all
        List<Book> books =  bookRepo.findAll();

        ResponseData<List<Book>> results = new
        ResponseData<List<Book>>("success",true,books);
        return results;
        //return ke response data

    }

    @Override
    public Response postBook(BookRequest request) {
        // buat entitas buku dari payload
        Book book = new Book(request.getTitle(),request.getDescription());
        //save to repo
        this.bookRepo.save(book);
        //return response
        Response response = new Response("success added book",true);

        return response;
    }

    @Override
    public ResponseData<Book> updateBook(String id, BookRequest request) {
        //find book by id
        Book book =  this.bookRepo.findById(id).orElseThrow(()->
            // id gadapet -> throw exception
            
            new NoSuchElementException("ID book " + id +"not found!")
            // throw new NoSuchElementException("ID book " + id +"not found!");
        );
        // id dapet -> book timpa dari request
        // replace data
        book.setTitle(request.getTitle());
        book.setDescription(request.getDescription());

        // save book
        this.bookRepo.save(book);

        // response
        ResponseData<Book>resBook = new
        ResponseData<Book>("success update book data",true,book);
        return resBook;
    }

    @Override
    public ResponseData<List<Book>> findByIDBook(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Response deleteBook(String id) {
         // find book by id 
         Book book = this.bookRepo.findById(id).orElseThrow(()-> 
         new NoSuchElementException( "ID book" + id + "not found!"));
 
         //update status deleted
         book.setDeleted(true);
         // save
         this.bookRepo.save(book);
         // Response
         Response response = new Response(id + "is deleted!",true);
         return response;
    }

    @Override
    public ResponseData<List<Book>> getBooksByTitle(String title) {
        List<Book> books = this.bookRepo.searchByTitle(title);
        ResponseData<List<Book>> response = new 
        ResponseData<List<Book>>("success",true,books);
        return response;
    }




    // @Override
    // public ResponseData<List<Book>> findByIDBook(String id) {

    //     Book book = this.bookRepo.findById(id).orElseThrow(()->
    //     // id gadapet -> throw exception
        
    //     new NoSuchElementException("ID book " + id +"not found!")
    //     // throw new NoSuchElementException("ID book " + id +"not found!");
    // // );

    //     // response
    //     ResponseData Book = new ResponseData<>(Book("success update book data",true,book));
    //     return resBook;
    // }

    
    
}
