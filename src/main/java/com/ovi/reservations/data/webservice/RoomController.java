package com.ovi.reservations.data.webservice;

import com.ovi.reservations.data.entity.Room;
import com.ovi.reservations.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    List<Room> findAll(@RequestParam(required = false) String roomNumber) {
        List<Room> roomList = new ArrayList<>();
        if (null == roomNumber) {
            Iterable<Room> results = this.roomRepository.findAll();
            results.forEach(roomList::add);
        }
        else {
            Room room = this.roomRepository.findByRoomNumber(roomNumber);
            if (null != room) {
                roomList.add(room);
            }
        }
        return roomList;
    }
}
