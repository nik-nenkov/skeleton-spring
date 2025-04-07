package com.epsilonnet.restapi.api.controller;

import com.epsilonnet.restapi.dao.entity.Account;
import com.epsilonnet.restapi.dao.repository.AccountRepository;
import com.epsilonnet.restapi.dao.repository.RealmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    private final AccountRepository accountRepository;
    private final RealmRepository realmRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository, RealmRepository realmRepository) {
        this.accountRepository = accountRepository;
        this.realmRepository = realmRepository;
    }

    @GetMapping("/my")
    @Transactional
    public ResponseEntity<Account> getOrCreateMyAccount(Authentication authentication) {

        // Extract the userId (sub) from the JWT
        Jwt jwt = (Jwt) authentication.getPrincipal();
        String userId = jwt.getSubject();

        return ResponseEntity.ok(accountRepository.findByUserId(userId).orElseGet(() -> {
            Account newAccount = new Account();
            newAccount.setUserId(userId);
            realmRepository.findDefaultRealm().ifPresent(newAccount::setRealm);;
            // Optionally set default values, e.g., newAccount.setName("New User");
            return accountRepository.save(newAccount);
        }));
    }
}