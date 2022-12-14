package com.cts.digitalbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.digitalbook.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	@Query("select b from BookEntity b where b.bookId=?2 and b.authorId=?1")
	BookEntity getBookDetailsByBookIdAndAuthorId(int authorId, int bookId);

	@Query("select b from BookEntity b where b.title LIKE ('%', ?1, '%') OR b.category LIKE ('%', ?3, '%') or b.price LIKE ('%', ?4, '%') or b.publisher LIKE ('%', ?5, '%') or b.authorId in (select a from AuthorEntity a where a.authorName LIKE ('%', ?2,'%'))")
	List<BookEntity> searchBook(String title, String authorName, String category, double price, String publisher);

}
