package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.RoleEntity;
public class RolesViewModel {

    public List<RoleEntity> role;

    public RolesViewModel (){
        role = new ArrayList<RoleEntity>();
    }

     public RolesViewModel (
        List<RoleEntity> role1
    ){
        this.role = role1;
    }

    public RolesViewModel convertFromModel(List<RoleEntity> role){
        this.role = role;
        return this;
    }

    public List<RoleEntity> getRoleFromViewModel()
    {
    return this.role;
        }
            
    public List<RoleEntity> convertToModel(){
        return this.role;
    }
}
