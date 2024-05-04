package com.example.Twitter_Apis.repository;

import com.example.Twitter_Apis.model.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<UserPost, Integer> {
}
