package iuh.fit.se.baotruc_20072261_ktpm.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import iuh.fit.se.baotruc_20072261_ktpm.backend.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByEmailAndPasswordHash(String email, String passwordHash);
//    findByEmailAndPasswordHash(String email, String passwordHash);
}