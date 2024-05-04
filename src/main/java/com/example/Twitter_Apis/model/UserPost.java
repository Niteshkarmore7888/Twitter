package com.example.Twitter_Apis.model;

import com.example.Twitter_Apis.Enum.PostType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserPost {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

   String post;

   int likes;

   @Enumerated(EnumType.STRING)
   PostType postType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
