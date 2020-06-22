package coid.bca.MandiUangApproveRequestService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coid.bca.MandiUangApproveRequestService.model.BranchReqBudget;

public interface ReqBudgetRepository extends JpaRepository<BranchReqBudget, Long> {
	Optional<BranchReqBudget> findByReqId (Long reqId);
}
