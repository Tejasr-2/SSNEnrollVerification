package com.raj.enrollandverification.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.enrollandverification.entities.CitizenEntity;

@Repository
public interface CitizenRepo extends JpaRepository<CitizenEntity, Serializable> {


}
