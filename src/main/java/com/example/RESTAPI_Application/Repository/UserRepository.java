package com.example.RESTAPI_Application.Repository;
import com.example.RESTAPI_Application.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserDetail_Email(String email);

}
