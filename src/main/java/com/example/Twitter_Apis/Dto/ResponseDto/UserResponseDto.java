package com.example.Twitter_Apis.Dto.ResponseDto;

import com.example.Twitter_Apis.model.UserPost;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    String name;
//    String password;
    String emailId;
    long mobileNo;

    List<UserPost> userPostList = new ArrayList<>();
}
