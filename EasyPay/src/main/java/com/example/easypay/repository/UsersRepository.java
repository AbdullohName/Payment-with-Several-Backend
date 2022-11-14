package com.example.easypay.repository;

import com.example.easypay.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findFirstByUsername(String username);
    void deleteByUsername(String username);
}