package com.se.goBears.service;

//import com.se.goBears.entity.Resource;
import com.se.goBears.entity.User;
import com.se.goBears.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
    UserRepository userRepository;
          public User updateRole(Long userId){
                User user = userRepository.findUserById(userId);
//                user.setRoles();
                  return null;
          }


          public User findUserByEmail(String email){
            return  userRepository.findUserByEmail(email);
          }


          public List<User> findAllUser(){
              return userRepository.findAll();
          }

          public User findUserById(Long id){
              return userRepository.findUserById(id);
          }

}
