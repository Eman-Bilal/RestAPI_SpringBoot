package com.example.RESTAPI_Application.Repository;
import com.example.RESTAPI_Application.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
