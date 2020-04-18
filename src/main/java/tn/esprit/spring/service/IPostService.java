package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Post;



public interface IPostService {
	 Post addPost(Post post);
	 List<Post> getAllPosts();
	 String deletePost(Long postid);
	

}
