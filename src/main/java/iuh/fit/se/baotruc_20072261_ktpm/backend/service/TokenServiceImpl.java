package iuh.fit.se.baotruc_20072261_ktpm.backend.service;


import iuh.fit.se.baotruc_20072261_ktpm.backend.models.Token;
import iuh.fit.se.baotruc_20072261_ktpm.backend.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(Token token) {
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }
}