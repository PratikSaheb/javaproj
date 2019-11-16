package com.leavemanagament.controllers.leave;

import java.util.List;
import java.util.ArrayList;

import com.leavemanagament.services.leave.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leavemanagament.entities.*;
import com.leavemanagament.viewmodels.*;

@RestController
@RequestMapping("api/leavemanagament/leave")
public class LeaveApiRestController {
    @Autowired
    private LeaveService _leaveService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<LeaveViewModel> create(
        @RequestBody LeaveViewModel leave
        ){
            
        LeaveEntity _leave = leave.getLeaveFromViewModel();
        LeaveEntity savedleave = _leaveService.save(_leave);
        return new ResponseEntity<LeaveViewModel>(leave.convertFromModel(savedleave), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{leaveId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<LeaveViewModel> get(
        @PathVariable Integer leaveId
        ){
            LeaveEntity entity = _leaveService.getById(leaveId);
        LeaveViewModel viewmodel = new LeaveViewModel();
        return new ResponseEntity<LeaveViewModel>(viewmodel.convertFromModel(entity), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<List<LeaveViewModel>> list(
        ){
            List<LeaveViewModel> listToReturn = new ArrayList<LeaveViewModel>();
            List<LeaveEntity> list = _leaveService.findAll();
            list.forEach(item->{
                listToReturn.add(new LeaveViewModel(item));
            });

            return new ResponseEntity<List<LeaveViewModel>>(listToReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<LeaveViewModel> update(
        @RequestBody LeaveViewModel leave
        ){
    	
        LeaveEntity _leave = leave.getLeaveFromViewModel();
        LeaveEntity updatedleave = _leaveService.save(_leave);    
        return new ResponseEntity<LeaveViewModel>(leave.convertFromModel(updatedleave), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{leaveId}", method = RequestMethod.DELETE, produces = {"application/JSON"})
    public  void delete(
        @PathVariable Integer leaveId
        ){
        }
}