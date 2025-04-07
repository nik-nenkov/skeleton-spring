package com.epsilonnet.restapi.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Settings {
    @Id
    @GeneratedValue
    private UUID uuid;

    private BigDecimal miningSpeed;
    private Long halvingUserCount;
    private Long miningInterval;
    private Long adsWatchInterval;
    private Long adsWatchMinReward;
    private Long adsWatchMaxReward;

    private String timezone;
}
