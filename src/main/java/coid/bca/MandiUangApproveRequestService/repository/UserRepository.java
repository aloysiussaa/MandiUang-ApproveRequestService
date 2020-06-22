package coid.bca.MandiUangApproveRequestService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coid.bca.MandiUangApproveRequestService.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrEmail(String username, String email);
    
    Optional<User> findByUsername(String username);
    
    @Query("SELECT mainIdWork FROM User WHERE username = ?1")
    Integer findMainAccountIdByUsername(String username);
}
