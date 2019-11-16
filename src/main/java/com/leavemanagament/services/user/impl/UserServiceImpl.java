package com.leavemanagament.services.user.impl;

import java.util.List;

import com.leavemanagament.services.user.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import com.leavemanagament.repositories.IUserRepository;
import com.leavemanagament.entities.UserEntity;

@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity getById(Integer id){
        return userRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("UserEntity", "No UserEntity found with id="+id, String.valueOf(id)));
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public UserEntity update(Integer id, UserEntity user){
        userRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("UserEntity", "No UserEntity found with id="+id, String.valueOf(id)));

        return userRepository.save(user);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }
}
