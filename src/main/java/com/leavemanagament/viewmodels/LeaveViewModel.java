package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.LeaveEntity;
public class LeaveViewModel {
    public LeaveEntity leave;

    public LeaveViewModel (){
        leave = new LeaveEntity();
    }

     public LeaveViewModel (
        LeaveEntity leave1
    ){
        this.leave = leave1;
    }

    public LeaveViewModel convertFromModel(LeaveEntity leave){
        this.leave = leave;
        return this;
    }

    public LeaveEntity getLeaveFromViewModel()
    {
    return this.leave;
        }
            
    public LeaveEntity convertToModel(){
        return this.leave;
    }
}
