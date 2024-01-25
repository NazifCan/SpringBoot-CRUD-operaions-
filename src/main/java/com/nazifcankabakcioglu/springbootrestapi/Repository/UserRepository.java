package com.nazifcankabakcioglu.springbootrestapi.Repository;

import com.nazifcankabakcioglu.springbootrestapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}
