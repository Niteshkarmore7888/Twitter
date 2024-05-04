package com.example.Twitter_Apis.Dto.ResponseDto;

import com.example.Twitter_Apis.Enum.PostType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponseDto {
    String name;

    @Enumerated(EnumType.STRING)
    PostType postType;

    String post;



}
