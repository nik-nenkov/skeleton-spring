package com.epsilonnet.restapi.dao.repository;

import com.epsilonnet.restapi.dao.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = {"http://localhost:3000", "https://epsilon-net.com"})
@RepositoryRestResource(path = "accounts")
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query("SELECT COUNT(a) FROM Account a WHERE a.realm.uuid = :realmUuid")
    Long countByRealmUuid(@Param("realmUuid") UUID realmUuid);

    Optional<Account> findByUserId(String userId);
}