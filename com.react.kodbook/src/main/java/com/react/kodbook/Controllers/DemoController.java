package com.react.kodbook.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.react.kodbook.entities.Data;
import com.react.kodbook.entities.FormData;

@CrossOrigin("*")
@RestController
public class DemoController {
	@GetMapping("/simpleRequest")
	public String simpleRequest() {
		System.out.println("Request Received");
		return "Response from springboot";
	}
	@PostMapping("/simplePost")
	public String simplepost(@RequestBody Data data) {
		System.out.println("Request Received");
		return "Response from springboot"+data;
	}
	@PostMapping("/formData")
	public String formData(@RequestBody FormData formdata)
	{
		System.out.print(formdata);
		return "post:response";
	}
}
