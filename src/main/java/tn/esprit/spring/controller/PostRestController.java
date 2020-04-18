package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.service.IPostService;



@RestController
public class PostRestController {
	@Autowired
	IPostService PostService;
	@RequestMapping("/home")
	@ResponseBody
	public String welcomehome() 
	{ 
		return "Helllooooooooooooo"; 
	}
	
	
	@PostMapping("/addpost")
	@ResponseBody
	public Post addPost(@RequestBody Post pos) {
		Post post = PostService.addPost(pos);
	return post;
	}
	@GetMapping("/getallposts")
	@ResponseBody
	public List<Post> getAllPosts() {
	List<Post> list = PostService.getAllPosts();
	return list;
	}
	@DeleteMapping("/deletepost/{post-id}")
	@ResponseBody
	public String deleteDispo(@PathVariable("post-id") long postid) {
		PostService.deletePost(postid);
		return "Le Post "+postid+" est supprimé";
	}
	
}
