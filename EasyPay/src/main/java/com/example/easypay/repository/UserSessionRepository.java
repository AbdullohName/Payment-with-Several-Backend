package com.example.easypay.repository;

import com.example.easypay.entity.UserSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserSessionRepository extends CrudRepository<UserSession, Long> {
}
