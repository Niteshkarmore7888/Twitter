package com.example.Twitter_Apis.controller;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.model.UserPost;
import com.example.Twitter_Apis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/newPost/{mobileNo}/{password}")
    public ResponseEntity CreatePost(@RequestBody UserPost userPost, @PathVariable long mobileNo, @PathVariable String password){
        ResponseEntity responseEntity = postService.AddNewPost(userPost, mobileNo, password);
        return responseEntity;
    }
}
