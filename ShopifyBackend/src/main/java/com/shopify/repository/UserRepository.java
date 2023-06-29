package com.shopify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopify.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}