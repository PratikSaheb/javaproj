package com.leavemanagament.services.leave;

import java.util.List;

import com.leavemanagament.entities.LeaveEntity;

public interface LeaveService {
    public List<LeaveEntity> findAll();
    public LeaveEntity getById(Integer id);
    public LeaveEntity save(LeaveEntity leave);
    public LeaveEntity update(Integer id, LeaveEntity leave);
    public void deleteById(Integer id);
}