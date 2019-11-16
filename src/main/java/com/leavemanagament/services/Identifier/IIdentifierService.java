package com.leavemanagament.services.Identifier;

import java.util.List;

import com.leavemanagament.entities.IdentifierEntity;

public interface IIdentifierService {
    public List<IdentifierEntity> findAll();
    public IdentifierEntity getById(Integer id);
    public IdentifierEntity save(IdentifierEntity identifier);
    public IdentifierEntity update(Integer id, IdentifierEntity identifier);
    public void deleteById(Integer id);
}