package com.leavemanagament.services.user;

import java.util.List;

import com.leavemanagament.entities.UserEntity;

public interface IUserService {
    public List<UserEntity> findAll();
    public UserEntity getById(Integer id);
    public UserEntity save(UserEntity user);
    public UserEntity update(Integer id, UserEntity user);
    public void deleteById(Integer id);
}