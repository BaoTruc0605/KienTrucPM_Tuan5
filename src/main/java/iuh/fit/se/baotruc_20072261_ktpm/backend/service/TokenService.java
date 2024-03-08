package iuh.fit.se.baotruc_20072261_ktpm.backend.service;


import iuh.fit.se.baotruc_20072261_ktpm.backend.models.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}