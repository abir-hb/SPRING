package tn.esprit.spring.service;

import java.util.List;

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
	
	

}
