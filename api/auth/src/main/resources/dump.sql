INSERT INTO public.ks_clients (id, authorization_grant_types, client_authentication_methods, client_id, client_id_issued_at, client_name, client_secret, client_secret_expires_at, client_settings, redirect_uris, scopes, token_settings, post_logout_redirect_uris) VALUES ('d3600789-28ab-400a-bb45-154e54cea915', 'refresh_token,client_credentials,authorization_code', 'none,client_secret_basic,client_secret_post', 'client', '2024-10-12 09:29:12.475000 +00:00', 'd3600789-28ab-400a-bb45-154e54cea916', '$2a$10$vY.SCP0CONPXbwH05AN5o.zu8w4ZFHrsrV0pqM9C.NmJlvyfiLzNu', null, '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":true,"settings.client.require-authorization-consent":true}', 'http://localhost:4200,http://insomnia', 'read,openid,profile', e'{"@class":"java.util.Collections$UnmodifiableMap","settings.token.reuse-refresh-tokens":true,
                         "settings.token.id-token-signature-algorithm":["org.springframework.security.oauth2.jose.jws.SignatureAlgorithm","RS256"],
                         "settings.token.access-token-time-to-live":["java.time.Duration",86400.000000000],
                         "settings.token.access-token-format":{"@class":"org.springframework.security.oauth2.server.authorization.settings.OAuth2TokenFormat",
                         "value":"self-contained"},"settings.token.refresh-token-time-to-live":["java.time.Duration",3600.000000000],
                         "settings.token.authorization-code-time-to-live":["java.time.Duration",300.000000000]}', 'http://localhost:4200');

INSERT INTO public.ks_user_account (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username) VALUES ('d3600789-28ab-400a-bb45-154e54cea917', true, true, true, true, '$2a$10$nXenwhPee.2qNW347fQ81OgePTnbiMiTd3Y49VS1O6gXqtviCTy8a', 'dtp');

INSERT INTO public.ks_user_authorities (id, name) VALUES ('d3600789-28ab-400a-bb45-154e54cea917', 'read');

INSERT INTO public.ks_user_account_authorities (user_account_id, authorities_id) VALUES ('d3600789-28ab-400a-bb45-154e54cea917', 'd3600789-28ab-400a-bb45-154e54cea917');