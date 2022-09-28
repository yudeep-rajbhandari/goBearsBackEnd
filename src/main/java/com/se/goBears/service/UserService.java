package com.se.goBears.service;

import com.se.goBears.dao.UserDao;
//import com.se.goBears.entity.Resource;
import com.se.goBears.entity.Room;
import com.se.goBears.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public interface UserService {

    void save(User user);

    User findByUsername(String username);


}
