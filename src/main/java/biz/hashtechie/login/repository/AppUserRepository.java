package biz.hashtechie.login.repository;

import biz.hashtechie.login.Appuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<Appuser,Long> {

    Optional<Appuser> findByEmail (String email);
}
