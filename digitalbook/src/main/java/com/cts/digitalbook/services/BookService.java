package com.cts.digitalbook.services;

import com.cts.digitalbook.entities.BookEntity;

public interface BookService {

	public String createBookByAuthor(int authorId, BookEntity bookEntity);

	public String updateBookDetails(int authorId, int bookId, BookEntity bookEntity);

}
