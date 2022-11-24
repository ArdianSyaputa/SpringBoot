package com.toko.tokoonline.repository;

import com.toko.tokoonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
@Query (value = "select * from user where email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}
