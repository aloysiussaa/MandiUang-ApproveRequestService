package coid.bca.MandiUangApproveRequestService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coid.bca.MandiUangApproveRequestService.model.MainApproveBudget;

public interface ApproveBudgetRepository extends JpaRepository<MainApproveBudget, Long> {
	Optional<MainApproveBudget> findByApproveId (Long approveId);
}
