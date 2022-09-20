package com.cts.digitalbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digitalbook.dtos.ResponseDTO;
import com.cts.digitalbook.entities.BookEntity;
import com.cts.digitalbook.services.BookService;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/{authorId}/books")
	public ResponseDTO createBook(@RequestParam int authorId, @RequestBody BookEntity bookEntity) {
		ResponseDTO responseDto = new ResponseDTO();
		String message = bookService.createBookByAuthor(authorId, bookEntity);
		responseDto.setMessage(message);
		return responseDto;

	}

	@PutMapping("/{authorId}/books/{bookId}")
	public ResponseDTO updateBookDetails(@RequestParam int authorId, @RequestParam int bookId,
			@RequestBody BookEntity bookEntity) {
		ResponseDTO responseDto = new ResponseDTO();
		bookService.updateBookDetails(authorId, bookId,bookEntity);

		return responseDto;
	}

}
