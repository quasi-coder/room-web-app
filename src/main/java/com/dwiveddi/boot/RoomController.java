package com.dwiveddi.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/rooms")
public class RoomController {

    private final RoomServices roomServices;
    @Autowired
    public RoomController(RoomServices roomServices){
        super();
        this.roomServices = roomServices;

    }
    @GetMapping
    public String getAllRooms(Model model){
        model.addAttribute("rooms", this.roomServices.getAllRooms());
        return "rooms";
    }


    /*private static List<Room> rooms = new ArrayList<>();
    static{
        for(int i =0;i<10;i++){
            rooms.add(new Room(i,"Room "+i,"R"+i,"Q"));
        }
    }

    @GetMapping
    public List<Room> getAllRooms(Model model){
        model.addAttribute("rooms",rooms);
        return rooms;
    }*/
}
