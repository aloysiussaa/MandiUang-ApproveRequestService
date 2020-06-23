package coid.bca.MandiUangTrxService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import coid.bca.MandiUangTrxService.model.BranchTrxToBCA;

public interface TransBCARepository extends JpaRepository<BranchTrxToBCA, Integer> {
	Optional<BranchTrxToBCA> findByBranchBcaTrxId (BranchTrxToBCA branchBcaTrxId);
}
