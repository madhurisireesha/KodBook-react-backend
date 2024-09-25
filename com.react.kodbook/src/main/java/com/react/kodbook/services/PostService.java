package com.react.kodbook.services;
import java.util.List;

//import com.kodbook.controllers.User;
import com.react.kodbook.entities.Post;
import com.react.kodbook.entities.User;
public interface PostService {
void createPost(Post post);
	
	List<Post> getAllPosts();

	List<Post> fetchAllPosts();

	Post getPost(Long id);

	void updatePost(Post post);

}
