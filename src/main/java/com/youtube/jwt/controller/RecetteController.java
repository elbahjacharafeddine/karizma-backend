package com.youtube.jwt.controller;

import com.youtube.jwt.dao.EtapeDoa;
import com.youtube.jwt.dao.IngredientDao;
import com.youtube.jwt.dao.RecetteDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Recette;
import com.youtube.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recette")
public class RecetteController {
    @Autowired
    private RecetteDao recetteDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private EtapeDoa etapeDoa;
    @Autowired
    private UserDao userDao;



    @PostMapping("/save")
    public Recette saveRecette(@RequestBody Recette recette){

        System.out.println(recette.getNom());
        return recetteDao.save(recette);
    }

    @GetMapping("all/{username}")
    public List<Recette> getRecettesByUser(@PathVariable String username){
        Optional<User> user = userDao.findById(username);
        List<Recette> recettes = new ArrayList<>();
        if (user.isPresent()){
            for (Recette r: user.get().getRecettes()){
                recettes.add(r);
            }
        }
        return recettes;
    }


}
