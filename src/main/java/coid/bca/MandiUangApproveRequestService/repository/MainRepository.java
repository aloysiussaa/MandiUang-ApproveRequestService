package coid.bca.MandiUangApproveRequestService.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import coid.bca.MandiUangApproveRequestService.model.MainAccount;

public interface MainRepository extends JpaRepository<MainAccount, Long> {

	Optional<MainAccount> findByMainAccountNo(String mainAccountNo);

    Boolean existsByMainAccountNo(String mainAccountNo);
    
    Boolean existsByMainAccountId(Long mainAccountId);

	Optional<MainAccount> findByMainAccountId(Long mainIdWork);
}
