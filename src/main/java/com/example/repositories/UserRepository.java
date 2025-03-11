package com.example.repositories;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select l from User u inner join u.logins l")
    public List<Login> getAllLogins();
}
