package com.youtube.jwt.service;

import com.youtube.jwt.dao.EtapeDoa;
import com.youtube.jwt.dao.IngredientDao;
import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Etape;
import com.youtube.jwt.entity.Ingredient;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private EtapeDoa etapeDoa;
    public void initRoleAndUser() {

        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Pasta");
        ingredientDao.save(ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setNom("Ground Beef");
        ingredientDao.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setNom("Tomato Sauce");
        ingredientDao.save(ingredient2);

        Etape etape = new Etape();
        etape.setNom("Boil the pasta");
        etapeDoa.save(etape);

        Etape etape1 = new Etape();
        etape1.setNom("Cook the ground beef and mix with tomato sauce");
        etapeDoa.save(etape1);

        Etape etape2 = new Etape();
        etape2.setNom("Combine the cooked pasta with the meat sauce");
        etapeDoa.save(etape2);


        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
