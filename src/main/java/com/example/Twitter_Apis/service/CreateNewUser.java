package com.example.Twitter_Apis.service;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import org.springframework.http.ResponseEntity;

public interface CreateNewUser {
    ResponseEntity CreateNewUser(UserRequestDto userRequestDto);

    ResponseEntity SearchUser(UserRequestDto userRequestDto);
}
