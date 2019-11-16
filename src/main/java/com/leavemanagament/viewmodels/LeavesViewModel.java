package com.leavemanagament.viewmodels;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.leavemanagament.entities.LeaveEntity;
public class LeavesViewModel {

    public List<LeaveEntity> leave;

    public LeavesViewModel (){
        leave = new ArrayList<LeaveEntity>();
    }

     public LeavesViewModel (
        List<LeaveEntity> leave1
    ){
        this.leave = leave1;
    }

    public LeavesViewModel convertFromModel(List<LeaveEntity> leave){
        this.leave = leave;
        return this;
    }

    public List<LeaveEntity> getLeaveFromViewModel()
    {
    return this.leave;
        }
            
    public List<LeaveEntity> convertToModel(){
        return this.leave;
    }
}
