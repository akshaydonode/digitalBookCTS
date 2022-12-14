package com.cts.digitalbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.digitalbook.entities.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

	@Query("select a from AuthorEntity a where a.authorEmail=?1")
	public AuthorEntity findByEmailId(String authorEmail);

	@Query("select a from AuthorEntity a where a.authorName=?1")
	public List<AuthorEntity> findByName(String authorName);

}
