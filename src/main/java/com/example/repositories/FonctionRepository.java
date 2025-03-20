package com.example.repositories;

import com.example.model.Fonction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonctionRepository  extends JpaRepository<Fonction, String> {
}
