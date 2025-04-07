package com.epsilonnet.restapi.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account referral;

    @ManyToOne
    private Realm realm;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "referral")
    private Set<Account> referrals;

    private BigDecimal balance;

    private AccRole role;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Reward> rewards;

    @OneToOne
    private Contact contact;

    private String referralCode;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @BatchSize(size = 100)
    private List<Action> actions;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
