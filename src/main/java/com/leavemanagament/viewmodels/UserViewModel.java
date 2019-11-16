package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.UserEntity;
public class UserViewModel {
    public UserEntity user;

    public UserViewModel (){
        user = new UserEntity();
    }

     public UserViewModel (
        UserEntity user1
    ){
        this.user = user1;
    }

    public UserViewModel convertFromModel(UserEntity user){
        this.user = user;
        return this;
    }

    public UserEntity getUserFromViewModel()
    {
    return this.user;
        }
            
    public UserEntity convertToModel(){
        return this.user;
    }
}
