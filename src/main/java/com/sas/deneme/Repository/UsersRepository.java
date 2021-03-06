package com.sas.deneme.Repository;

import com.sas.deneme.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Query("SELECT u FROM Users u WHERE u.username = :username")
    Users findUserByUsername(@Param("username") String username);

    @Query("SELECT 1 FROM Users u WHERE u.username = :username")
    Integer checkUserExistence(@Param("username") String username);

    @Transactional
    @Modifying
    @Query("DELETE FROM Users u WHERE u.username = :username")
    void deleteUserByUsername(@Param("username") String username);
}