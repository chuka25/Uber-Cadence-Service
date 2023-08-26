package com.example.Cadence.repository;

import com.example.Cadence.entity.CadenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CadenceRepo extends JpaRepository<CadenceEntity, LocalDateTime> {
}
