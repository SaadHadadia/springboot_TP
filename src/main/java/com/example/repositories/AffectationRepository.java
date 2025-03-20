package com.example.repositories;

import com.example.model.Affectation;
import com.example.model.AffectationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository  extends JpaRepository<Affectation, AffectationId> {

}
