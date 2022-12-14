package com.cts.digitalbook.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.digitalbook.dtos.AuthorLoginDTO;
import com.cts.digitalbook.entities.AuthorEntity;
import com.cts.digitalbook.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public String registerAuthor(AuthorEntity authorEntity) {

		if (!authorEntity.getAuthorEmail().isEmpty() && !authorEntity.getPassword().isEmpty()
				&& !authorEntity.getAuthorName().isEmpty()) {

			if (Objects.isNull(authorRepository.findByEmailId(authorEntity.getAuthorEmail()))) {

				authorRepository.save(authorEntity);

			} else {
				return "Author EmailID id already Exit. Please use the same or create new account. Thank You !!!";
			}

			return "Author Registered Successfully...";
		} else {

			return "Author Registration Failed. PLease fill all the fileds like Name, EmailID, Password...";

		}
	}

	@Override
	public String authorLogin(AuthorLoginDTO authorLoginDTO) {
		AuthorEntity author = authorRepository.findByEmailId(authorLoginDTO.getAuthorEmail());

		if (Objects.nonNull(author)) {
			if (author.getPassword().equals(authorLoginDTO.getPassword())) {
				return "Author Login successfully";
			} else {
				return "Please enter the correct password.";
			}
		} else {
			return "Author Not Registered. Please register Author";
		}

	}
}
