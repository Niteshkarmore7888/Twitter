package com.example.Twitter_Apis.Transformer;

import com.example.Twitter_Apis.Dto.ResponseDto.PostResponseDto;
import com.example.Twitter_Apis.model.UserPost;

public class PostTransformer {

    public static PostResponseDto PostToResponse(UserPost userPost){
        return PostResponseDto.builder()
                .post(userPost.getPost())
                .postType(userPost.getPostType())
                .build();
    }
}
