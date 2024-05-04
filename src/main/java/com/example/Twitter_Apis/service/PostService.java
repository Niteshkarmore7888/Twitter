package com.example.Twitter_Apis.service;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.model.UserPost;
import org.springframework.http.ResponseEntity;

public interface PostService {
    ResponseEntity AddNewPost(UserPost userPost, long mobileNo, String password);
}
