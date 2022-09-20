package com.cts.digitalbook.services;

import com.cts.digitalbook.dtos.AuthorLoginDTO;
import com.cts.digitalbook.entities.AuthorEntity;

public interface AuthorService {

	public String registerAuthor(AuthorEntity author);

	public String authorLogin(AuthorLoginDTO authorLoginDTO);
	

}
