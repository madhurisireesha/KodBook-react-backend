
package com.react.kodbook.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.react.kodbook.entities.LoginData;
import com.react.kodbook.entities.Post;
import com.react.kodbook.entities.User;
import com.react.kodbook.services.PostService;
import com.react.kodbook.services.UserService;

import jakarta.servlet.http.HttpSession;

@CrossOrigin("*")
@RestController
public class UserController {
	@Autowired
	UserService service;
	@Autowired
	PostService postService;
	
	@PostMapping("/signUp")
	public String addUser(@RequestBody User user) {
		//user exists?
		String username = user.getUsername();
		String email = user.getEmail();
		boolean status = service.userExists(username, email);
		if(status == false) {
			service.addUser(user);
		}
		return "sign up done";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody LoginData user ,
			Model model, HttpSession session)	{
		
		boolean status = service.validateUser(user.getUsername(), user.getPassword());
		if(status == true) {
			List<Post> allPosts = postService.fetchAllPosts();
			
			session.setAttribute("username", user.getUsername());
			model.addAttribute("session", session);
			
			model.addAttribute("allPosts", allPosts);
			
			return "valid";
		}
		else {
			return "invalid";
		}
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(@RequestParam String dob, @RequestParam String gender,
			@RequestParam String city, @RequestParam String bio,
			@RequestParam String college, @RequestParam String linkedIn,
			@RequestParam String gitHub, @RequestParam MultipartFile profilePic
			, HttpSession session,
			Model model) {
		
		String username = (String) session.getAttribute("username");
		
		//fetch user object using username
		User user = service.getUser(username);
		//update and save object
		user.setDob(dob);
		user.setGender(gender);
		user.setCity(city);
		user.setBio(bio);
		user.setCollege(college);
		user.setLinkedIn(linkedIn);
		user.setGitHub(gitHub);
		try {						
			user.setProfilePic(profilePic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.updateUser(user);
		model.addAttribute("user", user);
		return "myProfile";
	}
}
