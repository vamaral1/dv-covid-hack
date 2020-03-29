package com.pandemicsupply.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pandemicsupply.entities.Facility;
import com.pandemicsupply.entities.FacilityRoom;
import com.pandemicsupply.entities.Room;
import com.pandemicsupply.repositories.FacilityRepository;
import com.pandemicsupply.repositories.FacilityRoomRepo;
import com.pandemicsupply.repositories.RoomRepo;

@Service
public class RoomDAOImpl implements RoomDAO{
	
	@Autowired
	private FacilityRepository fRepo;
	
	@Autowired
	private FacilityRoomRepo frRepo;
	
	@Autowired
	private RoomRepo rRepo;

	@Override
	public FacilityRoom createFRAssociation(int fid, int rid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Room> r = rRepo.findById(rid);
		
		if (f.isPresent() && r.isPresent()) {
			FacilityRoom fr = new FacilityRoom(f.get(), r.get());
			return frRepo.saveAndFlush(fr);
		}
		
		return null;
	}

	@Override
	public FacilityRoom findFRByFacilityAndRoom(int fid, int rid) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Room> r = rRepo.findById(rid);
		
		if (f.isPresent() && r.isPresent()) {
			FacilityRoom fr = frRepo.findByFacilityAndRoom(f.get(), r.get());
			if (fr == null) {
				fr = new FacilityRoom(f.get(), r.get());
				frRepo.saveAndFlush(fr);
			}
			return fr;
		}
		
		return null;
	}

	@Override
	public List<FacilityRoom> findFRByFacility(int fid) {
		Optional<Facility> optFacility = fRepo.findById(fid);
		if (optFacility.isPresent()) {
			return frRepo.findByFacility(optFacility.get());
		}
		return null;
	}
	
	@Override
	public List<FacilityRoom> findFRByRoom(int rid) {
		Optional<Room> room = rRepo.findById(rid);
		if (room.isPresent()) {
			return frRepo.findByRoom(room.get());
		}
		return null;
	}

	@Override
	public FacilityRoom updateFR(int fid, int rid, int quantity) {
		Optional<Facility> f = fRepo.findById(fid);
		Optional<Room> r = rRepo.findById(rid);
		
		if (f.isPresent() && r.isPresent()) {
			FacilityRoom fr = frRepo.findByFacilityAndRoom(f.get(), r.get());
			if (fr == null) {
				fr = new FacilityRoom(f.get(), r.get());
			}
			fr.setQuantity(quantity);
			return frRepo.saveAndFlush(fr);
		}
		
		return null;
	}

	@Override
	public Room findRoomById(int rid) {
		Optional<Room> room = rRepo.findById(rid);
		
		if (room.isPresent()) {
			return room.get();
		}
		
		return null;
	}
	
	@Override
	public List<Room> findAllRooms() {
		return rRepo.findAll();
	}

	@Override
	public Room createRoom(Room room) {
		return rRepo.saveAndFlush(room);
	}

	@Override
	public Room modifyRoom(Room room) {
		Optional<Room> optionalRoom = rRepo.findById(room.getId());
		
		if (optionalRoom.isPresent()) {
			Room managedRoom = optionalRoom.get();
			managedRoom.setIcu(room.getIcu());
			managedRoom.setNegativePressure(room.getNegativePressure());
			return rRepo.saveAndFlush(managedRoom);
		}
		
		return null;
	}

}
