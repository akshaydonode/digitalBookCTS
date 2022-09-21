package com.cts.digitalbook.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.digitalbook.dtos.BookSearchDTO;
import com.cts.digitalbook.entities.AuthorEntity;
import com.cts.digitalbook.entities.BookEntity;
import com.cts.digitalbook.repositories.AuthorRepository;
import com.cts.digitalbook.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public String createBookByAuthor(int authorId, BookEntity bookEntity) {
		if (Objects.nonNull(bookRepository.findById(authorId))) {
			if (!bookEntity.getTitle().isEmpty() && !bookEntity.getCategory().isEmpty()
					&& !bookEntity.getContents().isEmpty()) {
				bookRepository.save(bookEntity);
				return "Book Created Successfully";
			} else {
				return "Please fill mandatory details like Book-Title, Book-Category and Book-Contens";
			}

		} else {
			return "Author is not registered or valid....";
		}

	}

	@Override
	public String updateBookDetails(int authorId, int bookId, BookEntity bookEntity) {
		BookEntity bookDetails = bookRepository.getBookDetailsByBookIdAndAuthorId(authorId, bookId);

		if (Objects.nonNull(bookDetails)) {
			if (!bookDetails.getCategory().equals(bookEntity.getCategory())) {
				bookDetails.setCategory(bookEntity.getCategory());
			}

			if (!bookDetails.getContents().equals(bookEntity.getContents())) {
				bookDetails.setContents(bookEntity.getContents());
			}

			if (!bookDetails.getPublished().equals(bookEntity.getPublished())) {
				bookDetails.setPublished(bookEntity.getPublished());
			}

			if (!bookDetails.getPublisher().equals(bookEntity.getPublisher())) {
				bookDetails.setPublisher(bookEntity.getPublisher());
			}

			if (!bookDetails.getLogo().equals(bookEntity.getLogo())) {
				bookDetails.setLogo(bookEntity.getLogo());
			}
			if (bookDetails.getPrice() - bookEntity.getPrice() != 0) {
				bookDetails.setPrice(bookEntity.getPrice());
			}
			if (bookDetails.getActive() != bookEntity.getActive()) {
				bookDetails.setActive(bookEntity.getActive());
			}

			bookRepository.save(bookDetails);

			return "Book Details Updated Successfully";
		} else {
			return "Invalid Book ID and Author ID";
		}

	}

	@Override
	public List<BookEntity> searchBook(BookSearchDTO bookSearchDTO) {

//		List<AuthorEntity> authorEntity = authorRepository.findByName(bookSearchDTO.getAuthorName());

		List<BookEntity> bookEntity = bookRepository.searchBook(bookSearchDTO.getTitle(), bookSearchDTO.getAuthorName(),
				bookSearchDTO.getCategory(), bookSearchDTO.getPrice(), bookSearchDTO.getPublisher());
		
		
		
		return bookEntity;
	}

}
