package com.Restaurant_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Restaurant_project.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
