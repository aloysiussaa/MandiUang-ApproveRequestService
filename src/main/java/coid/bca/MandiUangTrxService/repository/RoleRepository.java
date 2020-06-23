package coid.bca.MandiUangTrxService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import coid.bca.MandiUangTrxService.model.Role;
import coid.bca.MandiUangTrxService.model.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}