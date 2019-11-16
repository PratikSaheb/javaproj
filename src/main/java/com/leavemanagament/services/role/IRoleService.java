package com.leavemanagament.services.role;

import java.util.List;

import com.leavemanagament.entities.RoleEntity;

public interface IRoleService {
    public List<RoleEntity> findAll();
    public RoleEntity getById(Integer id);
    public RoleEntity save(RoleEntity role);
    public RoleEntity update(Integer id, RoleEntity role);
    public void deleteById(Integer id);
}