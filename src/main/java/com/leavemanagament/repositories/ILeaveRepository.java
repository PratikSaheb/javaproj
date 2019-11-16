 
package com.leavemanagament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagament.entities.LeaveEntity;

public interface ILeaveRepository extends JpaRepository<LeaveEntity, Integer>{

}
