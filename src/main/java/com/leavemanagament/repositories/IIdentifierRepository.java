 
package com.leavemanagament.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leavemanagament.entities.IdentifierEntity;

public interface IIdentifierRepository extends JpaRepository<IdentifierEntity, Integer>{

}
