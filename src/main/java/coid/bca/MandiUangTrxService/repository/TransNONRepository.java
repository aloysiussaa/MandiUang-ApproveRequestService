package coid.bca.MandiUangTrxService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import coid.bca.MandiUangTrxService.model.BranchTrxToNonBCA;

public interface TransNONRepository extends JpaRepository<BranchTrxToNonBCA, Integer> {
	Optional<BranchTrxToNonBCA> findByBranchNonTrxId (BranchTrxToNonBCA branchNonTrxId);
}
