package com.chat.application.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chat.application.model.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    //all the active user by username
    @Query(value = "Select * from tbl_user where username = :username and status_id = 1", nativeQuery = true)
    public List<Users> findByUsername(String username);

    //all the user by userid
    @Query(value = "select * from tbl_user where user_id = :userId and status_id = 1", nativeQuery = true)
    public List<Users> getUserByUserId(int userId);

    
    @Query(value = "select * from tbl_user where status_id = 1", nativeQuery = true)
    public List<Users> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "update tbl_user set status_id = 2 where user_id = :userId",
            countQuery = "SELECT count(*) FROM tbl_user", nativeQuery = true)
    public void deleteUserByUserId(int userId);

}
