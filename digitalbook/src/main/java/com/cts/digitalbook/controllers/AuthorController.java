package com.cts.digitalbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.digitalbook.dtos.AuthorLoginDTO;
import com.cts.digitalbook.dtos.ResponseDTO;
import com.cts.digitalbook.entities.AuthorEntity;
import com.cts.digitalbook.services.AuthorService;

@RestController
@RequestMapping("/author")
@CrossOrigin
public class AuthorController {

	@Autowired
	AuthorService authorService;

	@PostMapping("/signup")
	public ResponseDTO registerAuthor(@RequestBody AuthorEntity authorEntity) {
		ResponseDTO responseDto = new ResponseDTO();
		String message = authorService.registerAuthor(authorEntity);

		responseDto.setMessage(message);

		return responseDto;

	}

	@GetMapping("/login")
	public ResponseDTO loginAuthor(@RequestBody AuthorLoginDTO authorLoginDTO) {
		ResponseDTO responseDto = new ResponseDTO();
		String message = authorService.authorLogin(authorLoginDTO);
		responseDto.setMessage(message);
		return responseDto;
	}

}
