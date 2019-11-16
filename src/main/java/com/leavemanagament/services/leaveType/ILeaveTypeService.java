package com.leavemanagament.services.leaveType;

import java.util.List;

import com.leavemanagament.entities.LeaveTypeEntity;

public interface ILeaveTypeService {
    public List<LeaveTypeEntity> findAll();
    public LeaveTypeEntity getById(Integer id);
    public LeaveTypeEntity save(LeaveTypeEntity leavetype);
    public LeaveTypeEntity update(Integer id, LeaveTypeEntity leavetype);
    public void deleteById(Integer id);
}