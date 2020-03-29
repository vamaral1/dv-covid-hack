package com.pandemicsupply.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityRoom;
import com.pandemicsupply.entities.Room;

public interface FacilityRoomRepo extends JpaRepository<FacilityRoom, Integer> {
	FacilityRoom findByFacilityAndRoom(Facility facility, Room room);
	List<FacilityRoom> findByFacility(Facility facility);
	List<FacilityRoom> findByRoom(Room room);
}
