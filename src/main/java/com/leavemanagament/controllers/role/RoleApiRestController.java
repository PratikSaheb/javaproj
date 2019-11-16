package com.leavemanagament.controllers.role;

import java.util.List;
import java.util.ArrayList;

import com.leavemanagament.services.role.IRoleService;
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
@RequestMapping("api/leavemanagament/role")
public class RoleApiRestController {
    @Autowired
    private IRoleService _roleService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<RoleViewModel> create(
        @RequestBody RoleViewModel role
        ){
            
        RoleEntity _role = role.getRoleFromViewModel();
        RoleEntity savedrole = _roleService.save(_role);
        return new ResponseEntity<RoleViewModel>(role.convertFromModel(savedrole), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{roleId}", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<RoleViewModel> get(
        @PathVariable Integer roleId
        ){
            RoleEntity entity = _roleService.getById(roleId);
        RoleViewModel viewmodel = new RoleViewModel();
        return new ResponseEntity<RoleViewModel>(viewmodel.convertFromModel(entity), HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<List<RoleViewModel>> list(
        ){
            List<RoleViewModel> listToReturn = new ArrayList<RoleViewModel>();
            List<RoleEntity> list = _roleService.findAll();
            list.forEach(item->{
                listToReturn.add(new RoleViewModel(item));
            });

            return new ResponseEntity<List<RoleViewModel>>(listToReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = {"application/JSON"})
    public @ResponseBody ResponseEntity<RoleViewModel> update(
        @RequestBody RoleViewModel role
        ){
    	
        RoleEntity _role = role.getRoleFromViewModel();
        RoleEntity updatedrole = _roleService.save(_role);    
        return new ResponseEntity<RoleViewModel>(role.convertFromModel(updatedrole), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{roleId}", method = RequestMethod.DELETE, produces = {"application/JSON"})
    public  void delete(
        @PathVariable Integer roleId
        ){
        }
}