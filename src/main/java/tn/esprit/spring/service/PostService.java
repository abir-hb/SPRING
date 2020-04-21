package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.controller.IPostController;
import tn.esprit.spring.entity.Post;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.PostRepository;
import tn.esprit.spring.repository.UserRepository;


@Component
public class PostService implements IPostService {
	private static final String idd = null;
	@Autowired
	PostRepository PostRepository;
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public Post addPost(Post post) {
		return PostRepository.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return (List<Post>)PostRepository.findAll();
	}

	@Override
	public String deletePost(Long postid) {
		PostRepository.deleteById(postid);
		return null;
	}
	
	@Override
	public void updatePost(Long id, int likes, String comments, int blocked, String category, int share, Date date) {
		Post post = PostRepository.findById(id).get();
		post.setBlocked(blocked);
		post.setLikes(likes);
		post.setComments(comments);
		post.setCategory(category);
		post.setShare(share);
		post.setDate(date);
		PostRepository.save(post);
	}
	
	@Override
	public Optional<Post> findByDate(Date date) {

		return PostRepository.findByDate(date);
	}
	

}
