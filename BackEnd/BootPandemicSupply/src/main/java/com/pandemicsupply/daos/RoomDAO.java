package com.pandemicsupply.daos;

import java.util.List;

import com.pandemicsupply.entities.FacilityRoom;
import com.pandemicsupply.entities.Room;

public interface RoomDAO {
	FacilityRoom createFRAssociation(int fid, int rid);
	FacilityRoom findFRByFacilityAndRoom(int fid, int rid);
	List<FacilityRoom> findFRByRoom(int rid);
	FacilityRoom updateFR(int fid, int rid, int quantity);
	Room findRoomById(int rid);
	Room createRoom(Room room);
	Room modifyRoom(Room room);
}
