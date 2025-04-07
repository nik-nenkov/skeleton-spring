package com.epsilonnet.restapi.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class Action {
    @Id
    @GeneratedValue
    private UUID uuid;

    private ActType type;

    @ManyToOne
    private Account user;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
}
