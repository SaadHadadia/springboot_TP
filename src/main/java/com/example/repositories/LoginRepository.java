package com.example.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	public List<Login> findByLogin(String login);
	public List<Login> findByMdp(String mdp);
	public List<Login> findByLoginAndMdp(String login,String mdp);
}
