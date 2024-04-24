package com.ducluong.usermanagement.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u FROM tblusers u WHERE u.userId=?1")
    Optional<User> findByUserId(String userId);
}
