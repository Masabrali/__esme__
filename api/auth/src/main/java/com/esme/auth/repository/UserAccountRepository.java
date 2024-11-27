package com.esme.auth.repository;


import com.esme.auth.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, UUID> {
    @Query("""
            select u from UserAccount u where u.username = :username
            """)
    Optional<UserAccount> findByUsername(String username);
}
