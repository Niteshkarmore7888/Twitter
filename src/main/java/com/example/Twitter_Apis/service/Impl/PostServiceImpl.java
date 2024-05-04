package com.example.Twitter_Apis.service.Impl;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.Dto.ResponseDto.PostResponseDto;
import com.example.Twitter_Apis.Security.Config;
import com.example.Twitter_Apis.Transformer.PostTransformer;
import com.example.Twitter_Apis.model.User;
import com.example.Twitter_Apis.model.UserPost;
import com.example.Twitter_Apis.repository.PostRepository;
import com.example.Twitter_Apis.repository.UserRepository;
import com.example.Twitter_Apis.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity AddNewPost(UserPost userPost, long mobile, String password) {
        User user = userRepository.findByMobileNo(mobile);
        if(user != null){
            if(Config.matches(password, user.getPassword())){
                userPost.setUser(user);
                postRepository.save(userPost);
                PostResponseDto postResponseDto = PostTransformer.PostToResponse(userPost);
                postResponseDto.setName(user.getName());
                return new ResponseEntity<>(postResponseDto, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Wrong password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("User Not found", HttpStatus.CREATED);
    }
}
