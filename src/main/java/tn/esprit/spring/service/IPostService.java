package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;

import tn.esprit.spring.entity.Post;



public interface IPostService {
	 Post addPost(Post post);
	 List<Post> getAllPosts();
	 String deletePost(Long postid);
	 public void updatePost(Long id, int likes, String comments, int blocked, String category, int share, Date date);
			

}
