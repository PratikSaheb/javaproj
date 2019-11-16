package com.leavemanagament.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leavemanagament.entities.UserEntity;
import com.leavemanagament.services.user.impl.UserServiceImpl;

@Controller
public class UserController {
    
    @Autowired
    private UserServiceImpl userServiceImpl;
 
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showAll(Model model){		 
        model.addAttribute("list", userServiceImpl.findAll());
        model.addAttribute("title","User");
        return "user/index";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model){
        UserEntity userEntity = userServiceImpl.getById(id);
        model.addAttribute("entity", userEntity);
        model.addAttribute("title","User");
        return "user/show";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String showNewForm(Model model){
        model.addAttribute("entity",new UserEntity());
        model.addAttribute("title","User");
        return "user/newform";
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") UserEntity user, Model model){		
        userServiceImpl.save(user);
        model.addAttribute("title","User");
        return "user/index";
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        UserEntity userEntity = userServiceImpl.getById(id);
        model.addAttribute("entity", userEntity);
        model.addAttribute("title","User");
        return "user/editform";
    }

    @RequestMapping(value = "/user/edit/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer id, @ModelAttribute("user") UserEntity user, Model model){		
        userServiceImpl.update(id, user);
        model.addAttribute("title","User");
        return "user/index";
    }

    @RequestMapping(value = "/user/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id, Model model){		
        userServiceImpl.deleteById(id);
        model.addAttribute("title","User");
        return "user/index";
    }
}