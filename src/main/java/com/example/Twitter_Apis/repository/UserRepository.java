package com.example.Twitter_Apis.repository;

import com.example.Twitter_Apis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMobileNo(long mobileNo);

    User findByEmailId(String email);
}
