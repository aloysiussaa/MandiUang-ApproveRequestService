package coid.bca.MandiUangTrxService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coid.bca.MandiUangTrxService.model.BranchAccount;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<BranchAccount, Long> {
    Optional<BranchAccount> findByBranchAccountNo(String branchAccountNo);

    Boolean existsByBranchAccountNo(String branchAccountNo);
   
    Optional<BranchAccount> findByMainAccountId(Long mainAccountId);
    
    Boolean existsByBranchAccountId(Long branchAccountId);

	Optional<BranchAccount> findByBranchAccountId(Long branchIdWork);
    
}
