package com.example.Twitter_Apis.Transformer;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.Dto.ResponseDto.PostResponseDto;
import com.example.Twitter_Apis.Dto.ResponseDto.UserResponseDto;
import com.example.Twitter_Apis.model.User;
import com.example.Twitter_Apis.model.UserPost;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    public static User RequestDtoToUser(UserRequestDto userRequestDto){
        return User.builder()
                .emailId(userRequestDto.getEmailId())
                .name(userRequestDto.getName())
                .mobileNo(userRequestDto.getMobileNo())
                .build();
    }

    public static UserResponseDto UserToResponse(User user, List<UserPost> postResponseDtoList){

        List<UserPost> userPostList = new ArrayList<>();
        for(int i=0; i< postResponseDtoList.size(); i++){
            UserPost userPost = new UserPost();
            userPost.setPost(postResponseDtoList.get(i).getPost());
            userPost.setPostType(postResponseDtoList.get(i).getPostType());
            userPost.setId(postResponseDtoList.get(i).getId());
            userPostList.add(userPost);
        }


        return UserResponseDto.builder()
                .emailId(user.getEmailId())
                .mobileNo(user.getMobileNo())
                .name(user.getName())
                .userPostList(userPostList)
                .build();
    }
}
