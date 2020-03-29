package com.pandemicsupply.repositories;

import com.pandemicsupply.entities.Bed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed, Integer> {
}
