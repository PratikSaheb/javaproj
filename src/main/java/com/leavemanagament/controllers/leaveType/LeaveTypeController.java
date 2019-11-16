package com.leavemanagament.controllers.leaveType;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leavemanagament.entities.LeaveTypeEntity;
import com.leavemanagament.services.leaveType.LeaveTypeService;

@Controller
public class LeaveTypeController {
    
    @Autowired
    private LeaveTypeService leaveTypeService;
 
    public LeaveTypeController(LeaveTypeService leaveTypeService){
        this.leaveTypeService = leaveTypeService;
    }

    @RequestMapping(value = "/leavetype", method = RequestMethod.GET)
    public String showAll(Model model){		 
        model.addAttribute("list",leaveTypeService.findAll());
        model.addAttribute("title","LeaveType");
        return "leavetype/index";
    }

    @RequestMapping(value = "/leavetype/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model){
        LeaveTypeEntity leaveTypeEntity = leaveTypeService.getById(id);
        model.addAttribute("entity", leaveTypeEntity);
        model.addAttribute("title","LeaveType");
        return "leavetype/show";
    }

    @RequestMapping(value = "/newleavetype", method = RequestMethod.GET)
    public String showNewForm(Model model){
        model.addAttribute("entity",new LeaveTypeEntity());
        model.addAttribute("title","LeaveType");
        return "leavetype/newform";
    }

    @RequestMapping(value = "/leavetype/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("leavetype") LeaveTypeEntity leavetype, Model model){		
        leaveTypeService.save(leavetype);
        model.addAttribute("title","LeaveType");
        return "leavetype/index";
    }

    @RequestMapping(value = "/leavetype/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model){
        LeaveTypeEntity leaveTypeEntity = leaveTypeService.getById(id);
        model.addAttribute("entity", leaveTypeEntity);
        model.addAttribute("title","LeaveType");
        return "leavetype/editform";
    }

    @RequestMapping(value = "/leavetype/edit/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Integer id, @ModelAttribute("leavetype") LeaveTypeEntity leavetype, Model model){		
        leaveTypeService.update(id, leavetype);
        model.addAttribute("title","LeaveType");
        return "leavetype/index";
    }

    @RequestMapping(value = "/leavetype/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id, Model model){		
        leaveTypeService.deleteById(id);
        model.addAttribute("title","LeaveType");
        return "leavetype/index";
    }
}