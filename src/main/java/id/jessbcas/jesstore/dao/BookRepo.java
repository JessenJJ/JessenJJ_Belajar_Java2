package id.jessbcas.jesstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.jessbcas.jesstore.models.Book;

public interface BookRepo extends JpaRepository<Book,String> {
    @Query(value = "select * from books where upper(title) like upper (concat('%',?,'%'))", nativeQuery  =  true)
    // select * from books where title = ""
    List<Book>searchByTitle(String title);

    List<Book>findByTitleIgnoreCaseLike(String title);
}
