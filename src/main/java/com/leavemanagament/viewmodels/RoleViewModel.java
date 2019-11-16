package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.RoleEntity;
public class RoleViewModel {
    public RoleEntity role;

    public RoleViewModel (){
        role = new RoleEntity();
    }

     public RoleViewModel (
        RoleEntity role1
    ){
        this.role = role1;
    }

    public RoleViewModel convertFromModel(RoleEntity role){
        this.role = role;
        return this;
    }

    public RoleEntity getRoleFromViewModel()
    {
    return this.role;
        }
            
    public RoleEntity convertToModel(){
        return this.role;
    }
}
