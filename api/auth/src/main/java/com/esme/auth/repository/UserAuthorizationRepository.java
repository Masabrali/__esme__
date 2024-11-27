package com.esme.auth.repository;

import com.esme.auth.entity.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserAuthorizationRepository extends JpaRepository<UserAuthorization, UUID> {
    Optional<UserAuthorization> findByState(String state);

    Optional<UserAuthorization> findByAuthorizationCodeValue(String authorizationCode);

    Optional<UserAuthorization> findByAccessTokenValue(String accessToken);

    Optional<UserAuthorization> findByRefreshTokenValue(String refreshToken);

    @Query("""
            select a from UserAuthorization  a where a.state = :token
            or a.authorizationCodeValue = :token
            or a.accessTokenValue = :token
            or a.refreshTokenValue = :token
            """)
    Optional<UserAuthorization> findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(@Param("token") String token);
}
