package com.esme.auth.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ks_user_authorization")
public class UserAuthorization {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.AUTO)
    private UUID id;

    private String registeredClientId;
    private String principalName;
    private String authorizationGrantType;
    @Column(length = 1000)
    private String authorizedScopes;

    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 4000)
    private String attributes;
    @Column(length = 500)
    private String state;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 4000)
    private String authorizationCodeValue;
    private Instant authorizationCodeIssuedAt;
    private Instant authorizationCodeExpiresAt;
    private String authorizationCodeMetadata;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 4000)
    private String accessTokenValue;
    private Instant accessTokenIssuedAt;
    private Instant accessTokenExpiresAt;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 2000)
    private String accessTokenMetadata;
    private String accessTokenType;
    @Column(length = 1000)
    private String accessTokenScopes;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 4000)
    private String refreshTokenValue;
    private Instant refreshTokenIssuedAt;
    private Instant refreshTokenExpiresAt;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 2000)
    private String refreshTokenMetadata;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 4000)
    private String oidcIdTokenValue;
    private Instant oidcIdTokenIssuedAt;
    private Instant oidcIdTokenExpiresAt;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 2000)
    private String oidcIdTokenMetadata;
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(length = 2000)
    private String oidcIdTokenClaims;
}
