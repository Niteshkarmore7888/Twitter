package com.example.Twitter_Apis.Dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;
    String password;
    String emailId;
    long mobileNo;
    long userName;

}
