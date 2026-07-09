package com.example.RESTAPI_Application.Repository;
import com.example.RESTAPI_Application.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
