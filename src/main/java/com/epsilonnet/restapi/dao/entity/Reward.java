package com.epsilonnet.restapi.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class Reward {
    @Id
    @GeneratedValue
    private UUID uuid;

    private BigDecimal amount;
    private Boolean claimed = false;
    private Timestamp claimDate;
    private Boolean expired = false;
    private Long expirationTime;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
}
