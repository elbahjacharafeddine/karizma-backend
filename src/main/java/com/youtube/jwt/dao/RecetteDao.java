package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteDao extends JpaRepository<Recette,Long> {
}
