package tn.esprit.spring.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
	Optional<Post> findByDate(Date date);

}
