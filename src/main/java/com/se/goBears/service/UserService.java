package com.se.goBears.service;

import com.se.goBears.dao.UserDao;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

//    void save(User user);
//
//    User findByUsername(String username);

    @Autowired
    private UserDao userDao;

    @Autowired
    private Roomservice roomservice;
    public User allotUserToRoom(String username,String roomName, String resourceName){
        User  user = userDao.findByUsername(username);
        Room room = roomservice.getRoomByName(roomName);
        List<Resource> resourceList = room.getResources().stream().collect(Collectors.toList());
        user.setRoom(room);
        for(Resource resource:resourceList){
            if(resource.getName().equals(resourceName)){
                resource.setUser(user);
            }
        }
        return user;
    }

}
