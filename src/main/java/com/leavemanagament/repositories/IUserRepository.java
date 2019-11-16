 
package com.leavemanagament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagament.entities.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

}
