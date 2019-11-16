package com.leavemanagament.services.leaveType;

import java.util.List;

import com.leavemanagament.services.leaveType.ILeaveTypeService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import com.leavemanagament.repositories.ILeaveTypeRepository;
import com.leavemanagament.entities.LeaveTypeEntity;

@Component
public class LeaveTypeService implements ILeaveTypeService {
    @Autowired
    private ILeaveTypeRepository leaveTypeRepository;

    public List<LeaveTypeEntity> findAll(){
        return leaveTypeRepository.findAll();
    }

    public LeaveTypeEntity getById(Integer id){
        return leaveTypeRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("LeaveTypeEntity", "No LeaveTypeEntity found with id="+id, String.valueOf(id)));
    }

    public LeaveTypeEntity save(LeaveTypeEntity leavetype){
        return leaveTypeRepository.save(leavetype);
    }

    public LeaveTypeEntity update(Integer id, LeaveTypeEntity leavetype){
        leaveTypeRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("LeaveTypeEntity", "No LeaveTypeEntity found with id="+id, String.valueOf(id)));

        return leaveTypeRepository.save(leavetype);
    }

    public void deleteById(Integer id){
        leaveTypeRepository.deleteById(id);
    }
}
