package com.leavemanagament.services.leave.impl;

import java.util.List;

import com.leavemanagament.services.leave.LeaveService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import com.leavemanagament.repositories.ILeaveRepository;
import com.leavemanagament.entities.LeaveEntity;

@Component
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private ILeaveRepository leaveRepository;

    public List<LeaveEntity> findAll(){
        return leaveRepository.findAll();
    }

    public LeaveEntity getById(Integer id){
        return leaveRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("LeaveEntity", "No LeaveEntity found with id="+id, String.valueOf(id)));
    }

    public LeaveEntity save(LeaveEntity leave){
        return leaveRepository.save(leave);
    }

    public LeaveEntity update(Integer id, LeaveEntity leave){
        leaveRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("LeaveEntity", "No LeaveEntity found with id="+id, String.valueOf(id)));

        return leaveRepository.save(leave);
    }

    public void deleteById(Integer id){
        leaveRepository.deleteById(id);
    }
}
