package com.leavemanagament.services.Identifier.impl;

import java.util.List;

import com.leavemanagament.services.Identifier.IIdentifierService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import com.leavemanagament.repositories.IIdentifierRepository;
import com.leavemanagament.entities.IdentifierEntity;

@Component
public class IdentifierServiceImpl implements IIdentifierService {
    @Autowired
    private IIdentifierRepository identifierRepository;

    public List<IdentifierEntity> findAll(){
        return identifierRepository.findAll();
    }

    public IdentifierEntity getById(Integer id){
        return identifierRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("IdentifierEntity", "No IdentifierEntity found with id="+id, String.valueOf(id)));
    }

    public IdentifierEntity save(IdentifierEntity identifier){
        return identifierRepository.save(identifier);
    }

    public IdentifierEntity update(Integer id, IdentifierEntity identifier){
        identifierRepository.findById(id)
                    .orElseThrow(()->new InvalidConfigurationPropertyValueException("IdentifierEntity", "No IdentifierEntity found with id="+id, String.valueOf(id)));

        return identifierRepository.save(identifier);
    }

    public void deleteById(Integer id){
        identifierRepository.deleteById(id);
    }
}
