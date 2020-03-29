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
import com.pandemicsupply.entities.FacilityMask;
import com.pandemicsupply.entities.FacilityRoom;
import com.pandemicsupply.entities.Room;

@RestController
@RequestMapping(path = "srsapi")
public class RoomController {

	@Autowired
	private RoomDAO rDAO;

	// rooms
	@GetMapping(path = "rooms/{rid}")
	public Room roomById(@PathVariable int rid) {
		return rDAO.findRoomById(rid);
	}

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

	@PatchMapping(path = "rooms")
	public Room updateRoom(@RequestBody Room room) {
		return rDAO.modifyRoom(room);
	}

	// facility mask inventory
	@GetMapping(path = "facilities/{fid}/rooms/{rid}")
	public FacilityRoom facilitySingleMaskInventory(@PathVariable int fid, @PathVariable int rid) {
		FacilityRoom fr = rDAO.findFRByFacilityAndRoom(fid, rid);

		if (fr == null) {
			return rDAO.createFRAssociation(fid, rid);
		}

		return fr;
	}

	@GetMapping(path = "facilities/rooms/{rid}")
	public List<FacilityRoom> findFacilitiesByRoom(@PathVariable int rid) {
		return rDAO.findFRByRoom(rid);
	}

	@PatchMapping(path = "facilities/{fid}/rooms/{rid}/{quantity}")
	public FacilityRoom updateFacilityRoomInventory(@PathVariable int fid, @PathVariable int rid,
			@PathVariable int quantity) {
		return rDAO.updateFR(fid, rid, quantity);
	}

}
