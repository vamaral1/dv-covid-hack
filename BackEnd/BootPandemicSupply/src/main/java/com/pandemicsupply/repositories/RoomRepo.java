package com.pandemicsupply.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

}
