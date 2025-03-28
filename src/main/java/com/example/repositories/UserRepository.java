package com.example.repositories;

import com.example.model.Login;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByNom(String nom);

    // Like nom%
    public List<User> findByNomStartsWith(String nom);

    @Query("select l from User u inner join u.logins l")
    public List<Login> getAllLogins();

    @Query("select l from User u inner join u.logins l where u.nom=:USERNAME")
    public List<Login> getUserLogins(@Param(value = "USERNAME") String uName);

    @Query("select l.login, u.nom, u.grade from User u inner join u.logins l")
    public List<Object[]> getInfoUsers();

    @Query("select u, count(l) from User u inner join u.logins l group by u having count(l)>=2")
    public List<User> getUserMaxLogin();

    @Query("select u, l, f from User u inner join u.logins l inner join u.affectations a inner join a.fonction f where l.login = :login")
    public User getDetailsUser(@Param("login") String login);
}
