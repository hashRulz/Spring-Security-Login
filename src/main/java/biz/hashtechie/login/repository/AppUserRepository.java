package biz.hashtechie.login.repository;

import biz.hashtechie.login.Appuser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository {

    Optional<Appuser> findByEmail (String email);
}
