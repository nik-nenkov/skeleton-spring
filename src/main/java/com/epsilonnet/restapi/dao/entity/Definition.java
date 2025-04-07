package com.epsilonnet.restapi.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
public class Definition {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String name;
    private String description;
    private String icon;
    private String url;

    @OneToMany
    private Set<Definition> subSet;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
