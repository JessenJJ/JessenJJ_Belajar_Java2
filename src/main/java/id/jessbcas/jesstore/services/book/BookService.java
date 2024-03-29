package id.jessbcas.jesstore.services.book;

import java.util.List;

import id.jessbcas.jesstore.models.Book;
import id.jessbcas.jesstore.payloads.BookRequest;
import id.jessbcas.jesstore.payloads.Response;
import id.jessbcas.jesstore.payloads.ResponseData;

public interface BookService {
    //kerangka method crud
    //retrieve data
    ResponseData<List<Book>>getBooks();

    ResponseData<List<Book>>getBooksByTitle(String title);

    Response postBook(BookRequest request);

    ResponseData<Book> updateBook(String id, BookRequest request);

    Response deleteBook(String id);

    ResponseData<List<Book>>findByIDBook(String id);
}
