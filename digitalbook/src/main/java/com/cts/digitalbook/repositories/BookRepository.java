package com.cts.digitalbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.digitalbook.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	@Query("select b from BookEntity b where b.bookId=?2 and b.authorId=?1")
	BookEntity getBookDetailsByBookIdAndAuthorId(int authorId, int bookId);

}
