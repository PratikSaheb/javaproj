package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.UserEntity;
public class UsersViewModel {

    public List<UserEntity> user;

    public UsersViewModel (){
        user = new ArrayList<UserEntity>();
    }

     public UsersViewModel (
        List<UserEntity> user1
    ){
        this.user = user1;
    }

    public UsersViewModel convertFromModel(List<UserEntity> user){
        this.user = user;
        return this;
    }

    public List<UserEntity> getUserFromViewModel()
    {
    return this.user;
        }
            
    public List<UserEntity> convertToModel(){
        return this.user;
    }
}
