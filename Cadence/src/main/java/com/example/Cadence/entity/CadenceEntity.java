package com.example.Cadence.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Accessors(chain = true)
public class CadenceEntity {
    @Id
    private LocalDateTime createdAt;
    private String city;
    private double airTemperature;
}
