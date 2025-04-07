package com.epsilonnet.restapi.dao.entity;

import com.epsilonnet.restapi.config.ApplicationContextProvider;
import com.epsilonnet.restapi.dao.repository.AccountRepository;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Realm {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(nullable = false, updatable = false)
    private String name;

    private String description;
    private String icon;
    private String url;

    @OneToMany
    private Set<Account> administrators;

    @OneToMany
    private Set<Definition> definitions;

    @OneToOne
    private Account owner;

    @OneToOne
    private Settings settings;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Transient
    private Long totalUsers;

    @PostLoad
    public void calculateTotalUsers() {
        if (this.uuid != null) {
            AccountRepository accountRepository = ApplicationContextProvider.getApplicationContext()
                    .getBean(AccountRepository.class);
            this.totalUsers = accountRepository.countByRealmUuid(this.uuid);
        } else {
            this.totalUsers = 0L;
        }
    }
}
