package com.leavemanagament.controllers.role;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leavemanagament.entities.RoleEntity;
import com.leavemanagament.services.role.impl.RoleServiceImpl;

@Controller
public class RoleController {
    
    @Autowired
    private RoleServiceImpl roleServiceImpl;
 
    public RoleController(RoleServiceImpl roleServiceImpl){
        this.roleServiceImpl = roleServiceImpl;
    }

    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public String showAll(Model model){		 
        model.addAttribute("list", roleServiceImpl.findAll());
        model.addAttribute("title","Role");
        return "role/index";
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model){
        RoleEntity roleEntity = roleServiceImpl.getById(id);
        model.addAttribute("entity", roleEntity);
        model.addAttribute("title","Role");
        return "role/show";
    }

    @RequestMapping(value = "/newrole", method = RequestMethod.GET)
    public String showNewForm(Model model){
        model.addAttribute("entity",new RoleEntity());
        model.addAttribute("title","Role");
        return "role/newform";
    }

    @RequestMapping(value = "/role/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("role") RoleEntity role, Model model){		
        roleServiceImpl.save(role);
        model.addAttribute("title","Role");
        return "role/index";
    }

    @RequestMapping(value = "/role/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        RoleEntity roleEntity = roleServiceImpl.getById(id);
        model.addAttribute("entity", roleEntity);
        model.addAttribute("title","Role");
        return "role/editform";
    }

    @RequestMapping(value = "/role/edit/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer id, @ModelAttribute("role") RoleEntity role, Model model){		
        roleServiceImpl.update(id, role);
        model.addAttribute("title","Role");
        return "role/index";
    }

    @RequestMapping(value = "/role/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id, Model model){		
        roleServiceImpl.deleteById(id);
        model.addAttribute("title","Role");
        return "role/index";
    }
}