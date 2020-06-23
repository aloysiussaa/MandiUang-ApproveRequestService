package coid.bca.MandiUangTrxService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import coid.bca.MandiUangTrxService.model.MainTrxToBranch;

public interface MainTrxRepository extends JpaRepository<MainTrxToBranch, Long> {
	Optional<MainTrxToBranch> findByMainAcctTrxId (MainTrxToBranch mainAcctTrxId);
}
