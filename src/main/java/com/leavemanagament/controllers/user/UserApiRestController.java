package com.leavemanagament.controllers.user;

import java.util.List;
import java.util.ArrayList;

import com.leavemanagament.services.user.IUserService;
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
@RequestMapping("api/leavemanagament/user")
public class UserApiRestController {
    @Autowired
    private IUserService _userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<UserViewModel> create(
        @RequestBody UserViewModel user
        ){
            
        UserEntity _user = user.getUserFromViewModel();
        UserEntity saveduser = _userService.save(_user);
        return new ResponseEntity<UserViewModel>(user.convertFromModel(saveduser), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{userId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<UserViewModel> get(
        @PathVariable Integer userId
        ){
            UserEntity entity = _userService.getById(userId);
        UserViewModel viewmodel = new UserViewModel();
        return new ResponseEntity<UserViewModel>(viewmodel.convertFromModel(entity), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<List<UserViewModel>> list(
        ){
            List<UserViewModel> listToReturn = new ArrayList<UserViewModel>();
            List<UserEntity> list = _userService.findAll();
            list.forEach(item->{
                listToReturn.add(new UserViewModel(item));
            });

            return new ResponseEntity<List<UserViewModel>>(listToReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<UserViewModel> update(
        @RequestBody UserViewModel user
        ){
    	
        UserEntity _user = user.getUserFromViewModel();
        UserEntity updateduser = _userService.save(_user);    
        return new ResponseEntity<UserViewModel>(user.convertFromModel(updateduser), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE, produces = {"application/JSON"})
    public  void delete(
        @PathVariable Integer userId
        ){
        }
}