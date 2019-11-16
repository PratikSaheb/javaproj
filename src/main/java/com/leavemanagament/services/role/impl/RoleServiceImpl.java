package com.leavemanagament.services.role.impl;

import java.util.List;

import com.leavemanagament.services.role.IRoleService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import com.leavemanagament.repositories.IRoleRepository;
import com.leavemanagament.entities.RoleEntity;

@Component
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    public List<RoleEntity> findAll(){
        return roleRepository.findAll();
    }

    public RoleEntity getById(Integer id){
        return roleRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("RoleEntity", "No RoleEntity found with id="+id, String.valueOf(id)));
    }

    public RoleEntity save(RoleEntity role){
        return roleRepository.save(role);
    }

    public RoleEntity update(Integer id, RoleEntity role){
        roleRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("RoleEntity", "No RoleEntity found with id="+id, String.valueOf(id)));

        return roleRepository.save(role);
    }

    public void deleteById(Integer id){
        roleRepository.deleteById(id);
    }
}
