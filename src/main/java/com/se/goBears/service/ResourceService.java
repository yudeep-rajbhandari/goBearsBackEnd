package com.se.goBears.service;

import com.se.goBears.dao.ResourceDao;
import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    public List<Resource> getResourceByRoom(Room room){
        return resourceDao.findResourceByRoom(room);
    }
}
