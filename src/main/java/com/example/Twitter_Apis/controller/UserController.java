package com.example.Twitter_Apis.controller;

import com.example.Twitter_Apis.Dto.RequestDto.UserRequestDto;
import com.example.Twitter_Apis.service.CreateNewUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CreateNewUser createNewUser;

    @PostMapping("/add")
    public ResponseEntity CreateNewUser(@RequestBody UserRequestDto userRequestDto){
        ResponseEntity responseEntity = createNewUser.CreateNewUser(userRequestDto);
        return responseEntity;
    }

    @GetMapping("/search")
    public ResponseEntity SearchUser(@RequestBody UserRequestDto userRequestDto){
        ResponseEntity responseEntity = createNewUser.SearchUser(userRequestDto);
        return responseEntity;
    }
}
