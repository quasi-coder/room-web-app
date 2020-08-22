package com.dwiveddi.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServices {
    private final RoomRepository roomRepository;
    @Autowired
    public RoomServices(RoomRepository roomRepository){
        super();
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
        List<Room> rooms = new ArrayList<>();
        this.roomRepository.findAll().forEach(rooms::add);
        return rooms;
    }

    /*private static List<Room> rooms = new ArrayList<>();
    static{
        for(int i =0;i<10;i++){
            rooms.add(new Room(i,"Room "+i,"R"+i,"Q"));
        }
    }

    @GetMapping
    public List<Room> getAllRooms(){
        return rooms;
    }*/

}
