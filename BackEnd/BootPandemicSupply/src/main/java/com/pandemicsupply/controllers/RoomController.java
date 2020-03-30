package com.pandemicsupply.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandemicsupply.daos.RoomDAO;
import com.pandemicsupply.entities.FacilityRoom;
import com.pandemicsupply.entities.Room;

@RestController
@RequestMapping(path = "srsapi")
public class RoomController {

	@Autowired
	private RoomDAO rDAO;

	// rooms
	// single room 
	@GetMapping(path = "rooms/{rid}")
	public Room roomById(@PathVariable int rid) {
		return rDAO.findRoomById(rid);
	}
	
	// all possible room options
	@GetMapping(path = "rooms")
	public List<Room> getAllRooms() {
		return rDAO.findAllRooms();
	}
	
	// create new room
	@PostMapping(path = "rooms")
	public Room newRoom(@RequestBody Room room, HttpServletRequest req, HttpServletResponse resp) {
		room = rDAO.createRoom(room);

		if (room == null) {
			resp.setStatus(400);
		} else {
			resp.setStatus(202);
		}
		return room;
	}

	// update room
	@PatchMapping(path = "rooms")
	public Room updateRoom(@RequestBody Room room) {
		return rDAO.modifyRoom(room);
	}

	// facility mask inventory
	
	// inventory for single room type at facility
	@GetMapping(path = "facilities/{fid}/rooms/{rid}")
	public FacilityRoom facilitySingleMaskInventory(@PathVariable int fid, @PathVariable int rid) {
		FacilityRoom fr = rDAO.findFRByFacilityAndRoom(fid, rid);

		if (fr == null) {
			return rDAO.createFRAssociation(fid, rid);
		}

		return fr;
	}
	
	// list of inventories of all room types at a facility
	@GetMapping(path = "facilities/{fid}/rooms")
	public List<FacilityRoom> findAllAvailableRoomInventoriesAtFacility(@PathVariable int fid){
		return rDAO.findFRByFacility(fid);
	}

	// show all facility inventories of a given type of room
	@GetMapping(path = "facilities/rooms/{rid}")
	public List<FacilityRoom> findFacilitiesByRoom(@PathVariable int rid) {
		return rDAO.findFRByRoom(rid);
	}

	// update the room inventory for a specific hospital, with an amount
	@PatchMapping(path = "facilities/{fid}/rooms/{rid}/{quantity}")
	public FacilityRoom updateFacilityRoomInventory(@PathVariable int fid, @PathVariable int rid,
			@PathVariable int quantity) {
		return rDAO.updateFR(fid, rid, quantity);
	}

}
