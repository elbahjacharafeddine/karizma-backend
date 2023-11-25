package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDao extends JpaRepository<Ingredient,Long> {
}
