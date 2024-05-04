package com.example.Twitter_Apis.service.Impl;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.Dto.ResponseDto.PostResponseDto;
import com.example.Twitter_Apis.Dto.ResponseDto.UserResponseDto;
import com.example.Twitter_Apis.Security.Config;
import com.example.Twitter_Apis.Transformer.UserTransformer;
import com.example.Twitter_Apis.model.User;
import com.example.Twitter_Apis.model.UserPost;
import com.example.Twitter_Apis.repository.UserRepository;
import com.example.Twitter_Apis.service.CreateNewUser;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateNewUserImpl implements CreateNewUser {

    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity CreateNewUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByMobileNo(userRequestDto.getMobileNo());
        User user1 = userRepository.findByEmailId(userRequestDto.getEmailId());
        if(user != null){
            return new ResponseEntity<>("Mobile no already in use", HttpStatus.NOT_ACCEPTABLE);
        }
        if(user1 != null){
            return new ResponseEntity<>("Email id Already used", HttpStatus.NOT_ACCEPTABLE);
        }

        User user2 = UserTransformer.RequestDtoToUser(userRequestDto);
        user2.setPassword(Config.encode(userRequestDto.getPassword()));
        userRepository.save(user2);
        return new ResponseEntity<>("New User Added", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity SearchUser(UserRequestDto userRequestDto) {
        User user = userRepository.findByMobileNo(userRequestDto.getMobileNo());
        if(user != null){
            if(Config.matches(userRequestDto.getPassword(), user.getPassword())  == true){
                User user1 = userRepository.findByMobileNo(userRequestDto.getUserName());
                if(user1 != null){
//                    List<UserPost> posts = new ArrayList<>();
//                    List<PostResponseDto> postResponseDtos = new ArrayList<>();
//                    for(int i=0; i<posts.size(); i++){
//                        PostResponseDto postResponseDto = new PostResponseDto();
//                        postResponseDto.setPostType(posts.get(i).getPostType());
//                        postResponseDto.setPost(posts.get(i).getPost());
//                        postResponseDtos.add(postResponseDto);
//                    }
                    UserResponseDto user2 = UserTransformer.UserToResponse(user1, user1.getUserPostList());
                    return new ResponseEntity<>(user2, HttpStatus.FOUND);
                }
                return new ResponseEntity<>("User Id not Found For Search", HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>("Wrong password", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>("User Not found", HttpStatus.CREATED);
    }
}
