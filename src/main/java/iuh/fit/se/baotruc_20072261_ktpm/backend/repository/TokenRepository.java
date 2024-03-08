package iuh.fit.se.baotruc_20072261_ktpm.backend.repository;

import iuh.fit.se.baotruc_20072261_ktpm.backend.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}