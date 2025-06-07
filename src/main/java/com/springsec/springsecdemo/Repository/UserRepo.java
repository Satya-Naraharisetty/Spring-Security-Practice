package com.springsec.springsecdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springsec.springsecdemo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
