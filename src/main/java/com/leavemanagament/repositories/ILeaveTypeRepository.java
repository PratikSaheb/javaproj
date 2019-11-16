 
package com.leavemanagament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagament.entities.LeaveTypeEntity;

public interface ILeaveTypeRepository extends JpaRepository<LeaveTypeEntity, Integer>{

}
