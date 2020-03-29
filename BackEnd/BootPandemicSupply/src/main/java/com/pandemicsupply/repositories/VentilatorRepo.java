package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Ventilator;

public interface VentilatorRepo extends JpaRepository<Ventilator, Integer> {

}
