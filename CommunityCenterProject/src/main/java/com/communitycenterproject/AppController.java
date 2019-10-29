package com.communitycenterproject;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController {
	@Autowired
    private ProgramService service;
     
    // handler methods...
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Program> listProgram = service.listAll();
        model.addAttribute("listProgram", listProgram);
         
        return "dashboard";
    }
    
    @RequestMapping("/new")
    public String showNewProgramPage(Model model) {
        Program program = new Program();
        model.addAttribute("program", program);
         
        return "new_program";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateProgram(@ModelAttribute("program") Program program) {
        service.save(program);
         
        return "redirect:/";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProgram(@ModelAttribute("program") Program program) {
        service.save(program);
         
        return "redirect:/";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProgramtPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_Program");
        Program program = service.get(id);
        mav.addObject("program", program);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProgram(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";       
    }
    
}
