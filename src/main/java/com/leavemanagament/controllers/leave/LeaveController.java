package com.leavemanagament.controllers.leave;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leavemanagament.entities.LeaveEntity;
import com.leavemanagament.services.leave.impl.LeaveServiceImpl;

@Controller
public class LeaveController {
    
    @Autowired
    private LeaveServiceImpl leaveServiceImpl;
 
    public LeaveController(LeaveServiceImpl leaveServiceImpl){
        this.leaveServiceImpl = leaveServiceImpl;
    }

    @RequestMapping(value = "/leave", method = RequestMethod.GET)
    public String showAll(Model model){		 
        model.addAttribute("list", leaveServiceImpl.findAll());
        model.addAttribute("title","Leave");
        return "leave/index";
    }

    @RequestMapping(value = "/leave/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model){
        LeaveEntity leaveEntity = leaveServiceImpl.getById(id);
        model.addAttribute("entity", leaveEntity);
        model.addAttribute("title","Leave");
        return "leave/show";
    }

    @RequestMapping(value = "/newleave", method = RequestMethod.GET)
    public String showNewForm(Model model){
        model.addAttribute("entity",new LeaveEntity());
        model.addAttribute("title","Leave");
        return "leave/newform";
    }

    @RequestMapping(value = "/leave/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("leave") LeaveEntity leave, Model model){		
        leaveServiceImpl.save(leave);
        model.addAttribute("title","Leave");
        return "leave/index";
    }

    @RequestMapping(value = "/leave/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        LeaveEntity leaveEntity = leaveServiceImpl.getById(id);
        model.addAttribute("entity", leaveEntity);
        model.addAttribute("title","Leave");
        return "leave/editform";
    }

    @RequestMapping(value = "/leave/edit/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer id, @ModelAttribute("leave") LeaveEntity leave, Model model){		
        leaveServiceImpl.update(id, leave);
        model.addAttribute("title","Leave");
        return "leave/index";
    }

    @RequestMapping(value = "/leave/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id, Model model){		
        leaveServiceImpl.deleteById(id);
        model.addAttribute("title","Leave");
        return "leave/index";
    }
}